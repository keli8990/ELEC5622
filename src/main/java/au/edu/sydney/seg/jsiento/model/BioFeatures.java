package au.edu.sydney.seg.jsiento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class BioFeatures implements Serializable{
	
	private static final long serialVersionUID = -7788619177798333711L;
	
	private Date timeStamp;
	private String featuresType;
	private Map <String,Double> features;
	
	public BioFeatures(Date tStamp, String fType){
		this.featuresType = fType;
		this.timeStamp = tStamp;
	}
	public String getFeaturesType() {
		return featuresType;
	}
	public void setFeaturesType(String featureType) {
		this.featuresType = featureType;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public Map <String,Double> getFeatures() {
		return features;
	}
	public void setFeatures(Map <String,Double> features) {
		this.features = features;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("TimeStamp="+getTimeStamp()+"\n");
		sb.append("FeatursType="+getFeaturesType()+"\n");
		sb.append("Features="+getFeatures()+"\n");
		return sb.toString();
				
	}
	

}
