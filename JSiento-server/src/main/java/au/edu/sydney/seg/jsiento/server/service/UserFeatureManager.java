package au.edu.sydney.seg.jsiento.server.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import au.edu.sydney.seg.jsiento.server.model.EntityUsers;

@Service(value="UserFeaturesManager") 
@Transactional
public class UserFeatureManager {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	public void insertUserInfo(EntityUsers user){
		this.sessionFactory.getCurrentSession().save(user);
	}
	
	public void uodateUserInfo(EntityUsers user){
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);;
	}
	
	public EntityUsers queryUserByName(String name){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from EntityUsers u where u.name='" + name + "'");
		List<EntityUsers> result = query.list();
		if (result != null && result.size() > 0)
			return result.get(0);
		else
			return null;
	}
	
	public EntityUsers queryUserById(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from EntityUsers u where u.id='" + id + "'");
		List<EntityUsers> result = query.list();
		if (result != null && result.size() > 0)
			return result.get(0);
		else
			return null;
	}
	
	public List<EntityUsers> queryAllUser(){
		Session session  = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from au.edu.sydney.seg.jsiento.server.model.EntityUsers");
		List<EntityUsers> result = query.list();
		return result;
	}
	
	public EntityUsers loginToTheSys(String name, String pwd){
		String hql =  "select a from EntityUsers a where a.name='"
				+ name + "' and a.password='" + pwd + "'";
		List<EntityUsers>list = this.queryAllUser();
		if(list != null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}
