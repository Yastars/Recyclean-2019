package com.elte.recyclean.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elte.recyclean.entity.Credit;
import com.elte.recyclean.entity.Product;
import com.elte.recyclean.entity.User;
import com.elte.recyclean.entity.UserWasteDetails;
import com.elte.recyclean.service.CreditService;
//import com.elte.recyclean.helpers.ZXingHelper;
import com.elte.recyclean.service.ProductService;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/credits")
public class CreditResource {

	@Autowired
	private CreditService creditService;

	@RequestMapping("/update")
	@PostMapping
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String updateCredits(@RequestBody Credit credit) {
		System.out.println(credit.toString());
		return creditService.updateCredits(credit);
	}

	@RequestMapping("/check/{user_Id}")
	@GetMapping
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String getCredits(@PathVariable("user_Id") long user_Id) {
		return creditService.getCredits(user_Id);
	}
	
	@RequestMapping("/redeem/{user_Id}/{credits}")
	@GetMapping
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public String redeemCredits(@PathVariable("user_Id") long user_Id,@PathVariable("credits") int credits) {
		return creditService.redeemCredits(user_Id,credits);
	}
}
