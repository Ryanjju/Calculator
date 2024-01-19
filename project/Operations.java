import java.util.Scanner;

public class Operations {
    // color of text
    public static final String ANSI_RESET = "\u001B[0m"; // Reset color
    public static final String ANSI_RED = "\u001B[31m"; // Red color

    private static float result;

    static Scanner reader = new Scanner(System.in);

    /* Functions without using previouse result */

    public Operations() {
    }

    public static float add() {
        try {
            System.out.print("Number 1: ");
            float add_int = reader.nextFloat();

            System.out.print("\n\nNumber 2: ");
            float add_int2 = reader.nextFloat();

            result = add_int + add_int2;

            System.out.printf("\n\n%.2f + %.2f = %.2f%n", add_int, add_int2, result);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float sub() {
        try {
            System.out.print("Number 1: ");
            float add_int = reader.nextFloat();

            System.out.print("\n\nNumber 2: ");
            float add_int2 = reader.nextFloat();

            result = add_int - add_int2;

            System.out.printf("\n\n%.2f * %.2f = %.2f%n", add_int, add_int2, result);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float mult() {
        try {
            System.out.print("Number 1: ");
            float add_int = reader.nextFloat();

            System.out.print("\n\nNumber 2: ");
            float add_int2 = reader.nextFloat();

            result = add_int * add_int2;

            System.out.printf("\n\n%.2f * %.2f = %.2f%n", add_int, add_int2, result);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float div() {
        try {
            System.out.print("Number 1: ");
            float add_int = reader.nextFloat();

            System.out.print("\n\nNumber 2: ");
            float add_int2 = reader.nextFloat();

            result = add_int / add_int2;

            System.out.printf("\n\n%.2f * %.2f = %.2f%n", add_int, add_int2, result);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }
    /* ----- */

    /* Functions using one previouse result */

    public static float add_r(float result_get) {
        try {
            System.out.print("Number: ");
            float add_int = reader.nextFloat();

            result = result_get + add_int;

            System.out.printf("\n\n%.2f + %.2f = %.2f%n", result_get, add_int, result);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float sub_r(float result_get) {
        try {
            System.out.print("Number: ");
            float add_int = reader.nextFloat();

            result = result_get - add_int;

            System.out.printf("\n\n%.2f - %.2f = %.2f%n", result_get, add_int, result);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float mult_r(float result_get) {
        try {
            System.out.print("Number: ");
            float add_int = reader.nextFloat();

            result = result_get * add_int;

            System.out.printf("\n\n%.2f * %.2f = %.2f%n", result_get, add_int, result);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }

    public static float div_r(float result_get) {
        try {
            System.out.print("Number: ");
            float add_int = reader.nextFloat();

            result = result_get / add_int;

            System.out.printf("\n\n%.2f / %.2f = %.2f%n", result_get, add_int, result);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "This is not a valid input. Please make a valid one!" + ANSI_RESET);
        } finally {
            reader.nextLine(); // clear buffer
        }

        return result;
    }
}
