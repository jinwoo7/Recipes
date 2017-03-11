/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RecipeSearch;

import java.util.List;

/**
 *
 * @author Jinwoo
 */
public class SearchedRecipe {
    
    /*
    ==========================================================
    Instance variables representing the attributes of a movie.
    ==========================================================
     */
    
    private String label;
    private String sourceName;
    private String imageURL;
    private String sourceURL;
    private String dietLabels;
    private String healthLabels;
    private String ingredientLines;
    private String calories;
    
    /*
    ====================================================
    Class constructors for instantiating a SearchedMovie 
    object to represent a particular movie.
    ====================================================
     */
    public SearchedRecipe() {
    }

    public SearchedRecipe(String label, String sourceName, String imageURL, String sourceURL, String dietLabels, String healthLabels, String ingredientLines, String calories) {
        this.label = label;
        this.sourceName = sourceName;
        this.imageURL = imageURL;
        this.sourceURL = sourceURL;
        this.dietLabels = dietLabels;
        this.healthLabels = healthLabels;
        this.ingredientLines = ingredientLines;
        this.calories = calories;
    }
    
    /*
    ==============================================================
    Getter and Setter methods for the attributes of a movie.
    ==============================================================
     */

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    
    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(String dietLabels) {
        this.dietLabels = dietLabels;
    }

    public String getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(String healthLabels) {
        this.healthLabels = healthLabels;
    }

    public String getIngredientLines() {
        return ingredientLines;
    }

    public void setIngredientLines(String ingredientLines) {
        this.ingredientLines = ingredientLines;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
    
    
}
