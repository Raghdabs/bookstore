/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.Models.Utility;
import bookstore.entities.Book;
import dao.DaoBook;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chaym
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, SQLException {
        //*****************************STEP ONE***********************************
//        int qt;
//        double up, priceT;
//        Utility U = new Utility();
//        System.out.println("Enter quantity: ");
//        Scanner scanner = new Scanner(System.in);
//        qt = scanner.nextInt();
//        System.out.println("Enter Unit price: ");
//        Scanner scanne = new Scanner(System.in);
//        up = scanne.nextDouble();
//        priceT = U.CalculateTotalPrice(qt, up);
//        System.out.println("Total price is equal to "+""+priceT);

        //   *****************************STEP two***********************************
//        int exit = 0, choice;
//        Scanner scanner = new Scanner(System.in);
//
//        while (exit != 1) {
//
//            System.out.println("veillez choisir une commande a faire ...\n");
//            System.out.println("1 : Display Book List \n");
//            System.out.println("2 : Create New Book \n");
//            System.out.println("3 : Exit.\n");
//            choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    DaoBook db = new DaoBook();
//                    List L = new LinkedList();
//                    L = db.listBook();
//                    System.out.println(L);
//
//                    break;
//                case 2:
//
//                    System.out.println("Enter title: ");
//                    Scanner scann = new Scanner(System.in);
//                    String title = scann.nextLine();
//                    System.out.println("Enter author name: ");
//                    Scanner scanne = new Scanner(System.in);
//                    String author = scanne.nextLine();
//                    System.out.println("Enter price: ");
//                    Scanner scan = new Scanner(System.in);
//                    Double price = scan.nextDouble();
//                    //1
//
////                    System.out.println("Enter your release date: ");
////                    Scanner scae = new Scanner(System.in);
////                    Date releaseDate = scae.nextDate();
//                    //2
////                             System.out.println("Saisissez une date (JJ/MM/AAAA) :");
////                    Scanner sc = new Scanner(System.in);
////                    String str = sc.nextLine();
////                    String sDate = "";
////                    if (str.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
////                        SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
////                        Date date = (Date) f.parse(sDate);
////                    } else {
////                        System.out.println("Erreur format");
////                    }
////                    
//                    Book b = new Book(title, author, price);
//                    DaoBook db = new DaoBook();
//                    db.AddBook(b);
//
//                    break;
//                case 3:
//                    exit = 1;
//                    System.out.println("Programme shutting down ...\n");
//                    break;
//                default:
//                    System.out.println("ERR");
//                    break;
//
//            }
//
//        }
//
    }
}
