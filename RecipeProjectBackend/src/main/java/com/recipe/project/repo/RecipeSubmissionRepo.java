package com.recipe.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.project.entity.RecipeSubmission;

@Repository
public interface RecipeSubmissionRepo extends JpaRepository<RecipeSubmission, Integer>{
	
    List<RecipeSubmission> findByRecipeAuthorsAuthorId(Integer authorId);



}
