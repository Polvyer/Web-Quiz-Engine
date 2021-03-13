import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        String longestString = null;
        int length = 0;

        for (String elem : list) {
            if (elem.length() > length) {
                longestString = elem;
                length = elem.length();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, longestString);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}