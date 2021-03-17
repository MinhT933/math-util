/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dto;

/**
 *
 * @author MinhT
 */
public class Categories {
    private String id;
    private String nameCate;
    private String description;

    public Categories(String id, String nameCate, String description) {
        this.id = id;
        this.nameCate = nameCate;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Categories{" + "id=" + id + ", nameCate=" + nameCate + ", description=" + description + '}';
    }

  
    
}
