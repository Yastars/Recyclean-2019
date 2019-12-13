package com.elte.recyclean.resource;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.elte.recyclean.entity.User;
import com.elte.recyclean.repo.UserRepo;
import com.elte.recyclean.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserResource {

		@Autowired
		private UserService userService;
	
		@GetMapping
		public List<User> getAllUsers() {
		    return userService.getAllUsers();
		}
		
		@RequestMapping("/login")
		@PostMapping
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public User getUser(@RequestBody User user) {
		    return userService.getUser(user.getUserEmail(),user.getUserPass());
		}
		
		@RequestMapping("/register")
		@PostMapping
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public User registerUser(@RequestBody User user) {
			user.setLastUpdatedBy("Admin");
			return userService.registerUser(user);
		}
		
		@DeleteMapping("/delete/{userId}/{userEmail}")
		  public ResponseEntity<Void> deleteUser(@PathVariable long userId, @PathVariable String userEmail) {
		    userService.deleteUser(userId, userEmail);
		      return ResponseEntity.noContent().build();
		  }
		
			
		@PutMapping("/update")
		@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
		public String updateUser(@FormParam("userId") long userId,@FormParam("userCredits") int userCredits) {
		    return userService.updateUser(userId,userCredits);
		}
		
	}
