package au.edu.sydney.seg.jsiento.server.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;
import au.edu.sydney.seg.jsiento.server.service.DBBioFeaturesManager;



@Controller
public class DiagnosticController {
	
	@Resource(name="BioFeaturesManager")
	private DBBioFeaturesManager BioFeaturesManager;

	
   @RequestMapping("/monitor")
   public ModelAndView monitorPage() {
       return new ModelAndView("monitor", "message", "JSiento Monitoring- Arousal Level in the last 10 Seconds");
   }

   @RequestMapping(value = "/ajaxMonitor", method = RequestMethod.GET)
   public @ResponseBody String getReport() {
	   String string = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
       Date date=null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.ENGLISH).parse(string);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		System.out.println(date); 
       
		EntityBioFeatures temp= this.BioFeaturesManager.selectBioFeaturesByDate(date);
		Double scRange=temp.getScRange();
		Date recTime=temp.getTimeStamp();

		// Diagnostic Logic
		String result="<br>Please wait ...";
		if (scRange >0 && scRange<1.5 )
			result = "<br>Arousal level:<b> Low </b> <br> SC-Range: "+ scRange + "<p style=\"background-color:green;\">1</p> <br> Generated on : " + recTime.toString() ;
		else if (scRange>=1.5 && scRange<=2)
			result = "<br>Arousal level:<b> Medium </b><br> SC-Range: "+ scRange + "<p style=\"background-color:yellow;\">2</p> <br> Generated on : " + recTime.toString() ;
		else if (scRange >2)
			result = "<br>Arousal level:<b> High </b> <br> SC-Range: "+ scRange + "<p style=\"background-color:red;\">3</p><br> Generated on : " + recTime.toString() ;
		else
			result = "<br>Arousal level:<b> No signal ! </b> <br> SC-Range: "+ scRange + "<p style=\"background-color:black;\">4</p><br> Generated on : " + recTime.toString() ;
		
       System.out.println("Debug Message : New report, " + new Date().toString());
       
       return result;
   }
   
   @RequestMapping(value ="/callm")
   public String callMedia() {
       return "2";
   }
}