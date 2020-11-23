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
public class User {
    private int id;
    private String FirstName;
    private String LastName;
    private String UserName;
    private Date BirthDate;
    private String Adress;
    private String Password;
    private String UserType;
    private int tel;
    

    public User(String FirstName, String LastName, String UserName, Date BirthDate, String Adress) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.BirthDate = BirthDate;
        this.Adress = Adress;
   
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    


        

    public User(String UserName, String Password,String UserType) {
        this.UserName = UserName;
        this.Password = Password;
        this.UserType = UserType;
    }

    public User(int id, String FirstName, String LastName, String UserName, Date BirthDate, String Adress, String Password, String UserType) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.BirthDate = BirthDate;
        this.Adress = Adress;
        this.Password = Password;
        this.UserType = UserType;
    }

    public User(String FirstName, String LastName, String UserName, Date BirthDate, String Adress, String Password, String UserType, int tel) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.BirthDate = BirthDate;
        this.Adress = Adress;
        this.Password = Password;
        this.UserType = UserType;
        this.tel=tel;
    }

    
    

    

   

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String Adress) {
        this.Adress = Adress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    
}
