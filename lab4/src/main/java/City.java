import java.util.*;

/**
 * City class.
 * @author alinh
 * 24/03/2022
 */
public class City {

    private String name;
    private Set<Intersection> intersections;
    private LinkedList<Street> streets;
    private Map<Intersection, List<Street>> cityMap;

    /**
     * Class constructor.
     * @param name City name.
     * @param intersections City intersections.
     * @param streets City streets.
     */
    public City(String name, Intersection[] intersections, Street[] streets) {

        this.name = name;

        this.intersections = new HashSet<>();
        this.intersections.addAll( Arrays.asList(intersections));

        this.streets = new LinkedList<>();
        this.streets.addAll( Arrays.asList(streets) );

        this.cityMap = new HashMap<>();

        for (Intersection intersection : intersections) {

            List<Street> streetList = new ArrayList();

            for (Street street : streets) {

                if (street.getIntersection1() == intersection || street.getIntersection2() == intersection) {

                    streetList.add(street);
                }
            }

            cityMap.put(intersection, streetList);
        }
    }

    /**
     * Name setter.
     * @param name City name.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Intersections setter.
     * @param intersections City intersections.
     */
    public void setIntersections(Set<Intersection> intersections) {

        this.intersections = intersections;
    }

    /**
     * Streets setter.
     * @param streets City streets.
     */
    public void setStreets(LinkedList<Street> streets) {

        this.streets = streets;
    }

    /**
     * Name getter.
     * @return City name.
     */
    public String getName() {

        return name;
    }

    /**
     * Intersections getter.
     * @return City intersections.
     */
    public Set<Intersection> getIntersections() {

        return intersections;
    }

    /**
     * Streets getter.
     * @return City streets.
     */
    public LinkedList<Street> getStreets() {

        return streets;
    }

    /**
     * Method to sort streets by length.
     */
    public void sortStreets() {

        Collections.sort(streets, Comparator.comparing(Street::getLength));
    }

    /**
     * Method to print all streets longer than a certain length which join at least 3 other streets.
     * @param length Length value to compare to.
     */
    public void printStreetsLongerThan(int length) {

        streets.stream()
                .filter(v -> v.getLength() > length && cityMap.get(v.getIntersection1()).size() + cityMap.get(v.getIntersection2()).size() > 4)
                .forEach(System.out::println);
    }

    /**
     * Override of the toString() method.
     * @return City data.
     */
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", intersections=" + intersections +
                ", streets=" + streets +
                ", cityMap=" + cityMap +
                '}';
    }
}
