import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Location {

	private String description;
	private String viewPosition;
	private HashMap<String, Location> exits;


	public Location(String description, String viewPosition){
		this.description = description;
		this.viewPosition = viewPosition;
		exits = new HashMap<>();
	}

	public void setExit(String direction, Location neighbor){

		String key = description + "_" + viewPosition;

		exits.put(key, neighbor);
	}

    public String getShortDescription(){
        return description;
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

    public String getCurrentLocation(){
    	return description + "_" + viewPosition;
    }
}
