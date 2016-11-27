import java.util.Set;
import java.util.LinkedHashMap;
//import java.util.Iterator;
//import java.util.ArrayList;


public class ViewPosition {
	private LinkedHashMap<String, Integer> views = new LinkedHashMap<String, Integer>();
	private int currentView;

	public ViewPosition(){
		// every position should at least have three view positions
		String initViewDirections[] = {"left", "middle", "right"};
		for (String direction: initViewDirections){
			views.put(direction, 1); //every view position should have at least 1 view degree
		}
		addView("right"); //This refers to the opposite of middle
		currentView = 2; // index starts from 1 and 1 is left1, 2 is middle1, 3 is right1
	}

// Getters
	public LinkedHashMap<String, Integer> getViews(){
		return views;
	}

	public int getTotalDegree(){
		int returnDegree = 0;
        Set<String> keys = views.keySet();
        for(String key : keys) {
        	returnDegree += views.get(key);
        }
        return returnDegree;
	}

	public int getCurrentView(){
		return currentView;
	}

	public String getCurrentViewName(){
        Set<String> keys = views.keySet();
        String returnString = "";
    	int sumOfDegree = 0;
    	boolean flag = false;
        for(String key : keys) {
        	sumOfDegree += views.get(key); // 1->2->3
        	if (currentView <= sumOfDegree){
        		flag = true;
        		int viewDegree = currentView - sumOfDegree + views.get(key);
        		returnString = key + String.valueOf(viewDegree);
        		break;
        	}
        }
    	if (!flag){
    		System.err.append("Illegal currentViews");
    	}
		return returnString;
	}

//setters
	//This method should always conducted before the currentView is changed.
	//Which means that when it was conducted, the currentView is always refers to the middle.
	public void addView(String direction){
		if (views.containsKey(direction)){
			int value = views.get(direction);
			views.put(direction, value+1);
			if (direction == "left"){
				currentView += 1;
			}
		}
		else {
			System.err.append("the direction is illegal");
		}
	}

	public void setViews(String direction, int degree){
		views.put(direction, degree);
	}

	public void setCurrentView(int currentView){
		this.currentView = currentView;
	}


//	public void setCurrentView(String direction, int degree){
//		String directionLowerCase = direction.toLowerCase();
//		if (views.containsKey(direction)){
//			switch (directionLowerCase){
//				case "left":
//					currentView = degree;
//					break;
//				case "middle":
//					currentView = views.get("left") + degree;
//					break;
//				case "right":
//					currentView = views.get("left") + views.get("middle") + degree;
//					break;
//			}
//		}
//		else {
//			System.err.append("the direction is illegal");
//		}
//	}
}
