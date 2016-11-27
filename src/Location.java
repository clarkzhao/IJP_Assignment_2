import java.util.HashMap;
//import java.util.Iterator;
//import java.util.ArrayList;

public class Location {

	private String location;
//	private ViewPosition viewPosition;
	private int totalViewDegree;
	protected int currentViewDegree;
	protected HashMap<Integer, Location> exits;

	public Location(String locationName, int degree){
		location = locationName;
		exits = new HashMap<>();
		totalViewDegree = degree; //Every location should at least have 4 directions
		currentViewDegree = 1; //The first one is middle, 1-based index.
	}

	public void setExit(int degree, Location location){
		exits.put(degree, location);
	}

	public void rotateRight(){
		currentViewDegree++;
		if (currentViewDegree > totalViewDegree){
			currentViewDegree = currentViewDegree - totalViewDegree;
		}
	}

	public void rotateLeft(){
		currentViewDegree--;
		if (currentViewDegree <= 0){
			currentViewDegree += totalViewDegree;
		}
	}

	public Location moveforward(){
		Location nextLocation = exits.get(currentViewDegree);
		if (isForwardable()){
	    	switch (currentViewDegree){
	    	case 1:
	    		currentViewDegree = 4;
	    		break;
	    	case 2:
	    		currentViewDegree = 5;
	    		break;
	    	case 3:
	    		currentViewDegree = 5;
	    		break;
	    	case 5:
	    		currentViewDegree = 3;
	    		break;
	    	}
		}
		return nextLocation;
	}

	public boolean isForwardable(){
		return exits.containsKey(currentViewDegree);
	}
    public String getLocation(){
    	return location;
    }

    public String getCurrentLocationName(){
    	return location + "_" + currentViewDegree;
    }

    public boolean equals(Object obj){
    	if (this == obj) {
    		return true;
    	}
    	Location other = (Location) obj;
    	if (location == other.getLocation()){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
