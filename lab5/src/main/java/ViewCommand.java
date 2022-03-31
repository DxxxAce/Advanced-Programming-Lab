import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand extends Command {

    public static void view(Item item, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), item);
        Desktop.getDesktop().open(new File(path));
    }

}
