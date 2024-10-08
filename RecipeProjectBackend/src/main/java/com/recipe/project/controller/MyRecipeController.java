package com.recipe.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.project.entity.RecipeAuthors;
import com.recipe.project.entity.RecipeSubmission;
import com.recipe.project.service.MyRecipesService;
import com.recipe.project.service.RecipeService;

@RestController
public class MyRecipeController {
	
	
	@Autowired
	MyRecipesService  myRecipesService;
	
	@GetMapping("/myrecipes/{id}")
	public ResponseEntity<List<RecipeSubmission>> getMyRecipes(@PathVariable("id") Integer id){
		
		 List<RecipeSubmission> myRecipes = myRecipesService.getMyRecipes(id);
		
		return new ResponseEntity<>(myRecipes,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleterecipe/{rid}")
	public ResponseEntity<String> deleteRecipe(@PathVariable("rid") Integer rid){
		
		myRecipesService.deleteRecipe(rid);
		
		return new ResponseEntity<>("deleted",HttpStatus.ACCEPTED);
	}

}
