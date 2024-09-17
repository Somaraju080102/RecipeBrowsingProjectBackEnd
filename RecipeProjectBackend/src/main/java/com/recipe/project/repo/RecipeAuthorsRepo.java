package com.recipe.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.project.entity.RecipeAuthors;

public interface RecipeAuthorsRepo extends JpaRepository<RecipeAuthors, Integer> {

}
