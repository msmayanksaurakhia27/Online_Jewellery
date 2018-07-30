package com.grocerybackend.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerybackend.DAO.CategoryDAO;
import com.grocerybackend.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Category> getAll() {
		
	try {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
	catch(Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	@Override
	public Category getSingleCategory(int pid) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, pid);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean DeleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
	