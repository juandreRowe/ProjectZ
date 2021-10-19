/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectz.config;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author juandre
 */
public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory(){}

    public static Connection getInstance(){
        if(connection == null){
            Properties properties = new Properties();
            try{
                properties.load(new FileReader("/home/juandre/NetBeansProjects/ProjectZ/src/main/java/com/mycompany/projectz/config/config.properties"));
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            }catch(ClassNotFoundException | SQLException | IOException ex){
                System.err.println(ex.getMessage());
            }
        }
        return connection;
    }
}
