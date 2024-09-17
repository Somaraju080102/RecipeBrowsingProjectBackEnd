package com.recipe.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.project.entity.RecipeLoginInfo;

@Repository
public interface RecipeLoginRepo  extends JpaRepository<RecipeLoginInfo, Integer>{

}
