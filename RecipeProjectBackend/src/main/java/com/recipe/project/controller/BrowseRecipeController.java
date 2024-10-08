package com.recipe.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.project.entity.RecipeSubmission;
import com.recipe.project.service.BrowseRecipeService;

@RestController
public class BrowseRecipeController {
	
	@Autowired
	BrowseRecipeService browseRecipeService;
	

    @GetMapping("/allRecipes")
    public ResponseEntity<List<RecipeSubmission>> getFilteredRecipes(
        @RequestParam(required = false) String search,
        @RequestParam(required = false) List<String> types,
        @RequestParam(required = false) List<String> difficulty,
        @RequestParam(required = false) List<String> time
    ) {
        // You can implement custom logic to filter based on the parameters
        List<RecipeSubmission> recipes = browseRecipeService.customfindRecipes(search, types, difficulty, time);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

}
