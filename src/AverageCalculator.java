import java.util.Scanner;

public class AverageCalculator {

    public static double getAverage() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];

        System.out.println("Enter 3 numbers:");
        for (int i = 0; i < 3; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return sum / 3.0;
    }

    public static void main(String[] args) {
        double average = getAverage();
        System.out.println("The average is: " + average);
    }
}

