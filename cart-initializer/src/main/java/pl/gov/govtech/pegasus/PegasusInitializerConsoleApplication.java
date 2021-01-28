package pl.gov.govtech.pegasus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.gov.govtech.pegasus.generators.CustomersGenerator;
import pl.gov.govtech.pegasus.generators.OrdersGenerator;
import pl.gov.govtech.pegasus.generators.ItemsGenerator;
import validator.Validator;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class PegasusInitializerConsoleApplication implements CommandLineRunner {

    private final ItemsGenerator itemsGenerator;

    private final CustomersGenerator customersGenerator;

    private final OrdersGenerator ordersGenerator;

    @Autowired
    public PegasusInitializerConsoleApplication(ItemsGenerator itemsGenerator,
                                                CustomersGenerator customersGenerator,
                                                OrdersGenerator ordersGenerator) {
        this.itemsGenerator = Validator.requireNonNull(itemsGenerator, "items generator");
        this.customersGenerator = Validator.requireNonNull(customersGenerator, "customers generator");
        this.ordersGenerator = Validator.requireNonNull(ordersGenerator, "orders generator");
    }

    public static void main(String[] args) {
        SpringApplication.run(PegasusInitializerConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        itemsGenerator.generate();
        customersGenerator.generate();
        ordersGenerator.generate();
    }
}
