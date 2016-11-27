import java.util.Set;
import java.util.HashMap;
//import java.util.Iterator;
//import java.util.ArrayList;

public class Location {

	private String location;
	private ViewPosition viewPosition;
	private HashMap<Integer, Location> exits;

	public Location(String locationName){
		location = locationName;
		exits = new HashMap<>();
		viewPosition = new ViewPosition();
	}

	public void setExit(int currentView, Location neighbor){
//		String key = location + "_" + viewPosition.getCurrentViewName();
		exits.put(currentView, neighbor);
	}

	public void addView(String direction, int degree){
		for (int i=1; i <= degree; i++){
			viewPosition.addView(direction);
		}
	}


	public void rotateRight(){
		int previousCurrentView = viewPosition.getCurrentView();
		int currentView = previousCurrentView +1;
		if (currentView <= viewPosition.getTotalDegree()){
			viewPosition.setCurrentView(currentView);
		}
		else{
			viewPosition.setCurrentView(currentView - viewPosition.getTotalDegree());
		}
	}

	public void rotateLeft(){
		int previousCurrentView = viewPosition.getCurrentView();
		int currentView = previousCurrentView -1;
		if (currentView > 0){
			viewPosition.setCurrentView(currentView);
		}
		else{
			viewPosition.setCurrentView(currentView + viewPosition.getTotalDegree());
		}
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
    	return location + "_" + viewPosition.getCurrentViewName();
    }
}
