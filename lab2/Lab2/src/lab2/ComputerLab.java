package lab2;

/**
 * The ComputerLab class, derived from the Room superclass.
 * @author alinh
 *
 */
public class ComputerLab extends Room {
	
	private OperatingSystem system;
	
	/**
	 * The constructor that initializes all of the ComputerLab object's parameters.
	 * @param name The name of the computer hall.
	 * @param cap The maximum student capacity of the computer lab.
	 * @param system The operating system of the computers in the lab.
	 */
	public ComputerLab(String name, int cap, OperatingSystem system) {
		
		this.name = name;
		this.cap = cap;
		this.system = system;
	}
	
	/**
	 * The operating system setter function.
	 * @param system The operating system of the computers in the lab.
	 */
	public void setSystem(OperatingSystem system) {
	
		this.system = system;
	}
	
	/**
	 * The operating system getter function.
	 * @return The operating system of the computers in the lab.
	 */
	public OperatingSystem getSystem() {
	
		return this.system;
	}
	
	/**
	 * Override of the toString function.
	 */
	@Override
	public String toString() {
		
		 return name + "(" +
				 "cap=" + cap +
				 ", operating_system=" + system +
				 ")";
	}
}
