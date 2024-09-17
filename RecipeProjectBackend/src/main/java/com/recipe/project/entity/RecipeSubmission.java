package com.recipe.project.entity;

import java.util.List;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class RecipeSubmission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recipeId;
	
	private String recipeTitle;
	
	private String recipeType;
	
	private Integer recipeTime;
	
	private String recipeDifficulty;
	
	private List<String> recipeIngredients;
	
	private String recipeInstrucions;
	
	private String recipeAuthor;
	
	@OneToOne
	@JoinColumn(name = "rauthors")
	private RecipeAuthors recipeAuthors;

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public Integer getRecipeTime() {
		return recipeTime;
	}

	public void setRecipeTime(Integer recipeTime) {
		this.recipeTime = recipeTime;
	}

	public String getRecipeDifficulty() {
		return recipeDifficulty;
	}

	public void setRecipeDifficulty(String recipeDifficulty) {
		this.recipeDifficulty = recipeDifficulty;
	}

	public List<String> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<String> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	public String getRecipeInstrucions() {
		return recipeInstrucions;
	}

	public void setRecipeInstrucions(String recipeInstrucions) {
		this.recipeInstrucions = recipeInstrucions;
	}

	public String getRecipeAuthor() {
		return recipeAuthor;
	}

	public void setRecipeAuthor(String recipeAuthor) {
		this.recipeAuthor = recipeAuthor;
	}

	public RecipeAuthors getRecipeAuthors() {
		return recipeAuthors;
	}

	public void setRecipeAuthors(RecipeAuthors recipeAuthors) {
		this.recipeAuthors = recipeAuthors;
	}
	
	
	
	

}