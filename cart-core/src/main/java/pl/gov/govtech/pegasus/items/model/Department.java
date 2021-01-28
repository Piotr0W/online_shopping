package pl.gov.govtech.pegasus.items.model;

import validator.Validator;

public enum Department {

    BOOKS_AND_COMICS("Bc"),

    CHILD("Ch"),

    HOUSE_AND_GARDEN("Hg"),

    HEALTH("He"),

    COLLECTIONS("Co"),

    MOTORIZATION("Mo"),

    TELEPHONES_AND_ACCESSORIES("Ta"),

    CLOTHING_SHOES_ACCESSORIES("Csa"),

    SPORTS_AND_TOURISM("St"),

    BEAUTY("Be"),

    SUPERMARKET("Su"),

    COMPUTERS("Com"),

    RTV_AND_HOUSEHOLD_APPLIANCES("Rtv"),

    INDUSTRY("In"),

    MOVIES("Mov"),

    MUSIC("Mu"),

    JEWELRY_AND_WATCHES("Jw"),

    INSTRUMENTS("Ins"),

    GADGETS("Ga");

    // also could add subcategory

    private final String abbreviation;

    Department(String abbreviation) {
        this.abbreviation = Validator.requireNonEmpty(abbreviation, "abbreviation");
    }

    public static Department fromString(String text) {
        for (Department department : Department.values()) {
            if (department.abbreviation.equalsIgnoreCase(text)) {
                return department;
            }
        }
        throw new IllegalArgumentException("Unknown department: " + text);
    }

}
