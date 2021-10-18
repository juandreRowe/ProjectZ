/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juandre
 * @param <T>
 */
public abstract class AbstractDao<T> {
    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public AbstractDao(Connection connection){
        this.connection = connection;
    }

    private void prepareStatement(String query, Object... params){
        if(connection != null){
            try{
                preparedStatement = connection.prepareStatement(query);
                for(int x = 0; x < params.length; x++){
                    preparedStatement.setObject(x + 1, params[x]);
                }
            }catch(SQLException ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    protected abstract T extractFromResultSet();

    public ResultSet getResultSet(){return this.resultSet;}

    public List<T> selectStatement(String query, Object... params){
         List<T> elements = new ArrayList<>();
         prepareStatement(query, params);
         try{
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                elements.add(this.extractFromResultSet());
            }
            this.closeCloseable(resultSet);
            this.closeCloseable(preparedStatement);
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
         return elements;
    }

    public boolean modifyStatement(String query, Object... params){
        int rowsAffected = -5;
        this.prepareStatement(query, params);
        try{
            rowsAffected = preparedStatement.executeUpdate();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return rowsAffected == 1;
    }

    private void closeCloseable(AutoCloseable closeable){
        if(closeable != null){
            try{
                closeable.close();
            }catch(Exception ex){
                System.err.println(ex.getMessage());
            }
        }
    }

    public void closeConnection(){
        this.closeCloseable(connection);
    }

}
