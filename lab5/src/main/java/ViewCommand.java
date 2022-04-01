import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command {

    Item item;
    String path;

    public ViewCommand(Item item, String path) {

        this.item = item;
        this.path = path;
    }

    public void setItem(Item item) {

        this.item = item;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public Item getItem() {

        return item;
    }

    public String getPath() {

        return path;
    }

    public void run()
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), item);
        Desktop.getDesktop().open(new File(path));
    }

}
