package com.grocerybackend.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerybackend.DAO.SupplierDAO;

import com.grocerybackend.model.Supplier;

@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Supplier> getAll() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}

	@Override
	public Supplier getSingleSupplier(int pid) {
		try {
			return sessionFactory.getCurrentSession().get(Supplier.class, pid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean DeleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
