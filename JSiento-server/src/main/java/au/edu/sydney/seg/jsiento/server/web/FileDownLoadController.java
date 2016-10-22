package au.edu.sydney.seg.jsiento.server.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;
import au.edu.sydney.seg.jsiento.server.model.EntityUsers;
import au.edu.sydney.seg.jsiento.server.service.UserFeatureManager;


@Controller
public class FileDownLoadController {

	@Autowired
	private UserFeatureManager userFeatureManager;
	
	private static final Logger logger = LoggerFactory.getLogger(FileDownLoadController.class);
	
	@RequestMapping("/download")
	public void download(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//if you login in as user , you will have userid from session
			  EntityUsers user = (EntityUsers) request.getSession().getAttribute("userdetail");
			  int userId = user.getId();
			  List<EntityBioFeatures> bf_list = (List<EntityBioFeatures>) request.getSession().getAttribute("bflist");

//			  int userId = 123;
			  response.setContentType("application/x-excel");
			  String filename = user.getName() + " "+ new Date().toGMTString()+ ".xls";
		      response.setHeader("Content-Disposition", "attachment; filename=" + filename); 
		      getExcelFromUser(user, bf_list).write(response.getOutputStream());
		      response.flushBuffer();
		    } catch (IOException ex) {
		      throw new RuntimeException("IOError writing file to output stream");
		    }
	}
	
	private Workbook getExcelFromUser(EntityUsers user, List<EntityBioFeatures> bf_list){
//		EntityUsers eu = userFeatureManager.queryUserById(userId);
		
		
		// create a new workbook
		Workbook wb = new HSSFWorkbook();
		// create a new sheet
		Sheet firstSheet = wb.createSheet();
		Sheet secondSheet = wb.createSheet();
		//set sheet title
		wb.setSheetName(0, "User Profile");
		wb.setSheetName(1, "Bio Features");

		// declare a row object reference
		Row r = null;


		// declare a cell object reference
		Cell c = null;
		// create 3 cell styles
		CellStyle cs = wb.createCellStyle();
		DataFormat df = wb.createDataFormat();
		// create 2 fonts objects
		Font f = wb.createFont();
		//set font 1 to 12 point type
		f.setFontHeightInPoints((short) 12);
		//make it blue
		f.setColor( (short)0xc );
		//set cell stlye
		cs.setFont(f);
		//set the cell format 
		cs.setDataFormat(df.getFormat("#,##0.0"));
		
		/**
		 * set data for the excel
		 */
		List<String> username = new ArrayList<String>();
		username.add("User Name");
		username.add(user.getName());
		createRowAndCell(firstSheet,r,c,cs,0,username);
		
		List<String> userID = new ArrayList<String>();
		userID.add("User ID");
		userID.add(Integer.toString(user.getId()));
		createRowAndCell(firstSheet,r,c,cs,1,userID);
		
		List<String> gender = new ArrayList<String>();
		gender.add("Gender");
		gender.add(user.getGender());
		createRowAndCell(firstSheet,r,c,cs,2,gender);

		List<String> jobTitle = new ArrayList<String>();
		jobTitle.add("Job Title");
		jobTitle.add(user.getJob_title());
		createRowAndCell(firstSheet,r,c,cs,3,jobTitle);
		
		List<String> description = new ArrayList<String>();
		description.add("Description");
		description.add(user.getDescp());
		createRowAndCell(firstSheet,r,c,cs,4,description);
		
		List<String> foodPreference = new ArrayList<String>();
		foodPreference.add("Food Preference");
		foodPreference.add(user.getFood_preference());
		createRowAndCell(firstSheet,r,c,cs,5,foodPreference);
		
		List<String> callLink = new ArrayList<String>();
		callLink.add("Call Link");
		callLink.add(user.getCall_link());
		createRowAndCell(firstSheet,r,c,cs,6,callLink);
		
		List<String> title = new ArrayList<String>();
		title.add("ID");
		title.add("Hr Max");
		title.add("Hr Mean");
		title.add("Hr Min");
		title.add("Hr Range");
		title.add("Hr Std");
		title.add("Hr Variance");
		title.add("Sc Max");
		title.add("Sc Mean");
		title.add("Sc Min");
		title.add("Sc Range");
		title.add("Sc Std");
		title.add("Sc Variance");
		title.add("TimeStamp");
		createRowAndCell(secondSheet,r,c,cs,0,title);

		for(int i=0; i< bf_list.size(); i++)
		{
			List<String> bioFeature = new ArrayList<String>();
			bioFeature.add(Long.toString(bf_list.get(i).getId()));
			bioFeature.add(bf_list.get(i).getHrMax().toString());
			bioFeature.add(bf_list.get(i).getHrMean().toString());
			bioFeature.add(bf_list.get(i).getHrMin().toString());
			bioFeature.add(bf_list.get(i).getHrRange().toString());
			bioFeature.add(bf_list.get(i).getHrSTD().toString());
			bioFeature.add(bf_list.get(i).getHrVar().toString());
			bioFeature.add(bf_list.get(i).getScMax().toString());
			bioFeature.add(bf_list.get(i).getScMean().toString());
			bioFeature.add(bf_list.get(i).getScMin().toString());
			bioFeature.add(bf_list.get(i).getScRange().toString());
			bioFeature.add(bf_list.get(i).getScSTD().toString());
			bioFeature.add(bf_list.get(i).getScVar().toString());
			bioFeature.add(bf_list.get(i).getTimeStamp().toString());
			createRowAndCell(secondSheet,r,c,cs,i+1,bioFeature);
		}

		return wb;
	}
	
	private void createRowAndCell(Sheet s, Row r, Cell c,CellStyle cs,int rowNum,List<String> value){
		//row 
		r = s.createRow(rowNum);
		//cell 
		for(int i=0;i<value.size();i++){
			c = r.createCell(i);
	        c.setCellStyle(cs);
	        c.setCellValue(value.get(i));
		}
				
	}

	public UserFeatureManager getUserFeatureManager() {
		return userFeatureManager;
	}

	public void setUserFeatureManager(UserFeatureManager userFeatureManager) {
		this.userFeatureManager = userFeatureManager;
	}
	
	
}
