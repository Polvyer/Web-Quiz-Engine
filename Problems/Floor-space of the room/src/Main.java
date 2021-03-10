import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();

        double a;
        double b;
        double c;
        double s;
        switch(shape) {
            case "triangle":
                a = Double.valueOf(scanner.nextLine());
                b = Double.valueOf(scanner.nextLine());
                c = Double.valueOf(scanner.nextLine());
                s = (a + b + c) / 2;
                System.out.println(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
                break;
            case "rectangle":
                a = Double.valueOf(scanner.nextLine());
                b = Double.valueOf(scanner.nextLine());
                System.out.println(a * b);
                break;
            case "circle":
                a = Double.valueOf(scanner.nextLine());
                System.out.println(3.14 * a * a);
                break;
        }
    }
}