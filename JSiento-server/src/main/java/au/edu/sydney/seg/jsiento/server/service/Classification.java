package au.edu.sydney.seg.jsiento.server.service;


import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class Classification {
	
	public String ClassifyBioFeature(EntityBioFeatures bioSample){
		ArrayList<Attribute> atts = new ArrayList<Attribute>();
		ArrayList<String> classVal = new ArrayList<String>();
		classVal.add("Red");
		classVal.add("Yellow");
		classVal.add("Green");
		atts.add(new Attribute("HR_Mean"));
		atts.add(new Attribute("HR_Min"));
		atts.add(new Attribute("HR_Max"));
		atts.add(new Attribute("HR_STD"));
		atts.add(new Attribute("HR_Variance"));
		atts.add(new Attribute("HR_Range"));
		atts.add(new Attribute("SC_Mean"));
		atts.add(new Attribute("SC_Min"));
		atts.add(new Attribute("SC_Max"));
		atts.add(new Attribute("SC_STD"));
		atts.add(new Attribute("SC_Variance"));
		atts.add(new Attribute("SC_Range"));
		
		atts.add(new Attribute("@@class@@", classVal));
		double classResult=-1;
		try {	
			// Create unlabeled (test) instance (label will be ignored)
		    double[] values = new double[]
		    		{bioSample.getHrMean(),bioSample.getHrMin(),bioSample.getHrMax(),
		    		bioSample.getHrSTD(),bioSample.getHrVar(),bioSample.getHrRange(),
		    		bioSample.getScMean(),bioSample.getScMin(),bioSample.getScMax(),
		    		bioSample.getScSTD(),bioSample.getScVar(),bioSample.getScRange(),
		    		0
		    		};
		    
		    DenseInstance newInst = new DenseInstance(1.0,values);
		    Instances dataUnlabeled = new Instances("TestInstances", atts, 0);
		    dataUnlabeled.add(newInst);
		    dataUnlabeled.setClassIndex(dataUnlabeled.numAttributes() - 1);
		    System.out.println(dataUnlabeled.toString());
		       	        
		    // Load trained model
		    Resource resource = new ClassPathResource("/wekaModels/jsiento-ibk.model");	    
		    String modelFilePath=resource.getFile().getAbsolutePath();
		    Classifier trainedClassifier = (Classifier) weka.core.SerializationHelper.read(modelFilePath);
		    
		    // Run the classification 
		    classResult=trainedClassifier.classifyInstance(dataUnlabeled.firstInstance());
		    // Output
		    System.out.println("The sample classified as: "+classResult);
		    
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return String.valueOf(classResult);
		
	}
	
	// This is a simple classifier 
	public String classify(){
		ArrayList<Attribute> atts = new ArrayList<Attribute>();
		ArrayList<String> classVal = new ArrayList<String>();
		classVal.add("C1");
		classVal.add("C2");
		atts.add(new Attribute("a"));
		atts.add(new Attribute("b"));
		atts.add(new Attribute("c"));
		atts.add(new Attribute("d"));
		atts.add(new Attribute("@@class@@", classVal));

		double classResult=-1;
		try {	
			// Create unlabeled (test) instance
		    double[] values = new double[]{3,0,1,0,0};
		    DenseInstance newInst = new DenseInstance(1.0,values);
		    Instances dataUnlabeled = new Instances("TestInstances", atts, 0);
		    dataUnlabeled.add(newInst);
		    dataUnlabeled.setClassIndex(dataUnlabeled.numAttributes() - 1);
		    System.out.println(dataUnlabeled.toString());
		    //System.out.println(dataUnlabeled);
		        	        
		    //Load trained model
		    Resource resource = new ClassPathResource("/wekaModels/ibk.model");
		    String modelFilePath=resource.getFile().getAbsolutePath();
		    Classifier trainedClassifier = (Classifier) weka.core.SerializationHelper.read(modelFilePath);
		    classResult=trainedClassifier.classifyInstance(dataUnlabeled.firstInstance());
		    System.out.println("from model: "+classResult);
		    
		    
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return String.valueOf(classResult);
	}
	

}
