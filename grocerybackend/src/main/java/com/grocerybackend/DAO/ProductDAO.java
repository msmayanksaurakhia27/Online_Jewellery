package com.grocerybackend.DAO;

import java.util.List;

import com.grocerybackend.model.Product;


public interface ProductDAO {

	public boolean addProduct(Product product);
	public boolean updateProduct(Product product);
	
	public List<Product> getAll();
	public Product getSingleProduct(int sid);
	public boolean DeleteProduct(Product product);
	public List<Product> searchBykeyword(String keyword);
	public List<Product> productListByCatId(int categoryId);

}
