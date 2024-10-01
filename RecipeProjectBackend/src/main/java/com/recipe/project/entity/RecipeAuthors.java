
package com.recipe.project.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class RecipeAuthors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;
	
	@Override
	public String toString() {
		return "RecipeAuthors [authorId=" + authorId + ", authorName=" + authorName + ", authorEmail=" + authorEmail
				+  "]";
	}

	@Column(nullable = true)
	private String authorName;
	
	@Column(nullable = true,unique = true)
	private String authorEmail;
	   
	   @JsonIgnore
	   @OneToMany(mappedBy = "recipeAuthors", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	    private List<RecipeSubmission> recipeSubmissions;
	
	

	public List<RecipeSubmission> getRecipeSubmissions() {
		return recipeSubmissions;
	}

	public void setRecipeSubmissions(List<RecipeSubmission> recipeSubmissions) {
		this.recipeSubmissions = recipeSubmissions;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}


	
	

}
