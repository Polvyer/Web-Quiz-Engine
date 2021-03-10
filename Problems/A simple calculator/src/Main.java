import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        long left = Long.valueOf(arr[0]);
        String op = arr[1];
        long right = Long.valueOf(arr[2]);

        switch(op) {
            case "+":
                System.out.println(left + right);
                break;
            case "-":
                System.out.println(left - right);
                break;
            case "*":
                System.out.println(left * right);
                break;
            case "/":
                if (right == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(left / right);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}