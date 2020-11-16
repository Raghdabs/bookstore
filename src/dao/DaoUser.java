/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bookstore.entities.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Loukas
 */
public class DaoUser {

    Connection con = null;
    ConnectionDB c = new ConnectionDB();

    // ADD NEW User FUNCTION
    public void AddUser(User user) throws SQLException {
        //Declaration
        PreparedStatement preparedStmt;
        String Fname, Lname, Uname, Password, Adress;
        Date Birthdate;
        //Start Connection to DataBase
        con = c.BookStoreDB();
        //Initialisation
        Fname = user.getFirstName();
        Lname = user.getLastName();
        Uname = user.getUserName();
        Birthdate = user.getBirthDate();
        Password = user.getPassword();
        Adress = user.getAdress();
        //Add New Book Query
        String query = "insert into user (firstname,lastname,username,birthdate,adress,password)values(?,?,?,?,?,?)";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, Fname);
        preparedStmt.setString(2, Lname);
        preparedStmt.setString(3, Uname);
        preparedStmt.setDate(4, Birthdate);
        preparedStmt.setString(5, Adress);
        preparedStmt.setString(6, Password);
        int resultupdate = preparedStmt.executeUpdate();
        //Console Affichage
        System.out.println(resultupdate);
        System.out.println("New User is registred !");
        System.out.println("FirstName:" + Fname + "LastName:" + Lname + "UserName:" + Uname + "BirthDate" + Birthdate + "Adress" + Adress);
        //Close Connection to DataBase
        con.close();
    }

    //Check If Username Used or Not Function
    public boolean checkUsername(String User) throws SQLException {
        //Declaration
        boolean b = false;
        PreparedStatement preparedStmt;
        //Start Connection to DataBase
        con = c.BookStoreDB();
        //Search User Query
        String query = "SELECT * FROM `user` WHERE `username`= ? ";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, User);
        ResultSet rs = preparedStmt.executeQuery();
         if(rs.next()) {
            b=true;
        }
        //Close Connection to DataBase
        con.close();
        //return result
        return b;
    }
}
