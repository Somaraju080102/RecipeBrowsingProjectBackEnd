package com.recipe.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.recipe.project.entity.RecipeSubmission;

@Repository
public interface RecipeSubmissionRepo extends JpaRepository<RecipeSubmission, Integer>{
	
    List<RecipeSubmission> findByRecipeAuthorsAuthorId(Integer authorId);
    
    @Query("SELECT r FROM RecipeSubmission r WHERE "
            + "(r.recipeTitle LIKE %:search% OR :search IS NULL) "
            + "AND (r.recipeType IN :types OR :types IS NULL) "
            + "AND (r.recipeDifficulty IN :difficulty OR :difficulty IS NULL) "
            + "AND (r.recipeTime IN :time OR :time IS NULL)")
     List<RecipeSubmission> customFindRecipes(
         @Param("search") String search, 
         @Param("types") List<String> types, 
         @Param("difficulty") List<String> difficulty,
         @Param("time") List<String> time
     );



}
