package com.recipe.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.project.entity.RecipeAuthors;
import com.recipe.project.entity.RecipeSubmission;
import com.recipe.project.repo.RecipeAuthorsRepo;
import com.recipe.project.repo.RecipeSubmissionRepo;

@Service
public class MyRecipesService {
	
	@Autowired
	RecipeAuthorsRepo authorsRepo;
	
	@Autowired
	RecipeSubmissionRepo recipeSubmissionRepo;

	public RecipeSubmission getMyRecipes(Integer id) {
		
		Optional<RecipeAuthors> byId = authorsRepo.findById(id);
		System.out.println(byId.isPresent());
		if(byId.isPresent()) {
			RecipeAuthors recipeAuthors = byId.get();
			
			int sid=recipeAuthors.getAuthorId();
			
			Optional<RecipeSubmission> byId2 = recipeSubmissionRepo.findById(sid);
			
			if(byId2.isPresent()) {
				RecipeSubmission recipeSubmission = byId2.get();
				
				return recipeSubmission;
			}
		}
		
		return null;
		
	}

		
		
	

}
