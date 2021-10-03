import textio.TextIO;

import java.math.BigInteger;

public class Exercise2 {

    private static void printNumberSequence(BigInteger number) {
        int count;
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");

        System.out.println("The 3N+1 sequence starting with " + number + " is:");

        System.out.println(number.toString());
        count = 1;

        while (!number.equals(one)) {
            if (!number.testBit(0)) {
                number = number.divide(two);
            } else {
                number = number.multiply(three);
                number = number.add(one);
            }
            System.out.println(number);
            count++;
        }
        System.out.println("There were " + count + " terms in the sequence.");

    }

    public static void main(String[] args) {
        String userInput;
        while (true) {
            System.out.print("Enter an integer that is greater than zero: ");
            userInput = TextIO.getln();
            if (userInput.length() == 0) {
                break;
            }
            try {
                BigInteger number = new BigInteger(userInput);
                if (number.signum() == 1) {
                    printNumberSequence(number);
                } else {
                    System.out.println("Number must be an integer greater than zero.");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid number: " + e.getMessage());
            }

        }
        System.out.println("Thanks for using the program.");
    }
}
