package com.vermeg.ams.entities;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Commande {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	
	 @NotBlank(message = "Label is mandatory")
	 @Column(name = "fullname")
	 private String fullname;
	 
	 @Column(name = "price")
	 private float price;
	 
	 @Column(name = "dateCommande")
	 private String dateCommande;
	 
	 @Column(name = "idClient")
	 private int idClient=1;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "commande_line", joinColumns = @JoinColumn(name
	= "commande_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	 
	 private Set<Book> books;
	 
	 
	 
	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Commande(int id, @NotBlank(message = "Label is mandatory") String fullname, float price, String dateCommande,
			int idClient) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.price = price;
		this.dateCommande = dateCommande;
		this.idClient = idClient;
	}

	public Commande() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	 
	
}
