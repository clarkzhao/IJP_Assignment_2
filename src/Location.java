import java.util.HashMap;
/***
 * Class Location is used to describe the location in the world.
 * @author zhaosiyuan
 *
 */
public class Location {

	private String location;
	private int totalViewDegree;
	protected int currentViewDegree;
	protected HashMap<Integer, Location> exits;

	/***
	 * used to describe the location in the world.
	 * @param locationName is the name of the location.
	 * @param degree is the the current direction.
	 */
	public Location(String locationName, int degree){
		location = locationName;
		exits = new HashMap<>();
		totalViewDegree = degree; //Every location should at least have 4 directions
		currentViewDegree = 1; //The first one is middle, 1-based index.
	}

	/***
	 * sets the exits of next location.
	 * @param degree is the degree connected to the exits location
	 * @param location is the destination exits location
	 */
	public void setExit(int degree, Location location){
		exits.put(degree, location);
	}

	/***
	 * rotate right
	 */
	public void rotateRight(){
		currentViewDegree++;
		if (currentViewDegree > totalViewDegree){
			currentViewDegree = currentViewDegree - totalViewDegree;
		}
	}

	/***
	 * rotate left
	 */
	public void rotateLeft(){
		currentViewDegree--;
		if (currentViewDegree <= 0){
			currentViewDegree += totalViewDegree;
		}
	}

	/***
	 * move forward
	 * @return the next location
	 */
	public Location moveForward(){
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
	    	case 6:
	    		currentViewDegree = 3;
	    		break;
	    	}
		}
		return nextLocation;
	}

	/***
	 * checks whether p eople can move forward in current direction
	 * @return
	 */
	public boolean isForwardable(){
		return exits.containsKey(currentViewDegree);
	}

	/***
	 * it's a getter function to get the attribute Location
	 * @return the name of the lation
	 */
    public String getLocation(){
    	return location;
    }

    /***
     * returns a string combining the location name and direction.
     * @return a string for the picture name.
     */
    public String getCurrentLocationName(){
    	return location + "_" + currentViewDegree;
    }

    /***
     * checks whether one location equals to another location in content.
     * Only name is checked because if the name is equal,
     * the location should be the same.
     */
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
