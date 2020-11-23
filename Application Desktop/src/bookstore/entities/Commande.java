/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.entities;


import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author noure
 */
public class Commande {
    private int id;
    private double prix;
    private Date Dcommande;
    private int idClient;
    private String nom;
    private String  prenom;
    private String email;
    private int tel;
    private String adress;
    
    

    
    public Commande() {
    }

    public Commande(int id, double prix, Date commande, int idClient) {
        this.id = id;
        this.prix = prix;
        this.Dcommande = commande;
        this.idClient = idClient;
    }

    public Commande(double prix, Date Dcommande) {
        this.prix = prix;
        this.Dcommande = Dcommande;
    }

    public Commande(int id,String nom, Date Dcommande, String adress, int tel,  double prix) {
        this.id = id;
        this.prix = prix;
        this.Dcommande = Dcommande;
        this.nom = nom;
        this.tel = tel;
        this.adress = adress;
    }

    public Commande(String nom, Date Dcommande,  int tel, String adress,double prix) {
        this.prix = prix;
        this.Dcommande = Dcommande;
        this.nom = nom;
        this.tel = tel;
        this.adress = adress;
    }

    public Commande( int id,double prix, Date Dcommande) {
        this.id = id;
        this.prix = prix;
        this.Dcommande = Dcommande;
    }

    public Commande(int id, double prix, Date Dcommande, int idClient, String nom, String prenom, String email, int tel, String adress) {
        this.id = id;
        this.prix = prix;
        this.Dcommande = Dcommande;
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.adress = adress;
    }

    public Date getDcommande() {
        return Dcommande;
    }

    public void setDcommande(Date Dcommande) {
        this.Dcommande = Dcommande;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
   

    public Commande(double prix, Date commande, int idClient, ArrayList<Book> lb)
    {
        this.prix = prix;
        this.Dcommande = commande;
        this.idClient = idClient;
        
    }
    
    public int getId() {
        System.out.print("heres your id");
        return id;
    }

    public Commande(int id,String nom, Date Dcommande,  int tel, String adress, double prix) {
        this.id = id;
        this.prix = prix;
        this.Dcommande = Dcommande;
        this.nom = nom;
        this.tel = tel;
        this.adress = adress;
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
        return Dcommande;
    }

    public void setCommande(Date commande) {
        this.Dcommande = commande;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    

     
}
