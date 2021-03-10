import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i1 = scanner.nextInt();
        int i2 = scanner.nextInt();

        for (int i = i1; i <= i2; i++) {
            boolean divBy5 = (i % 5 == 0);
            boolean divBy3 = (i % 3 == 0);
            if (divBy5 && divBy3) {
                System.out.println("FizzBuzz");
            } else if (divBy5) {
                System.out.println("Buzz");
            } else if (divBy3) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }
}