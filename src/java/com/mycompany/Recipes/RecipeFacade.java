/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Recipes;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jinwoo
 */
@Stateless
public class RecipeFacade extends AbstractFacade<Recipe> {

    @PersistenceContext(unitName = "Recipes-YomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecipeFacade() {
        super(Recipe.class);
    }
    
    /*
    -----------------------------
    Search Category: COUNTRY NAME
    -----------------------------
     */
    /**
     * Searches CompaniesDB for companies where country name contains the searchString entered by the user.
     *
     * @param searchString contains the search string the user entered for searching country names
     * @return A list of Company object references as the search results
     */
    public List<Recipe> countryQuery(String searchString, String dietLabel, String healthLabel, Integer maxNum) {
        // Place the % wildcard before and after the search string to search for it anywhere in the country name 
        searchString = "%" + searchString.trim().replace(' ', '+') + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery("SELECT c FROM recipe c WHERE (c.title LIKE :searchString OR c.source_name LIKE :searchString) AND c.").setParameter("searchString", searchString).getResultList();
    }
}
