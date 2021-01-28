package pl.gov.govtech.pegasus.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gov.govtech.pegasus.customer.model.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Customer> findById(long id);

}
