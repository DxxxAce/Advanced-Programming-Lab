public class AddCommand extends Command {

    Catalog catalog;
    Item item;

    public AddCommand(Catalog catalog, Item item) {

        this.catalog = catalog;
        this.item = item;
    }

    public void setCatalog(Catalog catalog) {

        this.catalog = catalog;
    }

    public void setItem(Item item) {

        this.item = item;
    }

    public Catalog getCatalog() {

        return catalog;
    }

    public Item getItem() {

        return item;
    }

    public void run() {

        catalog.add(item);
    }


}
