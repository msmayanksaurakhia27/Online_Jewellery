package com.grocerybackend.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerybackend.DAO.ProductDAO;
import com.grocerybackend.model.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getAll() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product getSingleProduct(int sid) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, sid);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean DeleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> searchBykeyword(String keyword) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product where name like '%"+keyword+"%' or brand like '%"+keyword+"%' or price like '%"+keyword+"%'").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Product> productListByCatId(int categoryId) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product where categoryId=:categoryId").setParameter("categoryId", categoryId).list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}



}
