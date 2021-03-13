import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        // write your code here
        if (Objects.equals(set1, set2)) {
            return false;
        }

        Iterator<T> iterator = set2.iterator();
        while (iterator.hasNext()) {
            set1.remove(iterator.next());
        }

        if (set1.isEmpty()) {
            return true;
        }

        return false;
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set1 = readStringSet(scanner);
        Set<String> set2 = readStringSet(scanner);

        System.out.println(isStrictSuperset(set1, set2));
    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}