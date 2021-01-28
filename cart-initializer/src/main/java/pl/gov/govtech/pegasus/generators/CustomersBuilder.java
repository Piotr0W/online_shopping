package pl.gov.govtech.pegasus.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.govtech.pegasus.customer.model.Customer;
import pl.gov.govtech.pegasus.customer.repo.CustomerRepository;

import static validator.Validator.*;

@Service
public class CustomersBuilder {

    private final CustomerRepository customerRepository;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String pesel;

    @Autowired
    public CustomersBuilder(CustomerRepository customerRepository) {
        this.customerRepository = requireNonNull(customerRepository, "customer repository");
    }

    public CustomersBuilder firstName(String firstName) {
        this.firstName = requireNonEmpty(firstName, "first name");
        return this;
    }

    public CustomersBuilder lastName(String lastName) {
        this.lastName = requireNonEmpty(lastName, "last name");
        return this;
    }

    public CustomersBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = requireNonEmpty(phoneNumber, "phone number");
        return this;
    }

    public CustomersBuilder pesel(String pesel) {
        this.pesel = requireNonEmpty(pesel, "pesel");
        return this;
    }

    public void build() {
        validate();
        Customer customer = new Customer(firstName, lastName, phoneNumber, pesel);
        customerRepository.save(customer);
        reset();
    }

    private void validate() {
        requireNonEmpty(firstName, "first name");
        requireNonEmpty(lastName, "last name");
        requireNonEmpty(phoneNumber, "phone number");
        peselValidation(pesel);
    }

    private void reset() {
        firstName = null;
        lastName = null;
        phoneNumber = null;
        pesel = null;
    }

}
