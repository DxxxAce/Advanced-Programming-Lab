import java.io.IOException;

public abstract class Command {

    public abstract void run() throws InvalidCatalogException, IOException;
}
