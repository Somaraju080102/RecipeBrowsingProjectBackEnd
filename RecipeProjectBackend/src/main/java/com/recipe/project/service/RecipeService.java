package com.recipe.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.project.entity.RecipeLoginInfo;
import com.recipe.project.entity.RecipeSubmission;
import com.recipe.project.repo.RecipeLoginRepo;
import com.recipe.project.repo.RecipeSubmissionRepo;

@Service
public class RecipeService {
	
	
	
	@Autowired
	RecipeSubmissionRepo  recipeSubmissionRepo;
	
	@Autowired
	RecipeLoginRepo loginRepo;

	public void saveRecipe(RecipeSubmission recipeSubmission) {
		
		recipeSubmissionRepo.save(recipeSubmission);
		
	}
	
	

	public List<RecipeSubmission> getRecipes() {
	
		 
		return recipeSubmissionRepo.findAll();
		 
	}



	public void saveSignUpInfo(RecipeLoginInfo loginInfo) {
		// TODO Auto-generated method stub
		
		loginRepo.save(loginInfo);
		
	}

}
