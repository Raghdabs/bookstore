/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.entities;


import java.sql.Date;
import java.util.ArrayList;
import bookstore.entities.Book;

/**
 *
 * @author noure
 */
public class Commande {
    private int id;
    private double prix;
    private Date commande;
    private int idClient;
    private ArrayList<Book> lb;

    
    public Commande() {
    }

    public Commande(double prix, Date commande, int idClient, ArrayList<Book> lb)
    {

        this.id = id;
        this.prix = prix;
        this.commande = commande;
        this.idClient = idClient;
        this.lb= lb;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getCommande() {
        return commande;
    }

    public void setCommande(Date commande) {
        this.commande = commande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public ArrayList<Book> getLb() {
        return lb;
    }

    public void setLb(ArrayList<Book> lb) {
        this.lb = lb;
    }
    
    
    
    
    
    
    
    
    
}
