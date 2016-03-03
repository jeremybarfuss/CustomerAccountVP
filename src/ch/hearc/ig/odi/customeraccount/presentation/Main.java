/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.customeraccount.presentation;

import ch.hearc.ig.odi.customeraccount.business.Account;
import ch.hearc.ig.odi.customeraccount.business.Customer;

/**
 *
 * @author J�r�my
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Cr�ation de 2 clients test
        Customer c1 = new Customer(1, "J�r�my", "B�rfus");
        c1.addAcount("10-195966-0", "Compte courant", 0.01);
        c1.addAcount("62-524812-1", "Compte �pargne", 0.25);

        Customer c2 = new Customer(2, "Michel", "Comptable");
        c2.addAcount("10-352790-1", "Impots", 0.01);

        // Test des cr�dits
        c1.getAccountByNumber("10-195966-0").credit(800);
        c1.getAccountByNumber("62-524812-1").credit(800000);
        c2.getAccountByNumber("10-352790-1").credit(3000);
        c2.getAccountByNumber("10-352790-1").credit(-100); // Erreur : montant n�gatif

        // Test des d�bits
        c1.getAccountByNumber("10-195966-0").debit(1000); // Erreur : solde 800 - d�bit 1000
        c1.getAccountByNumber("10-195966-0").debit(-100); // Erreur : montant n�gatif
        c1.getAccountByNumber("62-524812-1").debit(5000);

        // Test des transferts
        Account.transfer(1000, c1.getAccountByNumber("10-195966-0"), c2.getAccountByNumber("10-352790-1")); // Erreur : solde 800 - transfert 1000
        Account.transfer(-100, c1.getAccountByNumber("10-195966-0"), c2.getAccountByNumber("10-352790-1")); // Erreur : montant n�gatif
        Account.transfer(1000, c2.getAccountByNumber("10-352790-1"), c1.getAccountByNumber("10-195966-0"));

        // Affichage des clients et leurs comptes
        /*c1.sePresenter();
        c2.sePresenter();*/

    }

}
