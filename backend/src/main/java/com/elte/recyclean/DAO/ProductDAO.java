package com.elte.recyclean.DAO;

import java.util.List;

import com.elte.recyclean.entity.Product;

public interface ProductDAO {
		public List<Product> getAllProducts();
		public Product insertProduct(Product product);
		public Product getProduct(long Prod_Id);
		public String deleteProduct(long Prod_Id);
		public String updateProduct(Product product);
		public String deactivateBarCode(Long Prod_Id);
	}
