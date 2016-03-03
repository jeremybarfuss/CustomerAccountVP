package ch.hearc.ig.odi.customeraccount.business;

import java.util.HashMap;

/**
 *
 * @author boris.klett
 */
public class Bank {

    HashMap<String, Account> accounts = new HashMap();
    HashMap<Integer, Customer> customers = new HashMap();
    int number;
    String name;

    public Bank(int p_number, String p_name) {
        this.number = p_number;
        this.name = p_name;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccountByNumber(String p_accountNumber) {
        return this.accounts.get(p_accountNumber);
    }

    public Customer getCustomerByNumber(int p_customerNumber) {
        return this.customers.get(p_customerNumber);
    }

    public void addCustomer(int p_number, String p_lastName, String p_firstName) {
        Customer c = null;
        c = this.customers.get(p_number);
        if (c == null) {
            this.customers.put(p_number, new Customer(p_number, p_firstName, p_lastName));
        }
    }

    public void addNewAccount(String p_number, String p_name, double p_rate, Customer p_customer) {
        Account a = null;
        a = this.accounts.get(p_number);
        Customer c = null;
        c = this.customers.get(p_customer.getNumber());

        if (c == null) {
            this.customers.put(p_customer.getNumber(), new Customer(p_customer.getNumber(), p_customer.getFirstName(), p_customer.getLastName()));
        }

        if (a == null) {
            this.accounts.put(p_number, new Account(p_number, p_name, p_rate, p_customer));
        }
        
        this.customers.get(p_customer.getNumber()).addAcount(p_number, p_name, p_rate);

    }

    public HashMap getCustomers() {
        return this.customers;
    }
}
