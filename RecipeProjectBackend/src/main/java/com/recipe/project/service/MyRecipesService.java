package com.recipe.project.service;

import java.util.List;
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

	public List<RecipeSubmission> getMyRecipes(Integer id) {
		
		List<RecipeSubmission> byRecipeAuthorsAuthorId = recipeSubmissionRepo.findByRecipeAuthorsAuthorId(id);
				
		return byRecipeAuthorsAuthorId;
				
			
	}
		
	}

		
		
	


