/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.RecipeSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
/**
 *
 * @author Jinwoo
 */
@SessionScoped  // let the variables be maintained during the session
// one instantiation per user (singleton)
@Named(value = "SearchedRecipeController")  // allows this object that is instantiated to be managed by JSF
public class SearchedRecipeController implements Serializable {
    
    private final String edamamSearchRecipeBaseUrl  = "https://api.edamam.com/search";
    private final String edamamAppID = "app_id=fc155123";
    private final String edamamAppKey = "app_key=b34fb9844e7e7ae8ed230dd708fae7d9";
    
    /* The values of these private properties are supplied by the user */
    private String searchText;      // Text to Search
    private String dietLabel;       // Diet Label
    private String healthLabel;     // Health Label
    private int maxNumber;          // Max. Number of recipes
    
    private List<SearchedRecipe> searchedRecipes;
    private SearchedRecipe selected;
    private String statusMessage;

    /**
     * Creates a new instance of searchedRecipeController
     */
    public SearchedRecipeController() {
    }
    
    public String performSearch() {
        if (searchText == null || dietLabel == null 
                || healthLabel == null || maxNumber == 0) {
            return "index?";
        }
        
        selected = null;
        statusMessage = "";

        JSONArray jsonArray;
        searchedRecipes = new ArrayList();
        
        // Spaces in search query must be replaced with "+"
        searchText = searchText.replaceAll(" ", "+");
        
        try {
            /*
            https://api.edamam.com/search?q=chicken&app_id=f077da94&app_key=d444c85f2d375f21f154e04c41e3b47a&from=0&to=50&diet=low-fat&health=peanut-free

            JSON data use the following notation:
            { }    represents a JavaScript object as a Dictionary with Key:Value pairs
            [ ]    represents Array
            [{ }]  represents an Array of JavaScript objects (dictionaries)
              :    separates Key from the Value
             */

            String RecipeSearchWebServiceUrl = edamamSearchRecipeBaseUrl + "?q=" + searchText 
                    + "&" + edamamAppID + "&" + edamamAppKey + "&from=0&to=" + maxNumber 
                    + "&diet=" + dietLabel + "&health=" + healthLabel;

            // Obtain the JSON file containing the movie search results at the given page number
            String recipeSearchResultsJsonData = readUrlContent(RecipeSearchWebServiceUrl);

            // The returned JSON data comes as a dictionary. Enclose it within an array.
            recipeSearchResultsJsonData = "[" + recipeSearchResultsJsonData + "]";

            // Instantiate a JSON Array object from the JSON data obtained as an array
            jsonArray = new JSONArray(recipeSearchResultsJsonData);

            /*
            jsonArray.getJSONObject(0), object at index 0, gives the dictionary returned in the JSON file.
            getJSONArray("results") gets the list of movies given under the KEY "results" of the dictionary.
             */
            JSONArray jsonArrayFoundRecipes = jsonArray.getJSONObject(0).getJSONArray("hits");
            int index = 0;

            if (jsonArrayFoundRecipes.length() > index) {

                while (jsonArrayFoundRecipes.length() > index) {

                    // Get the JSONObject at index
                    JSONObject jsonObject = jsonArrayFoundRecipes.getJSONObject(index).getJSONObject("recipe");
                    /*
                    ======== JSON Data Optional Processing ======== 

                    optBoolean(String key, boolean defaultValue) 
                        Obtain the Boolean value for the given "key" if a value exists; otherwise, use the defaultValue.

                    optDouble(String key, double defaultValue) 
                        Obtain the Double value for the given "key", or use the defaultValue if there is no such key or if its value is not a number.

                    optInt(String key, int defaultValue) 
                        Obtain the Int value for the given "key", or use the defaultValue if there is no such key or if its value is not a number.

                    optLong(String key, long defaultValue) 
                        Obtain the Long value for the given "key", or use the defaultValue if there is no such key or if its value is not a number.

                    optString(String key, String defaultValue) 
                        Obtain the String value for the given "key" if a value exists; otherwise, use the defaultValue.

                    ============================
                    Recipe Source Name
                    ============================
                     */
                    String label = jsonObject.optString("label", "");
                    if (label.equals("")) {
                        // Skip the movie with no poster image provided
                        index++;
                        continue;
                    }

                    /*
                    =========================
                    Recipe Source name
                    =========================
                     */
                    String sourceName = jsonObject.optString("source", "");
                    if (sourceName.equals("")) {
                        // Skip the movie with no poster image provided
                        index++;
                        continue;
                    }

                    /*
                    ==================
                    Recipe Image URL
                    ==================
                     */
                    String imageURL;
                    imageURL = jsonObject.optString("image", "");
                    if (imageURL.equals("")) {
                        // Skip the movie with no poster image provided
                        index++;
                        continue;
                    }
                    
                    /*
                    ==================
                    Recipe URL
                    ==================
                     */
                    String sourceURL;
                    sourceURL = jsonObject.optString("url", "");
                    if (sourceURL.equals("")) {
                        // Skip the movie with no poster image provided
                        index++;
                        continue;
                    }

                    /*
                    =====================================
                    Diet Labels
                    =====================================
                     */
                    JSONArray dietLabelsArray = jsonObject.getJSONArray("dietLabels");
                    String dietLabels = "";
                    if (dietLabelsArray.length() > 0) {
                        int object_Index = 0;
                        dietLabels += dietLabelsArray.getString(object_Index);
                        object_Index++;
                        while (dietLabelsArray.length() > object_Index) {
                            dietLabels += ", " + dietLabelsArray.getString(object_Index);
                            object_Index++;
                        }
                    } else {
                        dietLabels="No Diet Labels found!";
                    }

                    /*
                    =====================================
                    Health Labels
                    =====================================
                     */
                    JSONArray healthLabelsArray = jsonObject.getJSONArray("healthLabels");
                    String healthLabels = "";
                    if (healthLabelsArray.length() > 0) {
                        int object_Index = 0;
                        healthLabels += healthLabelsArray.getString(object_Index);
                        object_Index++;
                        while (healthLabelsArray.length() > object_Index) {
                            healthLabels += ", " + healthLabelsArray.getString(object_Index);
                            object_Index++;
                        }
                    } else {
                        healthLabels="No Health Labels found!";
                    }
                    
                    /*
                    =====================================
                    Health Labels
                    =====================================
                     */
                    JSONArray ingredientLinesArray = jsonObject.getJSONArray("ingredientLines");
                    String ingredientLines = "";
                    if (ingredientLinesArray.length() > 0) {
                        int object_Index = 0;
                        ingredientLines += ingredientLinesArray.getString(object_Index);
                        object_Index++;
                        while (ingredientLinesArray.length() > object_Index) {
                            ingredientLines += ", " + ingredientLinesArray.getString(object_Index);
                            object_Index++;
                        }
                    } else {
                        ingredientLines = "No Ingredients found!";
                    }
                    
                    /*
                    ==================
                    Calories
                    ==================
                     */
                    Double calories_double = jsonObject.getDouble("calories");
                    /* Round the calculated total interest value to 2 decimal places */
                    calories_double = calories_double * 100;
                    calories_double = (double) Math.round(calories_double);
                    calories_double = calories_double / 100;
                    
                    String calories = Double.toString(calories_double);
                    if (calories.equals("")) {
                        calories = "Calories Not Specified";
                    }

                    /*
                    ================================================================
                    Create a new SearchedMovie object dressed up with its Attributes
                    ================================================================
                     */
                    SearchedRecipe movie = new SearchedRecipe(label, sourceName, 
                            imageURL, sourceURL, dietLabels, healthLabels, ingredientLines, calories);

                    // Add the newly created SearchedMovie object to the list of searchedMovies
                    searchedRecipes.add(movie);
                    index++;

                    /*
                    ===========================================================
                    Sleep not to exceed TMDb API limit of 4 accesses per second
                    ===========================================================
                     */
                    //Thread.sleep(500);    // 1000 milliseconds = 1 second
                }

            } else {
                // Take no action since there are no search results at this page number
            }

        } catch (Exception ex) {
            statusMessage = "Something went wrong during the query";
            Logger.getLogger(SearchedRecipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        searchText = "";
        return "RecipeSearchResults?faces-redirect=true";
    }
    
    public String clearSearchFields() {

        searchText = null;
        dietLabel = null;
        healthLabel = null;
        maxNumber = 0;

        /* Return the name of the XHTML page to show */
        return "index?";
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getDietLabel() {
        return dietLabel;
    }

    public void setDietLabel(String dietLabel) {
        this.dietLabel = dietLabel;
    }

    public String getHealthLabel() {
        return healthLabel;
    }

    public void setHealthLabel(String healthLabel) {
        this.healthLabel = healthLabel;
    }
    
    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    
    /*
    ================
    Instance Methods
    ================
     */
    /**
     * Return the content of a given URL as String
     *
     * @param webServiceURL to retrieve the JSON data from
     * @return JSON data from the given URL as String
     * @throws Exception
     */
    public String readUrlContent(String webServiceURL) throws Exception {
        /*
        reader is an object reference pointing to an object instantiated from the BufferedReader class.
        Currently, it is "null" pointing to nothing.
         */
        BufferedReader reader = null;

        try {
            // Create a URL object from the webServiceURL given
            URL url = new URL(webServiceURL);
            /*
            The BufferedReader class reads text from a character-input stream, buffering characters
            so as to provide for the efficient reading of characters, arrays, and lines.
             */
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            // Create a mutable sequence of characters and store its object reference into buffer
            StringBuilder buffer = new StringBuilder();

            // Create an array of characters of size 10240
            char[] chars = new char[10240];

            int numberOfCharactersRead;
            /*
            The read(chars) method of the reader object instantiated from the BufferedReader class
            reads 10240 characters as defined by "chars" into a portion of a buffered array.

            The read(chars) method attempts to read as many characters as possible by repeatedly
            invoking the read method of the underlying stream. This iterated read continues until
            one of the following conditions becomes true:

                (1) The specified number of characters have been read, thus returning the number of characters read.
                (2) The read method of the underlying stream returns -1, indicating end-of-file, or
                (3) The ready method of the underlying stream returns false, indicating that further input requests would block.

            If the first read on the underlying stream returns -1 to indicate end-of-file then the read(chars) method returns -1.
            Otherwise the read(chars) method returns the number of characters actually read.
             */
            while ((numberOfCharactersRead = reader.read(chars)) != -1) {
                buffer.append(chars, 0, numberOfCharactersRead);
            }

            // Return the String representation of the created buffer
            return buffer.toString();

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
    
    public List<SearchedRecipe> getSearchedRecipes() {
        return searchedRecipes;
    }

    public void setSearchedRecipes(List<SearchedRecipe> searchedRecipes) {
        this.searchedRecipes = searchedRecipes;
    }

    public SearchedRecipe getSelected() {
        return selected;
    }

    public void setSelected(SearchedRecipe selected) {
        this.selected = selected;
    }
}
