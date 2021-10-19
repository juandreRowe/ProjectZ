/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.services;

import com.mycompany.projectz.models.Product;
import java.util.List;


/**
 *
 * @author juandre
 */
public interface IProductService {
    public abstract List<Product> getAll();
    public abstract Product getById(int id);
    public abstract List<Product> getByCategoryId(int id);
    public abstract boolean addProduct(Product proudct);
    public abstract boolean updateProduct(Product product);
    public abstract boolean deleteProduct(int id);
}
