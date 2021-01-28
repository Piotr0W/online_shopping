package pl.gov.govtech.pegasus.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gov.govtech.pegasus.items.model.ItemType;

import static pl.gov.govtech.pegasus.items.model.Department.*;
import static pl.gov.govtech.pegasus.items.model.Department.HEALTH;
import static validator.Validator.requireNonNull;

@Service
public class ItemsGenerator {

    private final ItemsBuilder itemsBuilder;

    @Autowired
    public ItemsGenerator(ItemsBuilder itemsBuilder) {
        this.itemsBuilder = requireNonNull(itemsBuilder, "items builder");
    }

    public void generate() {
        itemsBuilder
                .department(BOOKS_AND_COMICS)
                .itemNumber(1)
                .itemType(ItemType.PRODUCT_1)
                .build();

        itemsBuilder
                .department(CHILD)
                .itemNumber(2)
                .itemType(ItemType.PRODUCT_2)
                .build();

        itemsBuilder
                .department(HOUSE_AND_GARDEN)
                .itemNumber(3)
                .itemType(ItemType.PRODUCT_3)
                .build();

        itemsBuilder
                .department(HEALTH)
                .itemNumber(4)
                .itemType(ItemType.PRODUCT_4)
                .build();

        itemsBuilder
                .department(COLLECTIONS)
                .itemNumber(5)
                .itemType(ItemType.PRODUCT_5)
                .build();

        itemsBuilder
                .department(MOTORIZATION)
                .itemNumber(6)
                .itemType(ItemType.PRODUCT_6)
                .build();

        itemsBuilder
                .department(TELEPHONES_AND_ACCESSORIES)
                .itemNumber(7)
                .itemType(ItemType.PRODUCT_7)
                .build();

        itemsBuilder
                .department(CLOTHING_SHOES_ACCESSORIES)
                .itemNumber(8)
                .itemType(ItemType.PRODUCT_8)
                .build();

        itemsBuilder
                .department(SPORTS_AND_TOURISM)
                .itemNumber(9)
                .itemType(ItemType.PRODUCT_9)
                .build();

        itemsBuilder
                .department(BEAUTY)
                .itemNumber(10)
                .itemType(ItemType.PRODUCT_10)
                .build();

        itemsBuilder
                .department(SUPERMARKET)
                .itemNumber(11)
                .itemType(ItemType.PRODUCT_11)
                .build();

        itemsBuilder
                .department(COMPUTERS)
                .itemNumber(12)
                .itemType(ItemType.PRODUCT_12)
                .build();

        itemsBuilder
                .department(RTV_AND_HOUSEHOLD_APPLIANCES)
                .itemNumber(13)
                .itemType(ItemType.PRODUCT_13)
                .build();

        itemsBuilder
                .department(INDUSTRY)
                .itemNumber(14)
                .itemType(ItemType.PRODUCT_14)
                .build();

        itemsBuilder
                .department(MOVIES)
                .itemNumber(15)
                .itemType(ItemType.PRODUCT_15)
                .build();

        itemsBuilder
                .department(MUSIC)
                .itemNumber(16)
                .itemType(ItemType.PRODUCT_16)
                .build();

        itemsBuilder
                .department(JEWELRY_AND_WATCHES)
                .itemNumber(17)
                .itemType(ItemType.PRODUCT_17)
                .build();

        itemsBuilder
                .department(INSTRUMENTS)
                .itemNumber(18)
                .itemType(ItemType.PRODUCT_18)
                .build();

        itemsBuilder
                .department(GADGETS)
                .itemNumber(19)
                .itemType(ItemType.PRODUCT_19)
                .build();
        itemsBuilder
                .department(HEALTH)
                .itemNumber(20)
                .itemType(ItemType.PRODUCT_20)
                .build();
        itemsBuilder
                .department(BOOKS_AND_COMICS)
                .itemNumber(21)
                .itemType(ItemType.PRODUCT_21)
                .build();

        itemsBuilder
                .department(CHILD)
                .itemNumber(22)
                .itemType(ItemType.PRODUCT_22)
                .build();

        itemsBuilder
                .department(HOUSE_AND_GARDEN)
                .itemNumber(23)
                .itemType(ItemType.PRODUCT_23)
                .build();

        itemsBuilder
                .department(HEALTH)
                .itemNumber(24)
                .itemType(ItemType.PRODUCT_24)
                .build();

        itemsBuilder
                .department(COLLECTIONS)
                .itemNumber(25)
                .itemType(ItemType.PRODUCT_25)
                .build();

        itemsBuilder
                .department(MOTORIZATION)
                .itemNumber(26)
                .itemType(ItemType.PRODUCT_26)
                .build();

        itemsBuilder
                .department(TELEPHONES_AND_ACCESSORIES)
                .itemNumber(27)
                .itemType(ItemType.PRODUCT_27)
                .build();

        itemsBuilder
                .department(CLOTHING_SHOES_ACCESSORIES)
                .itemNumber(28)
                .itemType(ItemType.PRODUCT_28)
                .build();

        itemsBuilder
                .department(SPORTS_AND_TOURISM)
                .itemNumber(29)
                .itemType(ItemType.PRODUCT_29)
                .build();

        itemsBuilder
                .department(BEAUTY)
                .itemNumber(30)
                .itemType(ItemType.PRODUCT_30)
                .build();

        itemsBuilder
                .department(SUPERMARKET)
                .itemNumber(31)
                .itemType(ItemType.PRODUCT_31)
                .build();

        itemsBuilder
                .department(COMPUTERS)
                .itemNumber(32)
                .itemType(ItemType.PRODUCT_32)
                .build();

        itemsBuilder
                .department(RTV_AND_HOUSEHOLD_APPLIANCES)
                .itemNumber(33)
                .itemType(ItemType.PRODUCT_33)
                .build();

        itemsBuilder
                .department(INDUSTRY)
                .itemNumber(34)
                .itemType(ItemType.PRODUCT_34)
                .build();

        itemsBuilder
                .department(MOVIES)
                .itemNumber(35)
                .itemType(ItemType.PRODUCT_35)
                .build();

        itemsBuilder
                .department(MUSIC)
                .itemNumber(36)
                .itemType(ItemType.PRODUCT_36)
                .build();

        itemsBuilder
                .department(JEWELRY_AND_WATCHES)
                .itemNumber(37)
                .itemType(ItemType.PRODUCT_37)
                .build();

        itemsBuilder
                .department(INSTRUMENTS)
                .itemNumber(38)
                .itemType(ItemType.PRODUCT_38)
                .build();

        itemsBuilder
                .department(GADGETS)
                .itemNumber(39)
                .itemType(ItemType.PRODUCT_39)
                .build();
        itemsBuilder
                .department(HEALTH)
                .itemNumber(40)
                .itemType(ItemType.PRODUCT_40)
                .build();
        itemsBuilder
                .department(BOOKS_AND_COMICS)
                .itemNumber(41)
                .itemType(ItemType.PRODUCT_41)
                .build();

        itemsBuilder
                .department(CHILD)
                .itemNumber(42)
                .itemType(ItemType.PRODUCT_42)
                .build();

        itemsBuilder
                .department(HOUSE_AND_GARDEN)
                .itemNumber(43)
                .itemType(ItemType.PRODUCT_43)
                .build();

        itemsBuilder
                .department(HEALTH)
                .itemNumber(44)
                .itemType(ItemType.PRODUCT_44)
                .build();

        itemsBuilder
                .department(COLLECTIONS)
                .itemNumber(45)
                .itemType(ItemType.PRODUCT_45)
                .build();

        itemsBuilder
                .department(MOTORIZATION)
                .itemNumber(46)
                .itemType(ItemType.PRODUCT_46)
                .build();

        itemsBuilder
                .department(TELEPHONES_AND_ACCESSORIES)
                .itemNumber(47)
                .itemType(ItemType.PRODUCT_47)
                .build();

        itemsBuilder
                .department(CLOTHING_SHOES_ACCESSORIES)
                .itemNumber(48)
                .itemType(ItemType.PRODUCT_48)
                .build();

        itemsBuilder
                .department(SPORTS_AND_TOURISM)
                .itemNumber(49)
                .itemType(ItemType.PRODUCT_49)
                .build();

        itemsBuilder
                .department(BEAUTY)
                .itemNumber(50)
                .itemType(ItemType.PRODUCT_50)
                .build();

    }
}
