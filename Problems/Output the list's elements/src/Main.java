import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        Iterator it = nameList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
