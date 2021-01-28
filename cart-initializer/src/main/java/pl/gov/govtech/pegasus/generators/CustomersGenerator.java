package pl.gov.govtech.pegasus.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static validator.Validator.requireNonNull;

@Service
public class CustomersGenerator {

    private final CustomersBuilder customersBuilder;

    @Autowired
    public CustomersGenerator(CustomersBuilder customersBuilder) {
        this.customersBuilder = requireNonNull(customersBuilder, "customers builder");
    }

    public void generate() {
        customersBuilder
                .firstName("Mark")
                .lastName("Lamb")
                .phoneNumber("575558356")
                .pesel("66050995129")
                .build();

        customersBuilder
                .firstName("Julie")
                .lastName("Evans")
                .phoneNumber("455558579")
                .pesel("78011612235")
                .build();

        customersBuilder
                .firstName("Niall")
                .lastName("Alexander")
                .phoneNumber("665555742")
                .pesel("88082566812")
                .build();

        customersBuilder
                .firstName("Theresa")
                .lastName("Rowe")
                .phoneNumber("575559480")
                .pesel("03241361512")
                .build();

        customersBuilder
                .firstName("Ashley")
                .lastName("Ford")
                .phoneNumber("665551004")
                .pesel("66032124967")
                .build();

        customersBuilder
                .firstName("Mitchell")
                .lastName("Paul")
                .phoneNumber("795553818")
                .pesel("59102987942")
                .build();

        customersBuilder
                .firstName("Ruby")
                .lastName("Turner")
                .phoneNumber("515554528")
                .pesel("59122092543")
                .build();

        customersBuilder
                .firstName("Darcie")
                .lastName("Peters")
                .phoneNumber("505552247")
                .pesel("85102252849")
                .build();
        customersBuilder
                .firstName("Jim")
                .lastName("Yang")
                .phoneNumber("535553800")
                .pesel("81040997444")
                .build();
        customersBuilder
                .firstName("Ivan")
                .lastName("Davis")
                .phoneNumber("455558709")
                .pesel("54071252659")
                .build();


    }

}
