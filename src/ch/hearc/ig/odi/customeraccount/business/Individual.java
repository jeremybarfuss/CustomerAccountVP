package ch.hearc.ig.odi.customeraccount.business;


import java.util.Date;

/**
 *
 * @author boris.klett
 */
public class Individual extends Customer {

    Date birthdate;
    String email;
    
    public Individual(int number, String firstName, String lastName, Date p_birthdate, String p_email) {
        super(number, firstName, lastName);
        this.birthdate = p_birthdate;
        this.email = p_email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
