/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.services;

import com.mycompany.projectz.daos.IProductDao;
import com.mycompany.projectz.models.Product;
import java.util.List;

/**
 *
 * @author juandre
 */
public class ProductService implements IProductService {

    private final IProductDao productDao;

    public ProductService(IProductDao productDao){
        this.productDao = productDao;
    }

    public List<Product> getAll(){
        return productDao.getAllProducts();
    }
    public Product getById(int id){
        return productDao.getById(id);
    }

    public List<Product> getByCategoryId(int id){
        return productDao.getByCategory(id);
    }

    public boolean addProduct(Product proudct){
        return productDao.addProduct(proudct);
    }

    public boolean updateProduct(Product product){
        return productDao.updateProduct(product);
    }

    public boolean deleteProduct(int id){
        return productDao.deleteProduct(id);
    }
}