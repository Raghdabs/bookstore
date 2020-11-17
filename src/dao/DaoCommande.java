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
/**
 *
 * @author noure
 */
public class DaoCommande {
    
    
    ConnectionDB c = new ConnectionDB();
    Connection con = c.BookStoreDB();
    
    
    public ArrayList<Commande> listCommande() throws SQLException {
        con = c.BookStoreDB();
        Statement stmt;
        ArrayList<Book> lb = new ArrayList<Book>(); 
        ArrayList<Commande> li = new ArrayList<Commande>(); 
        String query = "select * from commande";
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id=rs.getInt("id");
            String nom = rs.getString("nom");
            Date d = rs.getDate("dcommande");
            int tel = rs.getInt("tel");
            String adress = rs.getString("adress");
            double prix = rs.getDouble("prix");
            Commande C = new Commande(id,nom,d,tel,adress,prix);
            li.add(C);
        }
        
        con.close();
        return li;
    }
    public ArrayList<Commande> listCommandeByClient(int idClient ) throws SQLException {
        con = c.BookStoreDB();
        PreparedStatement preparedStmt;
        ArrayList<Book> lb = new ArrayList<Book>(); 
        ArrayList<Commande> li = new ArrayList<Commande>(); 
        String query = "select * from commande where idClient = ?";
       preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, idClient);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            int id=rs.getInt("id");
            double prix = rs.getDouble("prix");
            Date d = rs.getDate("dcommande");
               
            Commande C = new Commande(id,prix, d);
            li.add(C);
        }
        con.close();
        
        return li;
    }
    public ArrayList<Book> listCommandeById(int id ) throws SQLException {
        con = c.BookStoreDB();
        PreparedStatement preparedStmt;
        ArrayList<Book> lb = new ArrayList<Book>(); 
        ArrayList<Commande> li = new ArrayList<Commande>(); 
        String query = "select title from cBooks where idCommande = ?";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        while (rs.next()) {
            
            String title = rs.getString("title"); 
            
            Book C = new Book(title);
            lb.add(C);
        }
        con.close();
        return lb;
    }
    public void AddCommande(Commande com) throws SQLException {
        
         //Declaration
        PreparedStatement preparedStmt;
        double price;
        int idclient;
        Date date;
        Date releaseDate;
        //Start Connection to DataBase
        con = c.BookStoreDB();
        //Initialisation
        price = com.getPrix();
        date = com.getCommande();
        idclient = com.getIdClient();
        String nom=com.getNom();
        String prenom=com.getPrenom();
        String email=com.getEmail();
        int tel=com.getTel();
        String adress=com.getAdress();
        //Add New Book Query
        String query = "insert into commande (prix,dcommande,idclient,nom,prenom,email,tel,adress)values(?,?,?,?,?,?,?,?)";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setDouble(1, price);
        preparedStmt.setDate(2, date);
        preparedStmt.setInt(3, idclient);
        preparedStmt.setString(4, nom);
        preparedStmt.setString(5, prenom);
        preparedStmt.setString(6, email);
        preparedStmt.setInt(7, tel);
        preparedStmt.setString(8, adress);
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        System.out.println("New Commande is registred !");
        System.out.println("price:" + price + "date:" + date + "idClient:" + idclient );
        //Close Connection to DataBase
        con.close();
 
}
 public void cBooks(ArrayList<Book> L) throws SQLException{
 PreparedStatement preparedStmt;
        //Start Connection to DataBase
        ArrayList<Commande> LC=this.listCommande();
        con = c.BookStoreDB();
        //Initialisation
        
        for(int i=0;i<L.size();i++){
        String query = "insert into cbooks (idCommande,idBook,idClient,title)values(?,?,?,?)";
        preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, LC.get(LC.size()-1).getId());
        preparedStmt.setInt(2, L.get(i).getId());
        preparedStmt.setInt(3, LC.get(LC.size()-1).getIdClient());
        preparedStmt.setString(4, L.get(i).getTitle());
        int resultupdate = preparedStmt.executeUpdate();
        System.out.println(resultupdate);
        }
        
        //Close Connection to DataBase
        con.close();
 }
 
}
