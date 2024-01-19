import java.util.Scanner;

class Calc {
    // Colors of Text
    public static final String ANSI_RESET = "\u001B[0m"; // Reset color
    public static final String ANSI_RED = "\u001B[31m"; // Red color
    public static final String ANSI_GREEN = "\u001B[32m"; // Green Color

    public static Scanner reader = new Scanner(System.in);
    static float ans;

    static void quit_code() {
        reader.close();
        System.out.println(ANSI_GREEN + "Program ended with exitcode: 0" + ANSI_RESET);
        System.exit(0);
    }

    public static void main(String[] args) {
        int input = 0;

        // Defining the options
        System.out.println(
                "Please choose one of these options:\n(1) Add\n(2) Subtract\n(3) Multiply\n(4) Divide\n-----\n(9) Quit");
        while (true) {
            try {
                System.out.print("\nInput: ");
                input = reader.nextInt(); // picking an option
            } catch (Exception e) {
                System.out.println(ANSI_RED + e + ANSI_RESET);
            } finally {
                reader.nextLine(); // clear buffer
            }

            switch (input) {
                case 9:
                    quit_code();
                    break;
                case 1:
                    /* Add */
                    if (ans != 0) {
                        System.out.print("Do you want to use the previus result (" + ans
                                + ")? Type 'y' if yes and something else, if not?\nInput: ");
                        String use_ans = reader.nextLine();

                        if (use_ans.equals("y")) {
                            ans = Operations.add_r(ans);
                        } else {
                            ans = Operations.add();
                        }
                    } else {
                        ans = Operations.add();
                    }
                    break;

                case 2:
                    /* Subtract */
                    if (ans != 0) {
                        System.out.println("Do you want to use the previus result (" + ans
                                + ")? Type 'y' if yes and something else, if not?\nInput: ");
                        String use_ans = reader.nextLine();

                        if (use_ans.equals("y")) {
                            ans = Operations.sub_r(ans);
                        } else {
                            ans = Operations.sub();
                        }
                    }
                    ans = Operations.sub();
                    break;

                case 3:
                    /* Multiply */
                    if (ans != 0) {
                        System.out.print("Do you want to use the previus result (" + ans
                                + ")? Type 'y' if yes and something else, if not?\nInput: ");
                        String use_ans = reader.nextLine();

                        if (use_ans.equals("y")) {
                            ans = Operations.mult_r(ans);
                        } else {
                            ans = Operations.mult();
                        }
                    } else {
                        ans = Operations.mult();
                    }
                    break;

                case 4:
                    /* Divide */
                    if (ans != 0) {
                        System.out.print("Do you want to use the previus result (" + ans
                                + ")? Type 'y' if yes and something else, if not?\nInput: ");
                        String use_ans = reader.nextLine();

                        if (use_ans.equals("y")) {
                            ans = Operations.div_r(ans);
                        } else {
                            ans = Operations.div();
                        }
                    } else {
                        ans = Operations.div();
                    }
                    break;
                case 5:
                    /* Show previus result */
                    System.out.println(ans);
                    break;
                default:
                    System.out.println( ANSI_RED + "This is not a valid Input" + ANSI_RESET);
            }
        }
    }
}
