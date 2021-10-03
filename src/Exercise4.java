import textio.TextIO;

public class Exercise4 {

    public static void main(String[] args) {
        while (true) {
            Expr expression;
            try {
                System.out.print("Enter a mathematical expression to find x using +, -, *, /, ^: ");
                String userInput = TextIO.getln();
                if (userInput.length() == 0) {
                    break;
                }
                expression = new Expr(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                continue;
            }

            while (true) {
                double number;
                System.out.print("Enter the value for x: ");
                String userInput = TextIO.getln();
                if (userInput.length() == 0) {
                    break;
                }

                number = Double.parseDouble(userInput);

                if (Double.isNaN(expression.value(number))) {
                    System.out.println("The answer is undefined.");
                } else {
                    System.out.println("When x is " + number + ": " + expression + " = " + expression.value(number));
                }
            }
        }
    }

}
