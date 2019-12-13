package com.elte.recyclean.DAO.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.elte.recyclean.DAO.ProductDAO;
import com.elte.recyclean.entity.Product;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.repo.ProductRepo;

@Component
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product getProduct(long Prod_Id) {
		return productRepo.findById(Prod_Id).orElse(null);
	}
	
	@Override
	public String deactivateBarCode(Long Prod_Id) {
		// TODO Auto-generated method stub
		String output = "Error";
		Product product = productRepo.findById(Prod_Id).orElse(null);
		product.setProd_BarCode("-1");
		product = productRepo.save(product);
		output = "Product updated Successfully. " + product.toString();
		System.out.println(output);
		System.out.println(output);
		System.out.println(output);
		return output;
	}

	@Override
	public String deleteProduct(long Prod_Id) {
		// TODO Auto-generated method stub
		String output;
		try {
			productRepo.deleteById(Prod_Id);
			output = "Product deleted successfully.";
		} catch (Exception e) {
			System.out.println(e);
			output = "Error in deleting product. Product doesnot exist";
		}
		return output;
	}

	@Override
	public Product insertProduct(Product product) {
		productRepo.save(product);
		product.setProd_BarCode(Long.toString(product.getProd_Id()));
		return productRepo.save(product);
	}
//
//	@Override
//	public String deactivateBarCode(Long Prod_Id) {
//		// TODO Auto-generated method stub
//		String output = "Error";
//		Product product = productRepo.findById(Prod_Id).orElse(null);
//		product.setProd_BarCode("-1");
//		product = productRepo.save(product);
//		output = "Product updated Successfully. " + product.toString();
//		System.out.println(output);
//		System.out.println(output);
//		System.out.println(output);
//		return output;
//	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
}
