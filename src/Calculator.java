import java.util.ArrayList;
import java.util.Scanner;

class Calculator {
    private ArrayList<String> operations;

    public Calculator() {
        this.operations = new ArrayList<>();
    }

    public double add(double a, double b) {
        double result = a + b;
        operations.add(a + " + " + b + " = " + result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        operations.add(a + " - " + b + " = " + result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        operations.add(a + " * " + b + " = " + result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            operations.add(a + " / " + b + " = Error (division by zero)");
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = a / b;
        operations.add(a + " / " + b + " = " + result);
        return result;
    }

    public void displayOperations() {
        System.out.println("Operations performed:");
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
}

