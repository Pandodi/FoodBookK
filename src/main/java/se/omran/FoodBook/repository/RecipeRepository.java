package se.omran.FoodBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.omran.FoodBook.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
