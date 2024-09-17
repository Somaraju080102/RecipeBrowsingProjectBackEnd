package com.recipe.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.project.entity.RecipeSubmission;

public interface RecipeSubmissionRepo extends JpaRepository<RecipeSubmission, Integer>{

}
