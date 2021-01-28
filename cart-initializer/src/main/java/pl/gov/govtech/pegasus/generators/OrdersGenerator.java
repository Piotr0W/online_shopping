package pl.gov.govtech.pegasus.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static pl.gov.govtech.pegasus.items.model.Department.*;
import static validator.Validator.requireNonNull;

@Service
public class OrdersGenerator {

    @Autowired
    private final OrdersBuilder ordersBuilder;

    @Autowired
    public OrdersGenerator(OrdersBuilder ordersBuilder) {
        this.ordersBuilder = requireNonNull(ordersBuilder, "orders builder");
    }

    public void generate() {

        // TD zmniejszanie ilości produktów i sumowanie cen

        ordersBuilder
                .customer("Mark", "Lamb")
                .department(BOOKS_AND_COMICS)
                .itemNumber(1)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Julie", "Evans")
                .department(CHILD)
                .itemNumber(2)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Niall", "Alexander")
                .department(HOUSE_AND_GARDEN)
                .itemNumber(3)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Theresa", "Rowe")
                .department(HEALTH)
                .itemNumber(4)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Ashley", "Ford")
                .department(COLLECTIONS)
                .itemNumber(5)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Mitchell", "Paul")
                .department(MOTORIZATION)
                .itemNumber(6)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Ruby", "Turner")
                .department(TELEPHONES_AND_ACCESSORIES)
                .itemNumber(7)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Darcie", "Peters")
                .department(CLOTHING_SHOES_ACCESSORIES)
                .itemNumber(8)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Jim", "Yang")
                .department(SPORTS_AND_TOURISM)
                .itemNumber(9)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Ivan", "Davis")
                .department(BEAUTY)
                .itemNumber(10)
                .from("2021-01-01")
                .to("2021-01-10")
                .build();

        ordersBuilder
                .customer("Mark", "Lamb")
                .department(SUPERMARKET)
                .itemNumber(11)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Julie", "Evans")
                .department(COMPUTERS)
                .itemNumber(12)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Niall", "Alexander")
                .department(RTV_AND_HOUSEHOLD_APPLIANCES)
                .itemNumber(13)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Theresa", "Rowe")
                .department(INDUSTRY)
                .itemNumber(14)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Ashley", "Ford")
                .department(MOVIES)
                .itemNumber(15)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Mitchell", "Paul")
                .department(MUSIC)
                .itemNumber(16)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Ruby", "Turner")
                .department(JEWELRY_AND_WATCHES)
                .itemNumber(17)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Darcie", "Peters")
                .department(INSTRUMENTS)
                .itemNumber(18)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Jim", "Yang")
                .department(GADGETS)
                .itemNumber(19)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

        ordersBuilder
                .customer("Ivan", "Davis")
                .department(HEALTH)
                .itemNumber(20)
                .from("2021-01-01")
                .to("2021-12-31")
                .build();

    }

}
