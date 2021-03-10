import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.valueOf(scanner.nextLine());
        int b = Integer.valueOf(scanner.nextLine());

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum+=i;
        }

        System.out.println(sum);
    }
}