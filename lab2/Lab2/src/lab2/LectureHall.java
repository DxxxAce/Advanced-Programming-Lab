package lab2;

public class LectureHall extends Room {

	private boolean videoProjector;
	
	public void setVideoProjector(boolean videoProjector) {
		
		this.videoProjector = videoProjector;
	}
	
	public boolean getVideoProjector() {
		
		return this.videoProjector;
	}
	
	@Override
	public String toString() {
		
		 return name + "(" +
				 "cap=" + cap +
				 ", projector=" + videoProjector +
				 ")";
	}
}
