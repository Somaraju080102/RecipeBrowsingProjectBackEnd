package com.recipe.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {
	
	
	@GetMapping("/home")
	public String homeCall() {
		return "Hello";
	}
	

}