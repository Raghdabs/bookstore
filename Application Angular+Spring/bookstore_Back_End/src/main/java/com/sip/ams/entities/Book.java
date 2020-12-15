package com.sip.ams.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Book {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 //@NotBlank(message = "title is mandatory")
	 @Column(name = "title")
	 private String title;

	 //@NotBlank(message = "author is mandatory")
	 @Column(name = "author")
	 private String author;

	 //@NotBlank(message = "price is mandatory")
	 @Column(name = "price")
	 private double price;
	 //@NotBlank(message = "releasedate is mandatory")
	 @Column(name = "releasedate")
	 private Date releasedate;
	 public Book() {}
	 public Book(String title, String author, double price,Date releasedate) {
	 this.title = title;
	 this.author = author;
	 this.price = price;
	 this.releasedate=releasedate;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public int getId() {
	 return id;
	 }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	 
	 
	}

