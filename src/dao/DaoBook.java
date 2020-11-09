/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bookstore.entities.Book;
import java.sql.*;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author RBS
 */
public class DaoBook {

    // pour ajouter un nouveau book
    public void AddBook(Book book) throws SQLException {
        //cnx to database
        Connection con = null;
        int id;
        double price;
        String title, author;
        Date releaseDate;
        try {
            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        price = book.getPrice();
        title = book.getTitle();
        author = book.getAuthor();
        releaseDate = book.getReleaseDate();
        String query = "insert into book (title,price,author,releaseDate)values(?,?,?,?)";
        PreparedStatement preparedStmt = con.prepareStatement(query);
       
        preparedStmt.setString(1, title);
        preparedStmt.setDouble(2, price);
        preparedStmt.setString(3, author);
        preparedStmt.setDate(4, releaseDate);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        System.out.println("New book is registred !");
        System.out.println("Title:" + title  + "Author:" + author + "Price:" + price + "RelaseDate"+releaseDate );
        con.close();
    }

    
    //lister les book
    public List<Book> listBook() throws SQLException {
        Statement stmt;
        Connection con = null;
        try {

            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        String query = "select * from book";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List ll = new LinkedList();
        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            Date rDate = rs.getDate("releaseDate");
            Book book = new Book( title, author, price,rDate );
            ll.add(book);
         
        }
            con.close();
        return ll;
       
    }
}
