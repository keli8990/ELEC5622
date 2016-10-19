package au.edu.sydney.seg.jsiento.server.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;
import au.edu.sydney.seg.jsiento.server.model.EntityUsers;
import au.edu.sydney.seg.jsiento.server.service.DBBioFeaturesManager;
import au.edu.sydney.seg.jsiento.server.service.UserFeatureManager;

@Controller
public class UserController {
	@Resource(name = "UserFeaturesManager")
	private UserFeatureManager userFeatureManager;

	@Resource(name = "BioFeaturesManager")
	private DBBioFeaturesManager BioFeaturesManager;

	private String path;

	private String myfileContentType;
	private String myfileFileName;
	private String savepath;
	private String realpath;
	private String fileName;
	
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMyfileContentType() {
		return myfileContentType;
	}

	public void setMyfileContentType(String myfileContentType) {
		this.myfileContentType = myfileContentType;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public String getRealpath() {
		return realpath;
	}

	public void setRealpath(String realpath) {
		this.realpath = realpath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@RequestMapping(value = "userlogin", method = RequestMethod.POST)
	public String userLogin(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		userFeatureManager.loginToTheSys(name, pwd);
		EntityUsers user = userFeatureManager.queryUserByName(name);
		request.getSession().setAttribute("biouser", user);

		return "home";
	}

	@RequestMapping(value = "userslist")
	public String userList(HttpServletRequest request, HttpServletResponse response) {
		List<EntityUsers> userlist = userFeatureManager.queryAllUser();
		request.getSession().setAttribute("userlist", userlist);
		return "users";
	}

	@RequestMapping(value = "user_userslist")
	public String userUserList(HttpServletRequest request, HttpServletResponse response) {
		int user_id = (Integer) request.getSession().getAttribute("userid");
		EntityUsers user = userFeatureManager.queryUserById(user_id);

		request.getSession().setAttribute("userdetail", user);
		request.getSession().setAttribute("un", user.getName());
		
		List<EntityBioFeatures> bf_list = BioFeaturesManager.queryAll();
		System.out.println("bfSize:" + bf_list.size());
		request.getSession().setAttribute("bflist", bf_list);

		List<Double> scrange = new ArrayList<Double>();
		List<Double> scmax = new ArrayList<Double>();
		List<Double> scmean = new ArrayList<Double>();
		List<Double> scmin = new ArrayList<Double>();
		List<Double> scstd = new ArrayList<Double>();
		List<Double> scvar = new ArrayList<Double>();

		List<Double> hrrange = new ArrayList<Double>();
		List<Double> hrmax = new ArrayList<Double>();
		List<Double> hrmean = new ArrayList<Double>();
		List<Double> hrmin = new ArrayList<Double>();
		List<Double> hrstd = new ArrayList<Double>();
		List<Double> hrvar = new ArrayList<Double>();

		List<String> sdate = new ArrayList<String>();
		for (int i = 0; i < bf_list.size(); i++) {
			scrange.add(bf_list.get(i).getScRange());
			scmax.add(bf_list.get(i).getScMax());
			scmean.add(bf_list.get(i).getScMean());
			scmin.add(bf_list.get(i).getScMin());
			scstd.add(bf_list.get(i).getScSTD());
			scvar.add(bf_list.get(i).getScVar());

			hrrange.add(bf_list.get(i).getHrRange());
			hrmax.add(bf_list.get(i).getHrMax());
			hrmean.add(bf_list.get(i).getHrMin());
			hrmin.add(bf_list.get(i).getHrMin());
			hrstd.add(bf_list.get(i).getHrSTD());
			hrvar.add(bf_list.get(i).getHrVar());
			sdate.add(String.valueOf("\"" + bf_list.get(i).getTimeStamp() + "\""));
		}
		request.getSession().setAttribute("scrange", scrange);
		request.getSession().setAttribute("scmax", scmax);
		request.getSession().setAttribute("scmean", scmean);
		request.getSession().setAttribute("scmin", scmin);
		request.getSession().setAttribute("scstd", scstd);
		request.getSession().setAttribute("scvar", scvar);

		request.getSession().setAttribute("hrrange", hrrange);
		request.getSession().setAttribute("hrmax", hrmax);
		request.getSession().setAttribute("hrmean", hrmean);
		request.getSession().setAttribute("hrmin", hrmin);
		request.getSession().setAttribute("hrstd", hrstd);
		request.getSession().setAttribute("hrvar", hrvar);
		request.getSession().setAttribute("sdate", sdate);
		return "user_user";
	}

	@RequestMapping(value = "userdetail")
	public String userDetail(@RequestParam(value = "uid", required = false) int id, HttpServletRequest request) {
		EntityUsers user = userFeatureManager.queryUserById(id);
		request.getSession().setAttribute("userdetail", user);

		List<EntityBioFeatures> bf_list = BioFeaturesManager.queryAll();
		System.out.println("bfSize:" + bf_list.size());
		request.getSession().setAttribute("bflist", bf_list);

		List<Double> scrange = new ArrayList<Double>();
		List<Double> scmax = new ArrayList<Double>();
		List<Double> scmean = new ArrayList<Double>();
		List<Double> scmin = new ArrayList<Double>();
		List<Double> scstd = new ArrayList<Double>();
		List<Double> scvar = new ArrayList<Double>();

		List<Double> hrrange = new ArrayList<Double>();
		List<Double> hrmax = new ArrayList<Double>();
		List<Double> hrmean = new ArrayList<Double>();
		List<Double> hrmin = new ArrayList<Double>();
		List<Double> hrstd = new ArrayList<Double>();
		List<Double> hrvar = new ArrayList<Double>();

		List<String> sdate = new ArrayList<String>();
		for (int i = 0; i < bf_list.size(); i++) {
			scrange.add(bf_list.get(i).getScRange());
			scmax.add(bf_list.get(i).getScMax());
			scmean.add(bf_list.get(i).getScMean());
			scmin.add(bf_list.get(i).getScMin());
			scstd.add(bf_list.get(i).getScSTD());
			scvar.add(bf_list.get(i).getScVar());

			hrrange.add(bf_list.get(i).getHrRange());
			hrmax.add(bf_list.get(i).getHrMax());
			hrmean.add(bf_list.get(i).getHrMin());
			hrmin.add(bf_list.get(i).getHrMin());
			hrstd.add(bf_list.get(i).getHrSTD());
			hrvar.add(bf_list.get(i).getHrVar());
			sdate.add(String.valueOf("\"" + bf_list.get(i).getTimeStamp() + "\""));
		}
		request.getSession().setAttribute("scrange", scrange);
		request.getSession().setAttribute("scmax", scmax);
		request.getSession().setAttribute("scmean", scmean);
		request.getSession().setAttribute("scmin", scmin);
		request.getSession().setAttribute("scstd", scstd);
		request.getSession().setAttribute("scvar", scvar);

		request.getSession().setAttribute("hrrange", hrrange);
		request.getSession().setAttribute("hrmax", hrmax);
		request.getSession().setAttribute("hrmean", hrmean);
		request.getSession().setAttribute("hrmin", hrmin);
		request.getSession().setAttribute("hrstd", hrstd);
		request.getSession().setAttribute("hrvar", hrvar);
		request.getSession().setAttribute("sdate", sdate);
		return "user";
	}

	@RequestMapping(value = "userupdate")
	public String userUpdateDetail(@RequestParam(value = "uid", required = false) int id, HttpServletRequest request) {
		EntityUsers user = userFeatureManager.queryUserById(id);
		request.getSession().setAttribute("userdetail", user);
		return "userupdateinfo";
	}

	@RequestMapping(value = "confirmupdate")
	public String confirmUserUpdateDetail(@RequestParam("file") MultipartFile file, @RequestParam(value = "uid", required = false) int id, HttpServletRequest request) throws IllegalStateException, IOException {
		EntityUsers user = (EntityUsers) request.getSession().getAttribute("userdetail");
		realpath = "D:/Springworkspace-sts-3.7.0.RELEASE/JSiento-server/src/main/webapp/pic";
		
		
		
		
		user.setFood_preference(request.getParameter("food"));
		user.setDescp(request.getParameter("desp"));
		if(!file.isEmpty()){
			System.out.println("Yes");
			
		    realpath = request.getSession().getServletContext().getRealPath("/pic"); 

			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			

			if(multipartResolver.isMultipart(request)){
				  
				   MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				   Iterator iter = multiRequest.getFileNames();
				   while(iter.hasNext()){
				    MultipartFile file1 = multiRequest.getFile((String)iter.next());
				    if(file1 != null){
				    fileName = file1.getOriginalFilename();
				     path = realpath+"/"+file1.getOriginalFilename();
				    // System.out.println("path"+path);
				     File localFile = new File(path);
				     
				     file1.transferTo(localFile);
				    }
				   }
				  }
			String path1 = request.getContextPath();
			user.setUser_img(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/pic"+"/"+fileName);
		}else{
			
			user.setUser_img("http://localhost:8080/JSiento-server/pic/unknownuser.png");
		}
		userFeatureManager.uodateUserInfo(user);
		return "redirect:/user_userslist";

		}
	@RequestMapping(value = "appointment_page", method = RequestMethod.GET)
	public String appointmentChange(HttpServletRequest request, HttpServletResponse response){
		return "appointment";
	}

}
