public class ShoppingItem {
    private String name;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ShoppingItem{" +
                "name='" + name + '\'' +
                '}';
    }

    private String type;
    private int amount;
    private int volume;
    boolean important;

    public ShoppingItem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public ShoppingItem(String name, String type, int amount, int volume, boolean important) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.volume = volume;
        this.important = important;
    }
    public ShoppingItem(String name, String type, int amount, boolean important) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.important = important;
    }

}
