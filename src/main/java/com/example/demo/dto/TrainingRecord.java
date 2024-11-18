package com.example.demo.dto;

import com.example.demo.model.Ingrediente;

import java.util.HashMap;

public class TrainingRecord {

    Long recipeId;
    public HashMap<String, Integer> ingredientPresence = new HashMap<>(); // 1 if ingredient is present, 0 if not
    public HashMap<Integer, Integer> categoryPresence = new HashMap<>();   // 1 if category is present, 0 if not
    int liked; // 1 for liked, 0 for not liked

    // Constructor
    public TrainingRecord( Long recipeId, int liked) {
        this.recipeId = recipeId;
        this.liked = liked;
    }

    public int getLiked() {
        return liked;
    }

    public HashMap<Integer, Integer> getCategoryPresence() {
        return categoryPresence;
    }

    public HashMap<String, Integer> getIngredientPresence() {
        return ingredientPresence;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    @Override
    public String toString() {
        return "TrainingRecord{" +
                ", recipeId=" + recipeId +
                ", ingredientPresence=" + ingredientPresence +
                ", categoryPresence=" + categoryPresence +
                ", liked=" + liked +
                '}';
    }

}
