package com.grocerybackend.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerybackend.DAO.UserDAO;
import com.grocerybackend.model.User;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<User> getAll() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from User").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public User getSingleUser(int sid) {
		try {
			return sessionFactory.getCurrentSession().get(User.class, sid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean DeleteUser(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public User getEmail(String email) {
		try {

			return (User) sessionFactory.getCurrentSession().createQuery("From User where email=:email")
					.setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
