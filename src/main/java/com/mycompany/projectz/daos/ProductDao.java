/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.daos;

import com.mycompany.projectz.models.Category;
import com.mycompany.projectz.models.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author juandre
 */
public class ProductDao extends AbstractDao<Product> implements IProductDao{

    public ProductDao(Connection connection){
        super(connection);
    }

    public List<Product> getAllProducts(){
        return this.selectStatement("select p.id, p.name, p.description, p.price, p.brand, p.imageLink, category.id as categoryId, category.name as categoryName from Product as p inner join Category as category on p.categoryId = category.id");
    }
    public List<Product> getByCategory(int id){
        return this.selectStatement("select p.id, p.name, p.description, p.price, p.brand, p.imageLink, category.id as categoryId, category.name as categoryName from Product as p inner join Category as category on p.categoryId = category.id where categoryId = ?", id);
    }
    public Product getById(int id){
        List<Product> products = this.selectStatement("select p.id, p.name, p.description, p.price, p.brand, p.imageLink, category.id as categoryId, category.name as categoryName from Product as p inner join Category as category on p.categoryId = category.id where p.id = ?", id);
        if(!products.isEmpty()){
            return products.get(0);
        }
        return null;
    }
    public boolean deleteProduct(int id){
        return this.modifyStatement("delete from Products where id = ?", id);
    }
    public boolean updateProduct(Product product){
        return this.modifyStatement("update Product set name = ?, description = ?, price = ?, imageLink = ?, brand = ?, categoryId = ? where id = ?", product.getName(), product.getDescription()
        , product.getPrice(), product.getImageLink(), product.getBrand(), product.getCategory().getId(), product.getId());
    }
    public boolean addProduct(Product product){
        return this.modifyStatement("insert into Product (name, description, brand, price, imageLink, categoryId) values(?, ?, ?, ?, ?, ?)"
        , product.getName(), product.getDescription(), product.getBrand(), product.getPrice(), product.getImageLink(), product.getCategory().getId());
    }
    protected Product extractFromResultSet(){
        Product product = new Product();
        try{
            product.setId(this.getResultSet().getInt("id"));
            product.setName(this.getResultSet().getString("name"));
            product.setBrand(this.getResultSet().getString("brand"));
            product.setDescription(this.getResultSet().getString("description"));
            product.setImageLink(this.getResultSet().getString("imageLink"));
            product.setPrice(this.getResultSet().getDouble("price"));
            product.setCategory(new Category(this.getResultSet().getInt("categoryId"), this.getResultSet().getString("categoryName")));
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return product;
    }

}