import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidCatalogException, IOException {

        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException, InvalidCatalogException {

        Catalog catalog = new Catalog("MyRefs");

        var book = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps",
                "1967", "Donald E. Knuth", "book");
        var article = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                "2021", "James Gosling & others", "article");

        Command add = new AddCommand(catalog, book);
        add.run();

        ((AddCommand)add).setItem(article);
        add.run();

        Command save = new SaveCommand(catalog, "catalogs\\catalog.json");
        save.run();

        Command list = new ListCommand(catalog);
        list.run();
    }

    private void testLoadView() throws InvalidCatalogException, IOException {

        Catalog catalog = new Catalog();

        Command load = new LoadCommand(catalog, "catalogs\\catalog.json");
        load.run();

        Command view = new ViewCommand(catalog.findById("java17"), "catalogs\\catalog.json");
        view.run();

        Command list = new ListCommand(catalog);
        list.run();
    }
}
