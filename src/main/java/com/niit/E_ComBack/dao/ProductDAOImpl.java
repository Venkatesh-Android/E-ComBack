package com.niit.E_ComBack.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.E_ComBack.model.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Product> list() {
		@SuppressWarnings({ "unchecked"})
		List<Product> listProduct = (List<Product>)
			sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listProduct;
	}

	@Transactional
	public Product get(String ID) {
		
		String hql="from Product where id=" + "'"+ ID +"'";
		//from Category where ID=101
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		if(listProduct != null && !listProduct.isEmpty())
		{
			return listProduct.get(0);
		}
		return null;
	}


	@Transactional
	public void saveorUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	@Transactional
	public void delete(String ID) {
		Product ProductToDelete = new Product();
		ProductToDelete.setId(ID);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		
		
	}

}
