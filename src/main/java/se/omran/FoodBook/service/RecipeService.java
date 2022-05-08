package se.omran.FoodBook.service;

import org.springframework.stereotype.Service;
import se.omran.FoodBook.dao.RecipeDAO;
import se.omran.FoodBook.model.Recipe;

import java.util.List;
@Service
public class RecipeService {

    RecipeDAO recipeDAO;

    public RecipeService(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    public List<Recipe> getAllRecipes(){
        return recipeDAO.getAllRecipes();
    }

    public Recipe addRecipe (Recipe recipe) {
        return recipeDAO.saveRecipe(recipe);
    }

    public Recipe getRecipeByID (Long id) {
        return recipeDAO.getRecipeByID (id);
    }

    public void deleteRecipeByID(Long id){
        recipeDAO.deleteRecipeByID(id);
    }

}
