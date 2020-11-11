/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bookstore.entities.Book;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
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
        System.out.println("Title:" + title + "Author:" + author + "Price:" + price + "RelaseDate" + releaseDate);
        con.close();
    }

    //lister les book
    public ArrayList<Book> listBook() throws SQLException {
        Statement stmt;
        Connection con = null;
        ArrayList<Book> ll = new ArrayList<Book>();
        try {

            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        String query = "select * from book";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            Date rDate = rs.getDate("releaseDate");
            Book book = new Book(id, title, author, price, rDate);
            ll.add(book);

        }
        con.close();
        return ll;

    }

    public Book listBookId(int id) throws SQLException {
        Statement stmt;
        Connection con = null;
        Book book = new Book();
        ArrayList<Book> ll = new ArrayList<Book>();
        try {

            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        String query = "select * from book where id = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();

        while (rs.next()) {

            String title = rs.getString("title");
            String author = rs.getString("author");
            double price = rs.getDouble("price");
            Date rDate = rs.getDate("releaseDate");
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);
            book.setPrice(price);
            book.setReleaseDate(rDate);

        }
        con.close();

        return book;
    }

    public void UpdateB(int id, String title, double price, String author, Date date) throws SQLException {
        Connection con = null;
        try {

            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        String query = "UPDATE book SET title= ?,price= ?,author= ?,releaseDate=? WHERE id = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setString(1, title);
        preparedStmt.setDouble(2, price);
        preparedStmt.setString(3, author);
        preparedStmt.setDate(4, date);
        preparedStmt.setInt(5, id);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
    }
    public void deleteB(int id) throws SQLException{
    Connection con = null;
        try {

            String url = "jdbc:mysql://localhost:3306/bookstore";
            con = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println(e);
        }
        String query = "delete from book where id = ? ";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
    }
}
