import java.util.stream.IntStream;
import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.PrimMinimumSpanningTree;

/**
 * Main class.
 * @author alinh
 * 24/03/2022
 */
public class Main {

    /**
     * Main program function.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        Faker faker = new Faker();

        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection(faker.funnyName().name()))
                .toArray(Intersection[]::new);

        Street s0 = new Street(faker.address().streetName(), 2, nodes[0], nodes[1]);
        Street s1 = new Street(faker.address().streetName(), 3, nodes[1], nodes[2]);
        Street s2 = new Street(faker.address().streetName(), 1, nodes[2], nodes[3]);
        Street s3 = new Street(faker.address().streetName(), 1, nodes[3], nodes[6]);
        Street s4 = new Street(faker.address().streetName(), 2, nodes[1], nodes[4]);
        Street s5 = new Street(faker.address().streetName(), 1, nodes[2], nodes[8]);
        Street s6 = new Street(faker.address().streetName(), 2, nodes[2], nodes[6]);
        Street s7 = new Street(faker.address().streetName(), 1, nodes[3], nodes[5]);
        Street s8 = new Street(faker.address().streetName(), 2, nodes[0], nodes[4]);
        Street s9 = new Street(faker.address().streetName(), 2, nodes[4], nodes[5]);
        Street s10 = new Street(faker.address().streetName(), 1, nodes[5], nodes[6]);
        Street s11 = new Street(faker.address().streetName(), 2, nodes[0], nodes[7]);
        Street s12 = new Street(faker.address().streetName(), 3, nodes[7], nodes[8]);
        Street s13 = new Street(faker.address().streetName(), 2, nodes[4], nodes[8]);
        Street s14 = new Street(faker.address().streetName(), 3, nodes[6], nodes[8]);
        Street s15 = new Street(faker.address().streetName(), 1, nodes[4], nodes[7]);

        Street[] edges = {s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15};

        City city = new City("Pascani", nodes, edges);
        city.sortStreets();

        PrimMinimumSpanningTree<Intersection, Street> pb = new PrimMinimumSpanningTree<>();
        System.out.println(pb.getSpanningTree();
    }
}
