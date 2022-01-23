import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();
        String[] strings = reader.readLine().split("\\s+");
        int numRemoves = Integer.parseInt(reader.readLine());
        for (String s : strings) {
            System.out.printf("%d ", addCollection.add(s));
        }
        System.out.println();
        for (String s : strings) {
            System.out.printf("%d ", addRemoveCollection.add(s));
        }
        System.out.println();
        for (String s : strings) {
            System.out.printf("%d ", myList.add(s));
        }
        System.out.println();

        for (int i = 0; i < numRemoves; i++) {
            System.out.printf("%s ", addRemoveCollection.remove());
        }
        System.out.println();

        for (int i = 0; i < numRemoves; i++) {
            System.out.printf("%s ", myList.remove());
        }
        System.out.println();
    }
}
