package se.omran.FoodBook.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.omran.FoodBook.model.Recipe;
import se.omran.FoodBook.service.RecipeService;

@Controller
public class RecipeController {

    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String listRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getAllRecipes());
        return "recipes";
    }

    @GetMapping("/create")
    public String createRecipeForm(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        return "create_post";
    }

    @PostMapping("/")
    public String addRecipe(@ModelAttribute("recipe") Recipe recipe){
        recipeService.addRecipe(recipe);
        return "redirect:/";
    }

    @GetMapping("/recipe/{id}")
    public String viewRecipe(@PathVariable Long id, Model model){
        model.addAttribute("recipe", recipeService.getRecipeByID(id));
        return "recipe";
    }

    @GetMapping ("/{id}")
    public String deletePost(@PathVariable Long id){
        recipeService.deleteRecipeByID(id);
        return "redirect:/";
    }
}
