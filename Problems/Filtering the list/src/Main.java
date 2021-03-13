import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        Deque<Integer> lst = new LinkedList<>();

        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            index++;

            if (index % 2 == 0) {
                continue;
            }

            lst.addFirst(i);
        }

        for (int elem : lst) {
            System.out.print(elem + " ");
        }
    }
}