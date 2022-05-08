package se.omran.FoodBook.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.omran.FoodBook.dao.RecipeDAO;
import se.omran.FoodBook.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class RecipeServiceTest extends MockitoExtension {

    static RecipeDAO recipeDAO;
    static RecipeService unitUnderTest;

    @BeforeAll
    public static void init(){
        recipeDAO = Mockito.mock(RecipeDAO.class);
        unitUnderTest = new RecipeService(recipeDAO);
    }

    @Test
    void getAllRecipes() {
        List<Recipe> recipesFromDB = new ArrayList<>();
        recipesFromDB.add(new Recipe("Test1", "Test1", "Test1"));
        recipesFromDB.add(new Recipe("Test2", "Test2", "Test2"));
        recipesFromDB.add(new Recipe("Test1", "Test1", "Test"));

        Mockito.when(recipeDAO.getAllRecipes()).thenReturn(recipesFromDB);

        List<Recipe> allActualRecipes = unitUnderTest.getAllRecipes();

        assertEquals(3, allActualRecipes.size());
    }

    @Test
    void addRecipe() {
        Recipe newRecipe = new Recipe(null,"titletest", "test", "test");
        Recipe recipeFromDB = new Recipe(1L,"titletest", "test", "test");

        Mockito.when(recipeDAO.saveRecipe(any())).thenReturn(recipeFromDB);

        Recipe actualRecipe = unitUnderTest.addRecipe(newRecipe);

        assertEquals(1, actualRecipe.getId());
        assertEquals("titletest", actualRecipe.getTitle());
    }

    @Test
    void getRecipeByID() {
        Recipe recipeFromDB = new Recipe(1L, "title", "test", "test");

        Mockito.when(recipeDAO.getRecipeByID(1L)).thenReturn(recipeFromDB);

        Recipe actualRecipe = unitUnderTest.getRecipeByID(1L);

        assertNotNull(actualRecipe);
        assertEquals(1L, actualRecipe.getId());
    }

    @Test
    void deleteRecipeByID() {
        unitUnderTest.deleteRecipeByID(1L);

        Mockito.verify(recipeDAO, Mockito.times(1)).deleteRecipeByID(1L);
        Mockito.verify(recipeDAO, Mockito.times(0)).saveRecipe(any());
    }
}