import java.util.Scanner;

public class DevTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = SafeInput.getRangedInt(
                in, "Enter an integer", 1, 10);

        System.out.println("You entered: " + number);
    }
}