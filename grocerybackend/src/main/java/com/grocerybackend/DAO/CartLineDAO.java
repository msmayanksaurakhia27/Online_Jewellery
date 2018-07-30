package com.grocerybackend.DAO;

import java.util.List;

import com.grocerybackend.model.Cart;
import com.grocerybackend.model.CartLine;

public interface CartLineDAO {
	public boolean addCart(Cart cart);
	public List<CartLine> list(int cartId);
	public CartLine get(int id);	
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean remove(CartLine cartLine);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndProduct(int cartId, int productId);		
		
	// updating the cart
	boolean updateCart(Cart cart);
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);
	public Cart getCartByUserId(int sid);
	
	// adding order details
	//boolean addOrderDetail(OrderDetail orderDetail);

}
