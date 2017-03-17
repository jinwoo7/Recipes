/*
 * Created by Jinwoo Yom on 2017.03.09  * 
 * Copyright © 2017 Jinwoo Yom. All rights reserved. * 
 */
package com.mycompany.Recipes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jinwoo
 */
@Entity
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r")
    , @NamedQuery(name = "Recipe.findById", query = "SELECT r FROM Recipe r WHERE r.id = :id")
    , @NamedQuery(name = "Recipe.findByTitle", query = "SELECT r FROM Recipe r WHERE r.title = :title")
    , @NamedQuery(name = "Recipe.findByImageUrl", query = "SELECT r FROM Recipe r WHERE r.imageUrl = :imageUrl")
    , @NamedQuery(name = "Recipe.findBySourceName", query = "SELECT r FROM Recipe r WHERE r.sourceName = :sourceName")
    , @NamedQuery(name = "Recipe.findBySourceUrl", query = "SELECT r FROM Recipe r WHERE r.sourceUrl = :sourceUrl")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image_url")
    private String imageUrl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "source_name")
    private String sourceName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "source_url")
    private String sourceUrl;

    public Recipe() {
    }

    public Recipe(Integer id) {
        this.id = id;
    }

    public Recipe(Integer id, String title, String imageUrl, String sourceName, String sourceUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.sourceName = sourceName;
        this.sourceUrl = sourceUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.Recipes.Recipe[ id=" + id + " ]";
    }
    
}
