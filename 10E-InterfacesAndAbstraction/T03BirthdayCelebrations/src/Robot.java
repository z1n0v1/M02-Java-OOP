public class Robot implements Identifiable{
    private String model, id;

    public Robot(String id, String model) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }
}
