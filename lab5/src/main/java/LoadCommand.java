import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);

        return catalog;
    }
}
