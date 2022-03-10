package lab2;

public class ComputerLab extends Room {

	public ComputerLab(String name, int cap, OperatingSystem system) {
		
		this.name = name;
		this.cap = cap;
		this.system = system;
	}
	
	private OperatingSystem system;
	
	public void setSystem(OperatingSystem system) {
	
		this.system = system;
	}
	
	public OperatingSystem getSystem() {
	
		return this.system;
	}
	
	@Override
	public String toString() {
		
		 return name + "(" +
				 "cap=" + cap +
				 ", os=" + system +
				 ")";
	}
}