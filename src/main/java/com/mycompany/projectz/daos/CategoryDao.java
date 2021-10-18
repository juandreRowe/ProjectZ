/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.daos;

import com.mycompany.projectz.config.ConnectionFactory;
import com.mycompany.projectz.models.Category;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author juandre
 */
public class CategoryDao extends AbstractDao<Category> implements ICategoryDao {
    
    public CategoryDao(Connection connection){
        super(connection);
    }

    public List<Category> getAllCategories(){
        return this.selectStatement("select * from Category");
    }
    public Category getById(int id){
        List<Category> categories = this.selectStatement("select * from Category where id = ?", id);
        if(!categories.isEmpty()){
            return categories.get(0);
        }
        return new Category();
    }
    public boolean addCategory(Category category){
        return this.modifyStatement("insert into Category (name) values(?)"
        , new Object[]{category.getName()});
    }
    public boolean updateCategory(Category category){
        return this.modifyStatement("update Category set name = ? where id = ?", category.getName(), category.getId());
    }
    public boolean deleteCategory(int id){
         return this.modifyStatement("delete from Category where id = ?", id);
    }

    protected Category extractFromResultSet(){
        Category category = new Category();
        try{
            category.setId(this.getResultSet().getInt("id"));
            category.setName(this.getResultSet().getString("name"));
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return category;
    }

    public static void main(String[] args) {
        ICategoryDao categoryDao = new CategoryDao(ConnectionFactory.getInstance());
        System.out.println(categoryDao.getAllCategories());
    }
}
