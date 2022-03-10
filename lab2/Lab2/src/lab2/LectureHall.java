package lab2;

/**
 * The LectureHall class, derived from the Room superclass.
 * @author alinh
 *
 */
public class LectureHall extends Room {

	private boolean videoProjector;
	
	/**
	 * The constructor that initializes all of the LectureHall object's parameters.
	 * @param name The name of the lecture hall.
	 * @param cap The maximum student capacity of the lecture hall.
	 * @param videoProjector Whether or not the lecture hall has a video projector.
	 */
	public LectureHall(String name, int cap, boolean videoProjector) {
		
		this.name = name;
		this.cap = cap;
		this.videoProjector = videoProjector;
	}
	
	/**
	 * The video projector setter function.
	 * @param videoProjector Whether or not the lecture hall has a video projector.
	 */
	public void setVideoProjector(boolean videoProjector) {
		
		this.videoProjector = videoProjector;
	}
	
	/**
	 * The video projector getter function.
	 * @return Whether or not the lecture hall has a video projector.
	 */
	public boolean getVideoProjector() {
		
		return this.videoProjector;
	}
	
	/**
	 * Override of the toString function.
	 */
	@Override
	public String toString() {
		
		 return name + "(" +
				 "cap=" + cap +
				 ", video_projector=" + videoProjector +
				 ")";
	}
}
