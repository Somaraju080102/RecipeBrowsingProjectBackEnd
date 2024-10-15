package com.recipe.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.project.entity.RecipeSubmission;
import com.recipe.project.repo.RecipeSubmissionRepo;

@Service
public class BrowseRecipeService {
	
	@Autowired
	RecipeSubmissionRepo recipeSubmissionRepo;

	public List<RecipeSubmission> getAllRecipes() {
		
		List<RecipeSubmission> all = recipeSubmissionRepo.findAll();
		
		return all;
		
	}

	public List<RecipeSubmission> customfindRecipes(String search, List<String> types, List<String> difficulty,
			List<String> time) {
		
		System.out.println(types+" "+"types");
		System.out.println(difficulty+" "+"difficulty");
         List<RecipeSubmission> customFindRecipes = recipeSubmissionRepo.customFindRecipes(search, types, difficulty, time);
         
         
         
         
		return customFindRecipes;
	}

}
