package se.omran.FoodBook.model;

import javax.persistence.*;

@Entity
@Table (name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String ingredients;
    private String method;

    public Recipe() {
    }

    public Recipe(String title, String ingredients, String method) {
        this.title = title;
        this.ingredients = ingredients;
        this.method = method;
    }

    public Recipe(Long id, String title, String ingredients, String method) {
        this.id = id;
        this.title = title;
        this.ingredients = ingredients;
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
