/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.daos;

import com.mycompany.projectz.models.Product;
import java.util.List;

/**
 *
 * @author juandre
 */
public interface IProductDao {
    public abstract List<Product> getAllProducts();
    public abstract List<Product> getByCategory(int id);
    public abstract Product getById(int id);
    public abstract boolean deleteProduct(int id);
    public abstract boolean updateProduct(Product product);
    public abstract boolean addProduct(Product product);
}