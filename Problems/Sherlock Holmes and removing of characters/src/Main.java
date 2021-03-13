import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

class Main {

    public static void addToMap(Map<String, Integer> map, String key) {
        String lowercaseKey = key.toLowerCase();
        if (map.containsKey(lowercaseKey)) {
            map.put(lowercaseKey, map.get(key) + 1);
            return;
        }

        map.put(lowercaseKey, 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr1 = scanner.nextLine().split("");
        String[] arr2 = scanner.nextLine().split("");

        Map<String, Integer> map = new HashMap<>();

        for (String str : arr1) {
            addToMap(map, str);
        }

        int removed = 0;
        for (String str : arr2) {
            String lowercaseStr = str.toLowerCase();
            if (map.containsKey(lowercaseStr)) {
                int amount = map.get(lowercaseStr);
                if (amount == 1) {
                    map.remove(lowercaseStr);
                } else {
                    map.put(lowercaseStr, map.get(lowercaseStr) - 1);
                }
            } else {
                removed += 1;
            }
        }

        for (Integer i : map.values()) {
            removed += i;
        }

        System.out.println(removed);
    }
}