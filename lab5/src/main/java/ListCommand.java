public class ListCommand extends Command {

    Catalog catalog;

    public ListCommand(Catalog catalog) {

        this.catalog = catalog;
    }

    public void setCatalog(Catalog catalog) {

        this.catalog = catalog;
    }

    public Catalog getCatalog() {

        return catalog;
    }

    public void run() {

        System.out.println(catalog.toString());
    }
}
