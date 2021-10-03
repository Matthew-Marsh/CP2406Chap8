import textio.TextIO;

public class Exercise3 {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter either roman numerals or arabic numbers above 0 and below 3999: ");
            String userInput = TextIO.getln();
            int number = 0;

            if (userInput.length() == 0) {
                break;
            }

            if (Character.isDigit(userInput.charAt(0))) {
                number = Integer.parseInt(userInput);
            }

            try {
                RomanNumeral convertedNumber;
                if (number != 0) {
                    System.out.println(number);
                    convertedNumber = new RomanNumeral(number);
                    System.out.println(convertedNumber.toInt() + " is " + convertedNumber + " in roman numerals.");
                } else {
                    System.out.println(userInput);
                    convertedNumber = new RomanNumeral(userInput);
                    System.out.println(convertedNumber + " is " + convertedNumber.toInt() + " in Arabic numbers.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        System.out.println("Thanks for using the program.");
    }
}
