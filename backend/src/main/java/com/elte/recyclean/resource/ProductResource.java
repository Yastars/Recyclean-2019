package com.elte.recyclean.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elte.recyclean.entity.Product;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.helpers.ZXingHelper;
import com.elte.recyclean.service.ProductService;

import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/product")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Product getProduct(@PathVariable long id) {
		return productService.getProduct(id);
	}

	@RequestMapping("/scanqr")
	@PostMapping
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String getProductByQR(@RequestBody Product tmp) {
		Product product = new Product();
		Long tmpId = (long) 0.0;
		try {
		tmpId = Long.parseLong(tmp.getProd_BarCode());
		product = productService.getProduct(tmpId);
		}catch(Exception e) {
			return "0 catch"; //Not found
		}
		if (product == null)
			return "0"; //Not found
		else if (product.getProd_BarCode().contentEquals("-1"))
			return "-1"; // already used
		else
			productService.deactivateBarCode(tmpId);
			return "1\nFound and BarCode Now = -1"; //Available
	}

	@RequestMapping(value = "qrcode/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 160, 160));
		outputStream.flush();
		outputStream.close();
	}

	@RequestMapping("/insertProduct")
	@PostMapping
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Product insertProduct(@RequestBody Product product) {
		productService.insertProduct(product);
		return (product);
	}

}
