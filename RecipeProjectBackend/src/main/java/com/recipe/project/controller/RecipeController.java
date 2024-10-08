	package com.recipe.project.controller;
	
	import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.project.entity.RecipeAuthors;
import com.recipe.project.entity.RecipeLoginInfo;
import com.recipe.project.entity.RecipeSubmission;
	import com.recipe.project.service.RecipeService;
	
	@RestController
	public class RecipeController {
		
		
		@Autowired
		RecipeService recipeService;
		
		
		@PostMapping("/authors")
		public ResponseEntity<String> authorPage(@RequestBody RecipeLoginInfo loginInfo){
			
			recipeService.saveAuthInfo(loginInfo);
			
			return new ResponseEntity<>("Saved",HttpStatus.ACCEPTED);
			
			
		}
		
		
		
		@PostMapping("/recipes")
		public ResponseEntity<Integer> recipePage(@RequestBody RecipeSubmission recipeSubmission){
			
			int saveRecipeInfo = recipeService.saveRecipeInfo(recipeSubmission);
			
			
			return new ResponseEntity<>(saveRecipeInfo,HttpStatus.ACCEPTED);
			
		}
		
		
	
		@PostMapping("/signup")
		public ResponseEntity<String> signUpPage(@RequestBody RecipeLoginInfo loginInfo) {
			
			
			
			System.out.println(loginInfo.toString());
			
			
//			return loginInfo;
		    boolean userExists = recipeService.findUser(loginInfo);
		    
		    

		    if (userExists) {
		    	System.out.println("User already esixts");
		    	
		    	return new ResponseEntity<>("User already Exists please login",HttpStatus.NOT_MODIFIED);
//		        
		    } else {
		        recipeService.saveSignUpInfo(loginInfo);
//		        return "Signed up successfully";
		        }
		    
		    return new ResponseEntity<>("User SignUp Successfull",HttpStatus.CREATED);
		    
		}
		
		@PostMapping("/login")
		public ResponseEntity<List<String>> loginCheck(@RequestBody RecipeLoginInfo recipeLoginInfo){
			
			boolean checkPassword = recipeService.checkPassword(recipeLoginInfo.getUserEmail().toLowerCase(),recipeLoginInfo.getUserPassword(),recipeLoginInfo.getUserHashCode());
			List<String> ans=new ArrayList<>();
			if(checkPassword==true) {
				System.out.println(checkPassword);
				String username=recipeService.getUser(recipeLoginInfo.getUserEmail());
				
				Integer authorId = recipeService.getAuthorId(recipeLoginInfo.getUserEmail());
				ans.add(username);
				ans.add(authorId.toString());
				
				
				System.out.println(authorId);
				
				
				
				return new ResponseEntity<>(ans,HttpStatus.ACCEPTED);
				
			}
			
			return new ResponseEntity<>(ans,HttpStatus.CONFLICT);
			
			
		}
		
		

		
		@GetMapping("/home")
		public String homeCall() {
			return "Hello";
		}
//		
//		@PostMapping("/recipesubmission")
//		public ResponseEntity<String> submissionRecipe(@RequestBody RecipeSubmission recipeSubmission){
//			
//			recipeService.saveRecipe(recipeSubmission);
//			
//			return new ResponseEntity<>("Sent",HttpStatus.ACCEPTED);
//			
//		}
		
		@GetMapping("/allrecipes")
		public List<RecipeSubmission> getRecipes() {
			
			List<RecipeSubmission> recipes = recipeService.getRecipes();
			
			System.out.println("called ");
			
			return recipes;
		}
	
	}