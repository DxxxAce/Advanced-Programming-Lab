import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {

    Catalog catalog;
    String path;

    public LoadCommand(Catalog catalog, String path) {

        this.catalog = catalog;
        this.path = path;
    }

    public void setCatalog(Catalog catalog) {

        this.catalog = catalog;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public Catalog getCatalog() {

        return catalog;
    }

    public String getPath() {

        return path;
    }

    public void run()
            throws InvalidCatalogException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        catalog.updateWith(objectMapper.readValue(new File(path), Catalog.class));
    }
}
