public class RomanNumeral {
    private static final int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int num;

    public String toString() {
        String romanNumber = "";
        int number = num;

        for (int i = 0; i < numbers.length; i++ ) {
            while (number >= numbers[i]) {
                romanNumber += letters[i];
                number -= numbers[i];
            }
        }
        return romanNumber;
    }

    public int toInt() {
        return num;
    }

    private int convertLetterToNumber(char letter) {
        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   throw new NumberFormatException(letter + " is not in the list of Roman numerals");
        }
    }

    public RomanNumeral(int arabicNumber) {
        if (arabicNumber < 1)
            throw new NumberFormatException("Number must be a positive number.");
        if (arabicNumber > 3999)
            throw new NumberFormatException("Number must be 3999 or less..");
        num = arabicNumber;
    }

    public RomanNumeral(String romanNumber) {
        if (romanNumber.length() == 0) {
            throw new NumberFormatException("Can't convert an empty string.");
        }
        romanNumber = romanNumber.toUpperCase();
        int i = 0;
        int arabicNumber = 0;

        while (i < romanNumber.length()) {
            char letter = romanNumber.charAt(i);
            int number = convertLetterToNumber(letter);
            i++;

            if (i == romanNumber.length()) {
                arabicNumber += number;
            } else {
                int nextNumber = convertLetterToNumber(romanNumber.charAt(i));
                if (nextNumber > number) {
                    arabicNumber += (nextNumber - number);
                    i++;
                } else {
                    arabicNumber += number;
                }
            }
        }

        num = arabicNumber;
    }
}
