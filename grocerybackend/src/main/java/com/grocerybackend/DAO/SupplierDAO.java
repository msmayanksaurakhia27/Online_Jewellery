package com.grocerybackend.DAO;

import java.util.List;


import com.grocerybackend.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	
	public  List<Supplier> getAll() ;
	public Supplier getSingleSupplier(int pid);
	public boolean DeleteSupplier(Supplier supplier);
}
