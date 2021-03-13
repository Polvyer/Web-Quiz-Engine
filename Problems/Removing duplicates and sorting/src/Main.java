import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.valueOf(scanner.nextLine());

        SortedSet<String> set = new TreeSet<>();
        while (scanner.hasNext()) {
            set.add(scanner.next());
        }

        for (String str : set) {
            System.out.println(str);
        }
    }
}