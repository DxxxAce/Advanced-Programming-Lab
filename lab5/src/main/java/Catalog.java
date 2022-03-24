import java.util.List;
import java.util.ArrayList;

public class Catalog implements Serializable {

    private String name;
    private List<Item> items;

    public Catalog(String name) {

        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(Item item) {

        items.add(item);
    }

    public Item findById(String id) {

        return items.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
