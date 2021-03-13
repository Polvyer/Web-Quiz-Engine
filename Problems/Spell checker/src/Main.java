import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfKnownWords = Integer.valueOf(scanner.nextLine());
        Set<String> knownWords = new HashSet<>();
        for (int i = 0; i < numOfKnownWords; i++) {
            knownWords.add(scanner.nextLine().toLowerCase());
        }
        int linesOfText = Integer.valueOf(scanner.nextLine());
        Set<String> erroneousWords = new HashSet<>();
        for (int i = 0; i < linesOfText; i++) {
            String[] arr = scanner.nextLine().split(" ");
            for (String str : arr) {
                if (!knownWords.contains(str.toLowerCase())) {
                    erroneousWords.add(str);
                }
            }
        }
        for (String elem : erroneousWords) {
            System.out.println(elem);
        }
    }
}