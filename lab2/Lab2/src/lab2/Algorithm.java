package lab2;

/**
 * The Algorithm abstract class, used to to create an object of type Algorithm.
 * @author alinh
 *
 */
public abstract class Algorithm {

	protected Problem pb;
	
	/**
	 * Abstract function, implemented in child classes. 
	 * @param pb The instance of the problem.
	 * @return A solution for the given instance of the problem.
	 */
	public abstract Solution solve();
}
