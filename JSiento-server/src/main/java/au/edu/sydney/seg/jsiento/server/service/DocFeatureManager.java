package au.edu.sydney.seg.jsiento.server.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.edu.sydney.seg.jsiento.server.model.EntityDoc;




@Service(value="DocFeaturesManager") 
@Transactional
public class DocFeatureManager {
private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public List<EntityDoc> queryAllDocs(String hql){
		Session session  = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List<EntityDoc> result = query.list();
		return result;
	}
	public EntityDoc queryDocByName(String name){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from EntityDoc u where u.name='" + name + "'");
		List<EntityDoc> result = query.list();
		if (result != null && result.size() > 0)
			return result.get(0);
		else
			return null;
	}
	
	public EntityDoc loginToTheSys(String name, String pwd){
		String hql =  "select a from EntityDoc a where a.name='"
				+ name + "' and a.password='" + pwd + "'";
		List<EntityDoc>list = this.queryAllDocs(hql);
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
