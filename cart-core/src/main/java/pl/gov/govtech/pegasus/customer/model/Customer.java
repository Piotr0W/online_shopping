package pl.gov.govtech.pegasus.customer.model;

import javax.persistence.*;

import static validator.Validator.peselValidation;
import static validator.Validator.requireNonEmpty;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String pesel;

    protected Customer() {
        // JPA
    }

    public Customer(String firstName, String lastName, String phoneNumber, String pesel) {
        this.firstName = requireNonEmpty(firstName, "first name");
        this.lastName = requireNonEmpty(lastName, "last name");
        this.phoneNumber = requireNonEmpty(phoneNumber, "phone number");
        this.pesel = peselValidation(pesel);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPesel() {
        return pesel;
    }

}
