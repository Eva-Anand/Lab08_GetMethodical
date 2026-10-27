import java.util.Scanner;

public class SafeInput {


    /**
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;


    }

    public static int getInt(Scanner pipe, String prompt) {
        int value;
        String trash;

        while (true) {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // Clear the leftover newline.
                return value;
            } else {
                trash = pipe.nextLine();
                System.out.println(
                        "Invalid input: " + trash + ". Enter an integer.");
            }
        }
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double value;
        String trash;

        while (true) {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // Clear the leftover newline.
                return value;
            } else {
                trash = pipe.nextLine();
                System.out.println(
                        "Invalid input: " + trash + ". Enter a number.");
            }
        }
    }
    public static int getRangedInt(
            Scanner pipe, String prompt, int low, int high) {

        while (true) {
            int value = getInt(
                    pipe, prompt + " [" + low + " - " + high + "]");

            if (value >= low && value <= high) {
                return value;
            }

            System.out.println(
                    "Enter an integer from " + low + " through " + high + ".");
        }
    }
    public static double getRangedDouble(
            Scanner pipe, String prompt, double low, double high) {

        while (true) {
            double value = getDouble(
                    pipe, prompt + " [" + low + " - " + high + "]");

            if (value >= low && value <= high) {
                return value;
            }

            System.out.println(
                    "Enter a number from " + low + " through " + high + ".");
        }
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        while (true) {
            System.out.print(prompt + " [Y/N]: ");
            String response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                return true;
            }

            if (response.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }
    public static void prettyHeader(String msg) {
        if (msg.length() > 54) {
            throw new IllegalArgumentException(
                    "Message must be 54 characters or fewer.");
        }

        int leftPadding = (54 - msg.length()) / 2;
        int rightPadding = 54 - msg.length() - leftPadding;

        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");

        for (int i = 0; i < leftPadding; i++) {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int i = 0; i < rightPadding; i++) {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int i = 0; i < 60; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

}





