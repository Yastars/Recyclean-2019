package com.elte.recyclean.service;

import java.util.List;

import com.elte.recyclean.entity.Product;

public interface ProductService {
		public List<Product> getAllProducts();
		public Product getProduct(Long Prod_Id);
		public String deleteProduct(long Prod_Id);
		public String updateProduct(Product product);
		public Product insertProduct(Product product);
		public String deactivateBarCode(Long Prod_Id);

}
