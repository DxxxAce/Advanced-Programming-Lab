/**
 * Intersection class.
 * @author alinh
 * 24/03/2022
 */
public class Intersection {

    private String name;

    /**
     * Class constructor.
     * @param name Intersection name.
     */
    public Intersection(String name) {

        this.name = name;
    }

    /**
     * Name setter.
     * @param name Intersection name.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Name getter.
     * @return Intersection name.
     */
    public String getName() {

        return name;
    }

    /**
     * Override of the toString() method.
     * @return Intersection name.
     */
    @Override
    public String toString() {

        return name;
    }
}
