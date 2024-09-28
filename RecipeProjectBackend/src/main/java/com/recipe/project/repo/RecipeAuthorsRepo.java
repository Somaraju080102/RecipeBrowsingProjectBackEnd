package com.recipe.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.project.entity.RecipeAuthors;


@Repository
public interface RecipeAuthorsRepo extends JpaRepository<RecipeAuthors, Integer> {
	
    RecipeAuthors findByAuthorEmail(String authorEmail);

}
