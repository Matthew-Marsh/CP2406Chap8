import textio.TextIO;

public class Exercise1 {
    static public double root(double A, double B, double C)
            throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

    public static void main(String[] args) {

        double valueA;
        double valueB;
        double valueC;
        while (true) {
            System.out.print("Enter value of A: ");
            valueA = TextIO.getlnDouble();
            System.out.print("Enter value of B: ");
            valueB = TextIO.getlnDouble();
            System.out.print("Enter value of C: ");
            valueC = TextIO.getlnDouble();
            try {
                double answer = root(valueA, valueB, valueC);
                System.out.printf("The root is: %.4f%n", answer);
            } catch (IllegalArgumentException e) {
                System.out.print("No solution: ");
                System.out.println(e.getMessage());
            }
            System.out.print("Do you want to enter another equation? ");
            if (!TextIO.getlnBoolean()) {
                break;
            }
        }
        System.out.println("Thanks for using the program. Goodbye!");
    }
}
