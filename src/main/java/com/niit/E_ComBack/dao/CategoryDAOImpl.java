package com.niit.E_ComBack.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.E_ComBack.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Category> list() {

		//		List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
//				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		List<Category> listCategory = sessionFactory.getCurrentSession().createQuery("from Category").list();
		
		return listCategory;

	}

	@Transactional
	public Category get(String ID) {
		// TODO Auto-generated method stub
		String hql = "from Category where id=" + "'" + ID + "'" ;
		// from Category where ID=101
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		return null;
	}

	@Transactional
	public Category getByName(String name) {
		String hql = "from Category where name=" + "'" + name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();

		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}

		return null;
	}

	@Transactional
	public void saveorUpdate(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	@Transactional
	public void delete(String ID) {
		// TODO Auto-generated method stub
		Category CategoryToDelete = new Category();
		CategoryToDelete.setId(ID);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);

	}

}