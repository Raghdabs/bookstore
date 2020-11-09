/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.entities;

import java.sql.Date;

/**
 *
 * @author Loukas
 */
public class Book {
    
    private int id;
    private String title;
    private String Author;
    private double Price;
  //  private Date ReleaseDate;

    public Book( String title, String Author, double Price) {

        this.title = title;
        this.Author = Author;
        this.Price = Price;
       // this.ReleaseDate = ReleaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

//    public Date getReleaseDate() {
//        return ReleaseDate;
//    }
//
//    public void setReleaseDate(Date ReleaseDate) {
//        this.ReleaseDate = ReleaseDate;
//    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", Author=" + Author + ", Price=" + Price + "'}";
    }
    

}
