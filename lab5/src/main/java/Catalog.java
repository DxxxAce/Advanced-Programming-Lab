import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Catalog implements Serializable {

    private String name;
    private List<Item> items;

    public Catalog() {}

    public Catalog(String name) {

        this.name = name;
        this.items = new ArrayList<>();
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setItems(List<Item> items) {

        this.items = items;
    }

    public String getName() {

        return name;
    }

    public List<Item> getItems() {

        return items;
    }

    public void add(Item item) {

        items.add(item);
    }

    public void updateWith(Catalog catalog) {

        this.name = catalog.name;
        this.items = catalog.items;
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
