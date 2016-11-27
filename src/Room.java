
public class Room extends Location {
	public Room(String locationName, int degree){
		super(locationName, degree);
	}
	public Location moveforward(){
		Location nextLocation = this.exits.get(currentViewDegree);
		if (nextLocation != null){
	    	switch (currentViewDegree){
	    	case 1:
	    		currentViewDegree = 3;
	    		break;
	    	case 2:
	    		currentViewDegree = 4;
	    		break;
	    	case 3:
	    		currentViewDegree = 1;
	    		break;
	    	case 4:
	    		currentViewDegree = 2;
	    		break;
	    	}
		}
		return nextLocation;
	}

}
