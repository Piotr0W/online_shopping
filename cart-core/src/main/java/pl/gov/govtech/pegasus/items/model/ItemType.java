package pl.gov.govtech.pegasus.items.model;

import static validator.Validator.requireNonNegative;
import static validator.Validator.requireNonNull;

public enum ItemType {

    PRODUCT_1(434, "Portable Blender"),
    PRODUCT_2(516, "Spider Nail Gel"),
    PRODUCT_3(37, "Wireless Phone Chargers"),
    PRODUCT_4(601, "Face Shield"),
    PRODUCT_5(654, "Phone Lenses"),
    PRODUCT_6(64, "Inflatable Pet Collars"),
    PRODUCT_7(206, "Eyeshadow Stamp"),
    PRODUCT_8(767, "Strapless Backless Bra"),
    PRODUCT_9(898, "Child Wrist Leash"),
    PRODUCT_10(425, "Front Facing Baby Carrier"),
    PRODUCT_11(450, "Car Phone Holder"),
    PRODUCT_12(600, "Home Security IP Camera"),
    PRODUCT_13(335, "Wifi Repeater"),
    PRODUCT_14(831, "Drone Camera"),
    PRODUCT_15(552, "Posture Corrector"),
    PRODUCT_16(827, "Electric Soldering Iron Gun"),
    PRODUCT_17(170, "Pump Wedge Locksmith"),
    PRODUCT_18(401, "Bohemian Earrings"),
    PRODUCT_19(775, "Manicure Milling Drill Bit"),
    PRODUCT_20(345, "Flexible Garden Hose"),
    PRODUCT_21(341, "One Piece Swimsuit"),
    PRODUCT_22(614, "Fly Fishing Quick Knot Tool"),
    PRODUCT_23(686, "Breathable Mesh Running Shoes"),
    PRODUCT_24(58, "Waterproof Eyebrow Liner"),
    PRODUCT_25(860, "Non-contact Infrared Thermometer"),
    PRODUCT_26(587, "Cat Massage Comb"),
    PRODUCT_27(410, "Portable Electric Ionic Hairbrush – Summer Product"),
    PRODUCT_28(318, "PVC Inflatable Beer Pong Ball Table – Summer Product"),
    PRODUCT_29(106, "Home Ice Cream Makers – Summer Product"),
    PRODUCT_30(904, "Beach Towels – Summer Product"),
    PRODUCT_31(174, "Baby Kids Water Play Mat – Summer Product"),
    PRODUCT_32(631, "Pocket Scarves – Winter Product"),
    PRODUCT_33(540, "Winter Coats – Winter Product"),
    PRODUCT_34(930, "Shoe Dryer – Winter Product"),
    PRODUCT_35(138, "Touchscreen Gloves – Winter Product"),
    PRODUCT_36(533, "Waterproof Pants – Winter Product"),
    PRODUCT_37(882, "Bear Claws – Spring Products"),
    PRODUCT_38(911, "Hiking Backpacks – Spring Products"),
    PRODUCT_39(434, "Minimalist Wallets – Spring Products"),
    PRODUCT_40(577, "Waterproof Shoe Cover – Autumn (Fall) Product"),
    PRODUCT_41(165, "Hooded Raincoats – Autumn (Fall) Product"),
    PRODUCT_42(175, "Cable Chompers – Autumn (Fall) Product"),
    PRODUCT_43(829, "Plush Blankets – Autumn (Fall) Product"),
    PRODUCT_44(363, "Portable Car Vacuum"),
    PRODUCT_45(966, "Baby Swings"),
    PRODUCT_46(947, "Match Tea"),
    PRODUCT_47(631, "Eyebrow Razor"),
    PRODUCT_48(394, "Seat Cushions"),
    PRODUCT_49(997, "Phone Tripod"),
    PRODUCT_50(107, "Portable Solar Panels");

    private final int quantity;

    private final String description;

    ItemType(int quantity, String description) {
        this.quantity = requireNonNegative(quantity, "quantity");
        this.description = requireNonNull(description, "description");
    }

    public static ItemType fromString(String text) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.description.equalsIgnoreCase(text)) {
                return itemType;
            }
        }
        throw new IllegalArgumentException("Unknown item: " + text);
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}
