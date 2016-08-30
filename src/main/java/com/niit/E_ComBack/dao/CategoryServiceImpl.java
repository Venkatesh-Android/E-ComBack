package com.niit.E_ComBack.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.niit.E_ComBack.model.Category;

@Service
@Component
public class CategoryServiceImpl implements CategoryService {

	CategoryDAOImpl cDao = new CategoryDAOImpl();

	public List<Category> list() {
		// TODO Auto-generated method stub
		return cDao.list();
	}

	public Category get(String ID) {
		// TODO Auto-generated method stub
		return cDao.get(ID);
	}

	public void saveorUpdate(Category category) {
		// TODO Auto-generated method stub
		cDao.saveorUpdate(category);
	}

	public void delete(String ID) {
		// TODO Auto-generated method stub
		cDao.delete(ID);
	}

	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return cDao.getByName(name);
	}
}