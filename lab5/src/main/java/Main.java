import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InvalidCatalogException, IOException {

        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {

        Catalog catalog = new Catalog("MyRefs");

        var book = new Item("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps",
                "1967", "Donald E. Knuth", "book");
        var article = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                "2021", "James Gosling & others", "article");

        AddCommand.add(catalog, book);
        AddCommand.add(catalog, article);

       SaveCommand.save(catalog, "catalogs\\catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException {

        Catalog catalog = LoadCommand.load("catalogs\\catalog.json");
        ViewCommand.view(catalog.findById("java17"), "catalogs\\catalog.json");
    }
}
