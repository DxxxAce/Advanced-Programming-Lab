public class ListCommand extends Command {

    public static void list(Catalog catalog) {

        System.out.println(catalog.toString());
    }
}
