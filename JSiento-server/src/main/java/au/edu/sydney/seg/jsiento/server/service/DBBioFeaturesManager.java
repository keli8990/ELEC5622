package au.edu.sydney.seg.jsiento.server.service;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.seg.jsiento.server.model.BioFeatures;
import au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures;


@Service(value="BioFeaturesManager") 
@Transactional
public class DBBioFeaturesManager {

private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void insertBioFeatures(List<BioFeatures> newData) {
		
		EntityBioFeatures newDBData=new EntityBioFeatures(newData);
		this.sessionFactory.getCurrentSession().save(newDBData);
		
	}
	
	public void insertBioFeatures(EntityBioFeatures newDBData) {
		
		//EntityBioFeatures newDBData=new EntityBioFeatures(newData);
		this.sessionFactory.getCurrentSession().save(newDBData);
		
	}
	public List<EntityBioFeatures> queryAll() {
		Session session  = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from au.edu.sydney.seg.jsiento.server.model.EntityBioFeatures");
		List<EntityBioFeatures> result = query.list();
		return result;
	}
	
	public EntityBioFeatures selectBioFeaturesById(long id) {
		EntityBioFeatures newDBData= (EntityBioFeatures) 
				this.sessionFactory.getCurrentSession().get(EntityBioFeatures.class, id);
		return newDBData;	
	}
	
	@SuppressWarnings("unchecked")
	public EntityBioFeatures selectBioFeaturesByDate(Date date) {
		System.out.println(date.toString());
		
		List<EntityBioFeatures> getData= this.sessionFactory.getCurrentSession()
                .createQuery("from EntityBioFeatures bf where bf.timeStamp < '"+date+"' order by timeStamp DESC LIMIT 1")
                .list();

		return getData.get(0);
		
	}
	
	
}
