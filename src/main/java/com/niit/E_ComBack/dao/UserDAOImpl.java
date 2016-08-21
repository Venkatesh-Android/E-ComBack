package com.niit.E_ComBack.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.E_ComBack.model.UserDetails;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<UserDetails> list() {
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = (List<UserDetails>) sessionFactory.getCurrentSession()
				.createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserDetails;
	}
	
	
	@Transactional
	public UserDetails getUsernmae(String id) {
		String hql = "name from UserDetails where email=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = (List<UserDetails>) query.list();

		if (listUserDetails != null && !listUserDetails.isEmpty())
		{
			return listUserDetails.get(0);
		}
		return null;
	}
	
	
	

	@Transactional
	public UserDetails get(String id) {
		String hql = "from UserDetails where email=" + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = (List<UserDetails>) query.list();

		if (listUserDetails != null && !listUserDetails.isEmpty())
		{
			return listUserDetails.get(0);
		}
		return null;
	}

	@Transactional
	public void saveorUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);

	}

	@Transactional
	public void delete(String id) {
		UserDetails UserToDelete = new UserDetails();
		UserToDelete.setEmail(id);
		sessionFactory.getCurrentSession().delete(UserToDelete);
	}

	@Transactional
	public boolean isValidUser(String id, String password) {
		String hql = "from UserDetails where email=" + "'" + id + "'" + " and " + " password =" + "'" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}
	
	
	@Transactional
	public boolean AdminCheck(String id,boolean isAdmin){
		String hql = "from UserDetails where email=" + "'" + id + "'" + "and admin=" + "'" + isAdmin + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;
	}
	
	

}
