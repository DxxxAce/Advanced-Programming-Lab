import java.util.Map;
import java.util.HashMap;

public class Item implements Serializable {

    private String id;
    private String title;
    private String location;
    private String year;
    private String author;
    private String type;
    private Map<String, Object> tags = new HashMap<>();

    public Item() {}

    public Item(String id, String title, String location, String year, String author) {

        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
    }

    public Item(String id, String title, String location, String year, String author, String type) {

        this.id = id;
        this.title = title;
        this.location = location;
        this.year = year;
        this.author = author;
        this.type = type;
    }

    public void setId(String id) {

        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setLocation(String location) {

        this.location = location;
    }

    public void setYear(String year) {

        this.year = year;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getLocation() {

        return location;
    }

    public String getYear() {

        return year;
    }

    public String getAuthor() {

        return author;
    }

    public String getType() {

        return type;
    }

    public void addTag(String key, Object obj) {

        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
