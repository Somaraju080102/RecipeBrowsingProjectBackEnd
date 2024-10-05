package com.recipe.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.recipe.project.entity.RecipeAuthors;
import com.recipe.project.entity.RecipeLoginInfo;
import com.recipe.project.entity.RecipeSubmission;
import com.recipe.project.repo.RecipeAuthorsRepo;
import com.recipe.project.repo.RecipeLoginRepo;
import com.recipe.project.repo.RecipeSubmissionRepo;

@Service
public class RecipeService {
	
	private final BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();

	
	@Autowired
	RecipeSubmissionRepo  recipeSubmissionRepo;
	
	@Autowired
	RecipeAuthorsRepo authorsRepo;
	
	@Autowired
	RecipeLoginRepo loginRepo;

//	public void saveRecipe(RecipeSubmission recipeSubmission) {
//		
//		System.out.println("Instuctuions "+ recipeSubmission.getRecipeInstrucions());
//		
//		recipeSubmissionRepo.save(recipeSubmission);
//		
//	}
	
	

	public List<RecipeSubmission> getRecipes() {
	
		 
		return recipeSubmissionRepo.findAll();
		 
	}


	public void saveSignUpInfo(RecipeLoginInfo loginInfo) {
		// TODO Auto-generated method stub
		String email=loginInfo.getUserEmail();
		String password=loginInfo.getUserPassword();
		
		String encode = passwordEncoder.encode(email.toLowerCase()+password);
		
		loginInfo.setUserHashCode(encode);
		loginInfo.setUserPassword("null");
		
		loginRepo.save(loginInfo);
		
	}


	public boolean findUser(RecipeLoginInfo login) {
	    // Assuming loginRepo is properly instantiated and injected
	    RecipeLoginInfo existingUser = loginRepo.findByUserEmail(login.getUserEmail());
	    
	    return existingUser != null;
	}



	public boolean checkPassword(String email, String userPassword, String userHashCode) {
		
		RecipeLoginInfo byUserEmail = loginRepo.findByUserEmail(email);
		
		String hascode=byUserEmail.getUserHashCode();
		
		
		String checkEncode=email.toLowerCase()+userPassword;
		
		return passwordEncoder.matches(checkEncode, hascode);
		
		
	}



	public String getUser(String email) {
		
		RecipeLoginInfo byUser=loginRepo.findByUserEmail(email);
		
		return byUser.getUserName();
	}



	public void saveAuthInfo(RecipeLoginInfo loginInfo) {
		
		RecipeAuthors authors = new RecipeAuthors();
		authors.setAuthorEmail(loginInfo.getUserEmail());
		authors.setAuthorName(loginInfo.getUserName());
		
		authorsRepo.save(authors);
		
	}



//	public void saveRecipeInfo(RecipeSubmission recipeSubmission) {
//		
//		
//		
//		System.out.println(recipeSubmission.toString());
//		
//		System.out.println("Author "+recipeSubmission.getRecipeAuthor());
//		System.out.println("Instuctuions "+ recipeSubmission.getRecipeInstrucions());
//		System.out.println("Author Email "+ recipeSubmission.getRecipeAuthorEmail());
//		
//		
//		RecipeAuthors byAuthorEmail = authorsRepo.findByAuthorEmail(recipeSubmission.getRecipeAuthorEmail());
//		
//		System.out.println("dd");
//		
//		System.out.println(byAuthorEmail.toString());
//		recipeSubmission.setRecipeAuthors(byAuthorEmail);
//		 
//					
//		recipeSubmissionRepo.save(recipeSubmission);
//		
//	}
	public int saveRecipeInfo(RecipeSubmission recipeSubmission) {
	    // Fetch existing author by email from the RecipeAuthors table
	    RecipeAuthors byAuthorEmail = authorsRepo.findByAuthorEmail(recipeSubmission.getRecipeAuthorEmail());
	    
	    if (byAuthorEmail == null) {
	        // Author does not exist, handle the case accordingly
	        throw new RuntimeException("Author with email " + recipeSubmission.getRecipeAuthorEmail() + " not found!");
	    }

	    // Associate the fetched author with the recipe
	    recipeSubmission.setRecipeAuthors(byAuthorEmail);
	    
	    // Save the recipe submission (with correct association)
	    recipeSubmissionRepo.save(recipeSubmission);
	    
	    return byAuthorEmail.getAuthorId();
	}


	public Integer getAuthorId(String userEmail) {
		// TODO Auto-generated method stub
		
		RecipeAuthors byAuthorEmail = authorsRepo.findByAuthorEmail(userEmail);
		
		return byAuthorEmail.getAuthorId();
	}

}
