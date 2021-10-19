/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.services;

import com.mycompany.projectz.models.Category;
import java.util.List;

/**
 *
 * @author juandre
 */
public interface ICategoryService {
    public abstract List<Category> getAll();
    public abstract Category getById(int id);
    public abstract boolean addCategory(Category category);
    public abstract boolean updateCategory(Category category);
    public abstract boolean deleteCategory(int id);
}
