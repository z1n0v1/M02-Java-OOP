public class MyListImpl extends Collection implements MyList {
    private int used;
    public MyListImpl() {
        super();
        used = 0;
    }


    @Override
    public String remove() {
        used--;
        return items.remove(0);
    }

    @Override
    public int add(String item) {
        items.add(0, item);
        used++;
        return 0;
    }

    @Override
    public int getUsed() {
        return used;
    }
}
