/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import bookstore.entities.Book;
import bookstore.entities.Commande;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 *
 * @author noure
 */
public class DaoCommande {
    
    
    ConnectionDB c = new ConnectionDB();
    Connection con = c.BookStoreDB();
    
    
    public ArrayList<Commande> listCommande() throws SQLException {
   
        Statement stmt;
        ArrayList<Book> lb = new ArrayList<Book>(); 
        ArrayList<Commande> li = new ArrayList<Commande>(); 
        String query = "select * from Commande group by idClient,commande";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            int idClient = rs.getInt("idClient");
            int idBook = rs.getInt("idBook");
            double prix = rs.getDouble("prix");
            Date commande = rs.getDate("commande");        
            Commande C = new Commande(prix, commande, idClient, lb);
            li.add(C);
        }
        
        return li;
    }
    
    public void AddCommande(ArrayList<Book> lb) throws SQLException {
        
        PreparedStatement preparedStmt;
        double prix;
        int id, idClient;
        Date commande;
        
        Commande C=new Commande();
        con = c.BookStoreDB();
        prix = C.getPrix();
        idClient = C.getIdClient();     
        commande = C.getCommande();
        ListIterator<Book> li = lb.listIterator();
        while(li.hasNext())
        {    
        Book b =li.next();
        int idb=b.getId();
        String query = "insert into Commande (prix,idClient,commande,idBook)values(?,?,?,?)";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setDouble(1, prix);
        preparedStmt.setDouble(2, idClient);
        preparedStmt.setDate(3, commande);
        preparedStmt.setInt(4, idb);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        }
        System.out.println("New order is registred !");
        
       
    }

    
    con.close();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
