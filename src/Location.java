import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Location {

	private String location;
	private ViewPosition viewPosition;
	private HashMap<String, Location> exits;

	public Location(String description){
		viewPosition = new ViewPosition();
		this.location = description;
		exits = new HashMap<>();
		setView();
	}

	public void setExit(String viewPosition, Location neighbor){

		String key = location + "_" + viewPosition;

		exits.put(key, neighbor);
	}

	public void setView(){
		viewPosition.setView("left", 1);
		viewPosition.setView("right", 1);
	}

	public void setView(String direction, int degree){
		viewPosition.setView(direction, degree);
	}

	public void addView(String direction, int degree){
		for (int i=1; i <= degree; i++){
			viewPosition.addView(direction);
		}
	}

	public void setCurrentView(String direction, int degree){
		viewPosition.setCurrentView(direction, degree);
	}

    public String getShortDescription(){
        return location;
    }

    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public String getLocation(){
    	return location;
    }

    public String getCurrentLocationName(){
    	return location + "_" + viewPosition.getViewPositionName();
    }
}
