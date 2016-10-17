package au.edu.sydney.seg.jsiento.server.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.edu.sydney.seg.jsiento.server.model.BioFeatures;
import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;
import au.edu.sydney.seg.jsiento.server.model.EntityDoc;
import au.edu.sydney.seg.jsiento.server.model.EntityUsers;
import au.edu.sydney.seg.jsiento.server.service.DBBioFeaturesManager;


@Controller
public class BioFeaturesController {
    
    private static final Logger logger = LoggerFactory.getLogger(BioFeaturesController.class);
    private final AtomicLong counter = new AtomicLong(); 
    //Map to store features (IF THERE IS NO DATABASE) 
   	public static Map<Long, List<BioFeatures>> storedData = new HashMap<Long, List<BioFeatures>>();
	
   	@Resource(name="BioFeaturesManager")
	private DBBioFeaturesManager BioFeaturesManager;
   	
    // Post a new data and store in DB
 	@RequestMapping(value = "/feature/post", method = RequestMethod.POST)
     public @ResponseBody List<BioFeatures> createBioFeatures(@RequestBody List<BioFeatures> newData, HttpServletRequest request) {
         logger.info("Start Create/Insert data.");
         storedData.put(counter.incrementAndGet(), newData);
         //Insert into DB    
        
         EntityBioFeatures newDBData=new EntityBioFeatures(newData);
         newDBData.setUserId(1);
         this.BioFeaturesManager.insertBioFeatures(newDBData);
//         this.BioFeaturesManager.insertBioFeatures
         // Classify it and insert the result to the DB
         // TODO
         return newData;
     }
 	
        
         
       
 	
 	// Get an specific data using id from DB
 	@RequestMapping(value = "/feature/get/{id}", method = RequestMethod.GET)
     public @ResponseBody EntityBioFeatures getBioFeaturesFromDB(@PathVariable("id") Long dataId) {
         logger.info("Start GET. ID="+dataId);
         
         return this.BioFeaturesManager.selectBioFeaturesById(dataId);
     }
 	
 	// Get an specific data using date from DB
 	@RequestMapping(value = "/feature/get/last", method = RequestMethod.GET)
     public @ResponseBody EntityBioFeatures getBioFeaturesFromDBNow() {
         logger.info("Start GET. NOW");
         
         String string = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
         //String string = "2014-07-24_16-56-58";
         Date date=null;
 		try {
 			date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.ENGLISH).parse(string);
 		} catch (ParseException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		System.out.println(date); 
         
         return this.BioFeaturesManager.selectBioFeaturesByDate(date);
     }
 	
 	// ---------- IF THERE IS STILL NO DATABASE USE HASH MAP
	// Get an specific data using id from HashMap
	@RequestMapping(value = "/jsiento/map/get/{id}", method = RequestMethod.GET)
    public @ResponseBody List<BioFeatures> getBioFeatures(@PathVariable("id") Long dataId) {
        logger.info("Start GET. ID="+dataId);
        return storedData.get(dataId);
    }
	
	// Get all stored data from HashMap
	@RequestMapping(value = "/jsiento/map/get", method = RequestMethod.GET)
    public @ResponseBody List<List<BioFeatures>> getAllBioFeatures() {
        logger.info("Start GET.");
        List<List<BioFeatures>> temp = new ArrayList<List<BioFeatures>>();
        Set<Long> empIdKeys = storedData.keySet();
        for(Long i : empIdKeys){
            temp.add(storedData.get(i));
        }
        return temp;
    }
	 
	

}
