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

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            System.out.println("Enter operation: add, subtract, multiply, divide, or quit:");
            String operation = scanner.next();

            if (operation.equals("quit")) {
                quit = true;
                calculator.displayOperations();
            } else {
                System.out.println("Enter two numbers:");
                double num1 = scanner.nextDouble();
                double num2 = scanner.nextDouble();

                switch (operation) {
                    case "add":
                        calculator.add(num1, num2);
                        break;
                    case "subtract":
                        calculator.subtract(num1, num2);
                        break;
                    case "multiply":
                        calculator.multiply(num1, num2);
                        break;
                    case "divide":
                        try {
                            calculator.divide(num1, num2);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid operation");
                }
            }
        }
    }
}

