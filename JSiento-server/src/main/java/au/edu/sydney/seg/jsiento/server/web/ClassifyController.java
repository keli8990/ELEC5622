package au.edu.sydney.seg.jsiento.server.web;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;
import au.edu.sydney.seg.jsiento.server.service.Classification;
import au.edu.sydney.seg.jsiento.server.service.DBBioFeaturesManager;
import au.edu.sydney.seg.jsiento.server.web.BioFeaturesController;


@Controller
public class ClassifyController {
	
	@Resource(name="BioFeaturesManager")
	private DBBioFeaturesManager BioFeaturesManager;
	
	// Classify the last record in the database
	@RequestMapping(value = "/classify", method = RequestMethod.GET)
	public String getClassifierResult(Model model) {
		
		String string = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        //String string = "2014-07-24_16-56-58";
        Date date=null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.ENGLISH).parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date); 
        
		Classification classifier=new Classification();
		
		model.addAttribute("classifierResult", classifier.ClassifyBioFeature(BioFeaturesManager.selectBioFeaturesByDate(date)) );
		return "classify";
    }
	// Classify based on Id
	@RequestMapping(value = "/classify/{id}", method = RequestMethod.GET)
	public String classifyById(@PathVariable("id") Long dataId, Model model) {
		Classification classifier=new Classification();
	    
	    model.addAttribute("classifierResult", classifier.ClassifyBioFeature(BioFeaturesManager.selectBioFeaturesById(dataId)) );
		return "classify";
		
	}
	 	
	 	

}
