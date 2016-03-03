package ch.hearc.ig.odi.customeraccount.business;

public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.01;

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public Account(String number, String name, double rate, Customer customer) {
        this.customer = customer;
        this.number = number;
        this.name = name;
        this.rate = rate;
    }

    public String getNumber() {
        return this.number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return this.rate;
    }

    /**
     *
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    /**
     *
     * @param amount
     */
    public void credit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Erreur : Montant négatif");
        }
    }

    /**
     *
     * @param amount
     */
    public void debit(double amount) {
        if (this.balance > amount && amount > 0) {
            this.balance -= amount;
        } else if (amount < 0) {
            System.out.println("Erreur : Montant négatif");
        } else {
            System.out.println("Solde insuffisant pour débiter " + amount);
        }
    }

    /**
     *
     * @param amount
     * @param source
     * @param target
     */
    public static void transfer(double amount, Account source, Account target) {
        if (source.getBalance() > amount && amount > 0) {
            source.debit(amount);
            target.credit(amount);
        } else if (amount < 0) {
            System.out.println("Erreur : Montant négatif");
        } else {
            System.out.println("Solde insuffisant pour transférer " + amount);
        }
    }
}
