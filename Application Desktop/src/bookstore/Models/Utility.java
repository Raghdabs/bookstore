/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Models;

/**
 *
 * @author Loukas
 */
public class Utility {
    public double CalculateTotalPrice(int qte, double prixU){
    double priceT;
    priceT=qte*prixU;
        return priceT;
    }
}
