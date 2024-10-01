package com.recipe.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class RecipeSubmission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer recipeId;
	
	@Column(nullable = true)
	private String 	recipeAuthorEmail;
	
	@Column(nullable = true)
	private String recipeTitle;
	
	@Column(nullable = true)
	private String recipeType;
	
	@Column(nullable = true)
	private Integer recipeTime;
	
	@Column(nullable = true)
	private String recipeDifficulty;
	
	@Column(nullable = true)
	private List<String> recipeIngredients;
	
	@Column(nullable = true)
	private String recipeInstrucions;
	
	@Column(nullable = true)
	private String recipeAuthor;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", referencedColumnName = "authorId", nullable = false)
	private RecipeAuthors recipeAuthors;


	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeAuthorEmail() {
		return recipeAuthorEmail;
	}

	public void setRecipeAuthorEmail(String recipeAuthorEmail) {
		this.recipeAuthorEmail = recipeAuthorEmail;
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

	@Override
	public String toString() {
		return "RecipeSubmission [recipeId=" + recipeId + ", recipeAuthorEmail=" + recipeAuthorEmail + ", recipeTitle="
				+ recipeTitle + ", recipeType=" + recipeType + ", recipeTime=" + recipeTime + ", recipeDifficulty="
				+ recipeDifficulty + ", recipeIngredients=" + recipeIngredients + ", recipeInstrucions="
				+ recipeInstrucions + ", recipeAuthor=" + recipeAuthor + ", recipeAuthors=" + recipeAuthors + "]";
	}

	
}