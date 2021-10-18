/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.models;

/**
 *
 * @author juandre
 */
public class Category {
    private int id;
    private String name;

    public Category(){}
    public Category(String name){
        this.setName(name);
    }

    public Category(int id, String name){
        this(name);
        this.setId(id);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "ID: " + id + ", NAME: " + name;
    }
}
