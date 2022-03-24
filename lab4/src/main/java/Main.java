/**
 * Main class.
 * @author alinh
 *
 */
public class Main {

    /**
     * Main program function.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        City city = new City("Pascani");

        city.sortStreets();

        System.out.println(city.getStreets());
    }
}
