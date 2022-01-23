public class AddCollection extends Collection implements Addable {
    public AddCollection() {
        super();
    }

    public int add(String item) {
        items.add(item);
        return items.size() - 1;
    }
}
