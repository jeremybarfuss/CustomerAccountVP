package ch.hearc.ig.odi.customeraccount.business;

import java.util.HashMap;

public class Customer {

    private Integer number;
    private String firstName;
    private String lastName;
    private HashMap<String, Account> accounts;

    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public Customer(Integer number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new HashMap();
    }

    public Integer getNumber() {
        return this.number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @param number
     * @return Account
     */
    public Account getAccountByNumber(String number) {
        Account result = null;
        result = this.accounts.get(number);
        return result;
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     */
    public void addAcount(String number, String name, double rate) {
        Account a = new Account(number, name, rate, this);
        this.accounts.put(a.getNumber(), a);
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }

    /*public void sePresenter() {
     System.out.println("Client " + this.number + " : " + this.firstName + " " + this.lastName);
     for(Account a : accounts) {
     System.out.println("    Compte " + a.getNumber() + " : " + a.getName() + ", solde = " + a.getBalance() + ", taux = " + a.getRate());
     }
     }*/
}
