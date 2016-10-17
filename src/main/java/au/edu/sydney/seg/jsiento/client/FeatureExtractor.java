package au.edu.sydney.seg.jsiento.client;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import au.edu.sydney.seg.jsiento.model.BioFeatures;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class FeatureExtractor {

	private ArrayList<Double> rawHR = new ArrayList<Double>();
	private ArrayList<Double> rawSC = new ArrayList<Double>();
	

	public void addRawData(String newLine){
//		try{
			String[] tokens = newLine.split("[,]");
			Double newHR=Double.parseDouble(tokens[0]);
			Double newSC=Double.parseDouble(tokens[1]);
			rawHR.add(newHR);
			rawSC.add(newSC);
//		}catch(Exception e){
//			System.err.println("An error occured in input data");
//		}
	}

	/** This function returns a JSON object contains 
	 * extracted features from one instance */
	public String extractFeatures(Date tStamp){
		DescriptiveStatistics stats = new DescriptiveStatistics();
		List <BioFeatures> bioFeaturesList=new ArrayList <BioFeatures>();
		
		// Extract HR features
		for( int i = 0; i < rawHR.size(); i++) {
	        stats.addValue(rawHR.get(i));
		}
		BioFeatures HRBioFeatures=new BioFeatures(tStamp, "HR");
		Map<String, Double> HRFeatures = new HashMap<String, Double>();
		HRFeatures.put("HR-Mean", stats.getMean());
		HRFeatures.put("HR-Min", stats.getMin());
		HRFeatures.put("HR-Max", stats.getMax());
		HRFeatures.put("HR-STD", stats.getStandardDeviation());
		HRFeatures.put("HR-Variance", stats.getVariance());
		HRFeatures.put("HR-Range", stats.getMax()- stats.getMin());
		HRBioFeatures.setFeatures(HRFeatures);
		// Add features to the list
		bioFeaturesList.add(HRBioFeatures);
		
		// Clear stats
		stats.clear();
		
		// Extract SC features
		for( int i = 0; i < rawSC.size(); i++) {
	        stats.addValue(rawSC.get(i));
		}
		BioFeatures SCBioFeatures=new BioFeatures(tStamp, "SC");
		Map<String, Double> SCFeatures = new HashMap<String, Double>();
		SCFeatures.put("SC-Mean", stats.getMean());
		SCFeatures.put("SC-Min", stats.getMin());
		SCFeatures.put("SC-Max", stats.getMax());
		SCFeatures.put("SC-STD", stats.getStandardDeviation());
		SCFeatures.put("SC-Variance", stats.getVariance());
		SCFeatures.put("SC-Range", stats.getMax()- stats.getMin());
		
		SCBioFeatures.setFeatures(SCFeatures);
		// Add features to the list
		bioFeaturesList.add(SCBioFeatures);
		
		//Create a JSon object
		String AllFeaturesJson="{}";
		ObjectMapper jSonMapper = new ObjectMapper();
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		//jSonMapper.setDateFormat(df);
		try {
			AllFeaturesJson=jSonMapper.writeValueAsString(bioFeaturesList);
			System.out.println(AllFeaturesJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return AllFeaturesJson;
	}
	
	public void clearExtractor(){
		rawHR.clear();
		rawSC.clear();
	}
	
	public ArrayList<Double> getRawHR() {
		return rawHR;
	}

	public void setRawHR(ArrayList<Double> rawHR) {
		this.rawHR = rawHR;
	}

	public ArrayList<Double> getRawSC() {
		return rawSC;
	}

	public void setRawSC(ArrayList<Double> rawSC) {
		this.rawSC = rawSC;
	}
}
