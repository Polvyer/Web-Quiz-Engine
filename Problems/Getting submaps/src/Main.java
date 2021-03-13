import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        int start = Integer.valueOf(firstLine[0]);
        int end = Integer.valueOf(firstLine[1]);
        scanner.nextLine();
        SortedMap<Integer, String> map = new TreeMap<>();
        while (scanner.hasNext()) {
            String[] arr = scanner.nextLine().split(" ");
            map.put(Integer.valueOf(arr[0]), arr[1]);
        }

        SortedMap<Integer, String> answer = map.subMap(start, end + 1);

        for (var e : answer.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}