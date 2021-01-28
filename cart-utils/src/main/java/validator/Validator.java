package validator;

public class Validator {

    private Validator() {
    }

    public static String requireNonEmpty(String string, String name) {
        if (string == null || string.isEmpty()) throw new IllegalArgumentException(name + " can't be empty.");
        return string;
    }

    public static <T> T requireNonNull(T object, String name) {
        if (object == null) throw new IllegalArgumentException(name + " can't be null");
        return object;
    }

    public static int requireNonNegative(int number, String name) {
        if (number < 0) throw new IllegalArgumentException(name + " can't be negative");
        return number;
    }

    public static long requireNonNegative(long number, String name) {
        if (number < 0) throw new IllegalArgumentException(name + " can't be negative");
        return number;
    }

    public static long requirePositive(long number, String name) {
        if (number < 1) throw new IllegalArgumentException(name + " must be positive");
        return number;
    }

    public static String peselValidation(String pesel) {
        pesel = requireNonEmpty(pesel, "pesel");
        int peselSize = pesel.length(), control = 0, csum = Integer.parseInt(pesel.substring(peselSize - 1));
        if (peselSize == 11) {
            int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
            int j = 0, sum = 0;
            for (int i = 0; i < peselSize - 1; i++) {
                char c = pesel.charAt(i);
                j = Integer.parseInt(String.valueOf(c));
                sum += j * weights[i];
            }
            control = 10 - (sum % 10);
            if (control == 10) control = 0;
        }
        if (peselSize != 11 || control != csum) throw new IllegalArgumentException(pesel + " not correct!");
        return pesel;
    }
}
