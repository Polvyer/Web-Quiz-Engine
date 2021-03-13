import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        String[] arr = str.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String elem : arr) {
            list.add(Integer.valueOf(elem));
        }
        return new TreeSet<>(list);
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()) {
            int num = iterator.next();
            if (num > 10) {
                iterator.remove();
            }
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}