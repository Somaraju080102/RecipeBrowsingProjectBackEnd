	package com.recipe.project.controller;
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.project.entity.RecipeLoginInfo;
import com.recipe.project.entity.RecipeSubmission;
	import com.recipe.project.service.RecipeService;
	
	@RestController
	public class RecipeController {
		
		
		@Autowired
		RecipeService recipeService;
		
		
	
		@PostMapping("/signup")
		public String signUpPage(@RequestBody RecipeLoginInfo loginInfo) {
		    boolean userExists = recipeService.findUser(loginInfo);

		    if (userExists) {
		        return "User already exists";
		    } else {
		        recipeService.saveSignUpInfo(loginInfo);
		        return "Signed up successfully";
		    }
		}

		
		@GetMapping("/home")
		public String homeCall() {
			return "Hello";
		}
		
		@PostMapping("/recipesubmission")
		public ResponseEntity<String> submissionRecipe(@RequestBody RecipeSubmission recipeSubmission){
			
			recipeService.saveRecipe(recipeSubmission);
			
			return new ResponseEntity<>("Sent",HttpStatus.ACCEPTED);
			
		}
		
		@GetMapping("/allrecipes")
		public List<RecipeSubmission> getRecipes() {
			
			List<RecipeSubmission> recipes = recipeService.getRecipes();
			
			System.out.println("called ");
			
			return recipes;
		}
	
	}