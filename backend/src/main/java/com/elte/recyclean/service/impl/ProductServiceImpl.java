package com.elte.recyclean.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elte.recyclean.DAO.ProductDAO;
import com.elte.recyclean.entity.Product;
import com.elte.recyclean.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;	
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}
	
	public String deactivateBarCode(Long Prod_Id) {
		return productDAO.deactivateBarCode(Prod_Id);
	}
	
	@Override
	public Product getProduct(Long Prod_Id) {
		return productDAO.getProduct(Prod_Id);
	}

	@Override
	public String deleteProduct(long Prod_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public String deactivateBarCode(Long Prod_Id) {
//		return productDAO.deactivateBarCode(Prod_Id);
//	}
	
	@Override
	public Product insertProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.insertProduct(product);
	}
	
}
