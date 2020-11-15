/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Loukas
 */
public class ConnectionDB {
    public Connection BookStoreDB(){
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    
    }
}
