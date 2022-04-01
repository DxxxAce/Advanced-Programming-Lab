import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {

    Catalog catalog;
    String path;

    public SaveCommand(Catalog catalog, String path) {

        this.catalog = catalog;
        this.path = path;
    }

    public void run()
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
}
