package ch.hearc.ig.odi.customeraccount.business;

import java.util.ArrayList;
import java.util.Collection;


public class Customer {

	private Integer number;
	private String firstName;
	private String lastName;
	private Collection<Account> accounts;

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
                this.accounts = new ArrayList<>();
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
            for (Account a : this.accounts) {
                if(a.getNumber().equals(number)) {
                    result = a;
                }
            }
            return result;
	}

	/**
	 * 
	 * @param number
	 * @param name
	 * @param rate
	 */
	public void addAcount(String number, String name, double rate) {
		this.accounts.add(new Account(number, name, rate, this));
        }

	public Collection<Account> getAccounts() {
		return this.accounts;
	}

        public void sePresenter() {
            System.out.println("Client " + this.number + " : " + this.firstName + " " + this.lastName);
            for(Account a : accounts) {
                System.out.println("    Compte " + a.getNumber() + " : " + a.getName() + ", solde = " + a.getBalance() + ", taux = " + a.getRate());
            }
        }
}