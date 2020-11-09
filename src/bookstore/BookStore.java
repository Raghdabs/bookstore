/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import bookstore.Models.Utility;
import java.util.Scanner;

/**
 *
 * @author chaym
 */
public class BookStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int qt;
        double up, priceT;
        Utility U = new Utility();
        System.out.println("Enter quantity: ");
        Scanner scanner = new Scanner(System.in);
        qt = scanner.nextInt();
        System.out.println("Enter Unit price: ");
        Scanner scanne = new Scanner(System.in);
        up = scanne.nextDouble();
        priceT = U.CalculateTotalPrice(qt, up);
        System.out.println("Total price is equal to "+""+priceT);

    }
}
