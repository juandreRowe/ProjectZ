/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.services;

import com.mycompany.projectz.daos.ICategoryDao;
import com.mycompany.projectz.models.Category;
import java.util.List;

/**
 *
 * @author juandre
 */
public class CategoryService implements ICategoryService {
    
    private final ICategoryDao categoryDao;

    public CategoryService(ICategoryDao categoryDao){
        this.categoryDao = categoryDao;
    }

    public List<Category> getAll(){
        return categoryDao.getAllCategories();
    }

    public Category getById(int id){
        return categoryDao.getById(id);
    }

    public boolean addCategory(Category category){
        return categoryDao.addCategory(category);
    }

    public boolean updateCategory(Category category){
        return categoryDao.updateCategory(category);
    }

    public boolean deleteCategory(int id){
        return categoryDao.deleteCategory(id);
    }
}