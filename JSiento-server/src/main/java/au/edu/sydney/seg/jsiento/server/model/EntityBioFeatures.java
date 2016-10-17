package au.edu.sydney.seg.jsiento.server.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BioFeatures")
public class EntityBioFeatures implements Serializable{
		
	public EntityBioFeatures(){}

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long Id;

	@Column(name="userId")
	private int userId;
	
	@Column(name="recordedTime")
	private Date timeStamp;
	
	@Column(name="HR_Mean")
	private Double hrMean;
	
	@Column(name="HR_Min")
	private Double hrMin;
	
	@Column(name="HR_Max")
	private Double hrMax;
	
	@Column(name="HR_STD")
	private Double hrSTD;

	@Column(name="HR_Variance")
	private Double hrVar;

	@Column(name="HR_Range")
	private Double hrRange;
	
	@Column(name="SC_Mean")
	private Double scMean;
	
	@Column(name="SC_Min")
	private Double scMin;
	
	@Column(name="SC_Max")
	private Double scMax;
	
	@Column(name="SC_STD")
	private Double scSTD;

	@Column(name="SC_Variance")
	private Double scVar;

	@Column(name="SC_Range")
	private Double scRange;
	
	
	
//	
//	public EntityUsers u = (EntityUsers) request.getSession().getAttribute("biouser");
	
	public EntityBioFeatures(BioFeatures newData){
		this.timeStamp=newData.getTimeStamp();
		if (newData.getFeaturesType().equals("HR")){
			this.hrMean=newData.getFeatures().get("HR-Mean");
			this.hrMin=newData.getFeatures().get("HR-Min");
			this.hrMax=newData.getFeatures().get("HR-Max");
			this.hrSTD=newData.getFeatures().get("HR-STD");
			this.hrVar=newData.getFeatures().get("HR-Variance");
			this.hrRange=newData.getFeatures().get("HR-Range");
//			this.userId = u.getId();
			
		}
		if (newData.getFeaturesType().equals("SC")){
			this.scMean=newData.getFeatures().get("SC-Mean");
			this.scMin=newData.getFeatures().get("SC-Min");
			this.scMax=newData.getFeatures().get("SC-Max");
			this.scSTD=newData.getFeatures().get("SC-STD");
			this.scVar=newData.getFeatures().get("SC-Variance");
			this.scRange=newData.getFeatures().get("SC-Range");
//			this.userId = u.getId();
		}
	}
	
	public EntityBioFeatures(List <BioFeatures> newData){
		
		this.timeStamp=newData.get(0).getTimeStamp();
		for (int i=0; i<2;i++){
			if (newData.get(i).getFeaturesType().equals("HR")){
				this.hrMean=newData.get(i).getFeatures().get("HR-Mean");
				this.hrMin=newData.get(i).getFeatures().get("HR-Min");
				this.hrMax=newData.get(i).getFeatures().get("HR-Max");
				this.hrSTD=newData.get(i).getFeatures().get("HR-STD");
				this.hrVar=newData.get(i).getFeatures().get("HR-Variance");
				this.hrRange=newData.get(i).getFeatures().get("HR-Range");
//				this.userId = u.getId();
			}
			if (newData.get(i).getFeaturesType().equals("SC")){
				this.scMean=newData.get(i).getFeatures().get("SC-Mean");
				this.scMin=newData.get(i).getFeatures().get("SC-Min");
				this.scMax=newData.get(i).getFeatures().get("SC-Max");
				this.scSTD=newData.get(i).getFeatures().get("SC-STD");
				this.scVar=newData.get(i).getFeatures().get("SC-Variance");
				this.scRange=newData.get(i).getFeatures().get("SC-Range");
//				this.userId = u.getId();
			}
			
		}
		
		
	}
	//Getters and setters

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getHrMean() {
		return hrMean;
	}

	public void setHrMean(Double hrMean) {
		this.hrMean = hrMean;
	}

	public Double getHrMin() {
		return hrMin;
	}

	public void setHrMin(Double hrMin) {
		this.hrMin = hrMin;
	}

	public Double getHrMax() {
		return hrMax;
	}

	public void setHrMax(Double hrMax) {
		this.hrMax = hrMax;
	}

	public Double getHrSTD() {
		return hrSTD;
	}

	public void setHrSTD(Double hrSTD) {
		this.hrSTD = hrSTD;
	}

	public Double getHrVar() {
		return hrVar;
	}

	public void setHrVar(Double hrVar) {
		this.hrVar = hrVar;
	}

	public Double getHrRange() {
		return hrRange;
	}

	public void setHrRange(Double hrRange) {
		this.hrRange = hrRange;
	}

	public Double getScMean() {
		return scMean;
	}

	public void setScMean(Double scMean) {
		this.scMean = scMean;
	}

	public Double getScMin() {
		return scMin;
	}

	public void setScMin(Double scMin) {
		this.scMin = scMin;
	}

	public Double getScMax() {
		return scMax;
	}

	public void setScMax(Double scMax) {
		this.scMax = scMax;
	}

	public Double getScSTD() {
		return scSTD;
	}

	public void setScSTD(Double scSTD) {
		this.scSTD = scSTD;
	}

	public Double getScVar() {
		return scVar;
	}

	public void setScVar(Double scVar) {
		this.scVar = scVar;
	}

	public Double getScRange() {
		return scRange;
	}

	public void setScRange(Double scRange) {
		this.scRange = scRange;
	}

	
}
