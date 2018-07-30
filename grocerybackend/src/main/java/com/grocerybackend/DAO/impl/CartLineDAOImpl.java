package com.grocerybackend.DAO.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocerybackend.DAO.CartLineDAO;
import com.grocerybackend.model.Cart;
import com.grocerybackend.model.CartLine;



@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND product.id = :productId";
		try {
			
			return sessionFactory.getCurrentSession()
									.createQuery(query,CartLine.class)
										.setParameter("cartId", cartId)
										.setParameter("productId", productId)
											.getSingleResult();
			
		}catch(Exception ex) {
			return null;	
		}
		
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().save(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(CartLine cartLine) {	
		try {			
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
		}catch(Exception ex) {
			return false;
		}		
	}


	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
										.getResultList();		
	}

	@Override
	public CartLine get(int id) {		
		return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {			
			sessionFactory.getCurrentSession().update(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "FROM CartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
								.createQuery(query, CartLine.class)
									.setParameter("cartId", cartId)
									.setParameter("available", true)
										.getResultList();
	}

	@Override
	public boolean addCart(Cart cart) {
		try {			
			sessionFactory.getCurrentSession().save(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public Cart getCartByUserId(int sid) {
		return sessionFactory.getCurrentSession().createQuery("from Cart where USER_SID=:sid",Cart.class).setParameter("sid", sid).uniqueResult();
	}

	/*@Override
	public boolean addOrderDetail(OrderDetail orderDetail) {
		try {			
			sessionFactory.getCurrentSession().persist(orderDetail);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}*/
}
