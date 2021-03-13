import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] newspaper = scanner.nextLine().split(" ");
        String[] note = scanner.nextLine().split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String str : note) {
            String word = str;
            if (map.containsKey(word)) {
                Integer count = map.get(word);
                map.put(word, count + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (String str : newspaper) {
            String word = str;
            if (!map.containsKey(word)) {
                continue;
            }

            Integer count = map.get(word);
            if (count == 1) {
                map.remove(word);
            } else {
                map.put(word, count - 1);
            }
        }

        if (map.isEmpty()) {
            System.out.println("You get money");
        } else {
            System.out.println("You are busted");
        }
    }
}