import RomanToInteger.Convertor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Roman number: ");
        String input = scanner.nextLine();

        try {
            System.out.println("The number is: " + Convertor.romanToInteger(input));
        } catch (IllegalArgumentException e){
            System.out.printf(e.getMessage());
        }
    }
}
