package se.omran.FoodBook.dao;

import org.springframework.stereotype.Repository;
import se.omran.FoodBook.model.Recipe;
import se.omran.FoodBook.repository.RecipeRepository;

import java.util.List;

@Repository
public class RecipeDAO{
    RecipeRepository recipeRepository;

    public RecipeDAO(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeByID(Long id){
        return recipeRepository.findById(id).get();
    }

    public void deleteRecipeByID(Long id){
        recipeRepository.deleteById(id);
    }
}
