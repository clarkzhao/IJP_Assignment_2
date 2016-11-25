import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;


public class ViewPosition {
	private HashMap<String, Integer> views;
	int currentView;
//	private String currentViewDirection;
//	private int currentViewDegree;

	public ViewPosition(){
		String initViewDirection = "middle";
		views.put(initViewDirection, 1);
		setCurrentView(initViewDirection,1);
	}

	public String getCurrentViewDirection(){
		return currentViewDirection;
	}

	public int getCurrentViewDegree(){
		return currentViewDegree;
	}

	public String getCurrentViewPositionName(){
		return currentViewDirection + String.valueOf(currentViewDegree);
	}



	public void setView(String direction, int degree){
		views.put(direction, degree);
	}

	public void addView(String direction){
		if (views.containsKey(direction)){
			int value = views.get(direction);
			views.put(direction, value+1);
		}
		else {
			System.err.append("the direction is illegal");
		}
	}

	public void setCurrentView(String direction, int degree){
		if (views.containsKey(direction)){
			if (views.get(direction) >= degree){
				currentViewDirection = direction;
				currentViewDegree = degree;
			}
			else {
				System.err.append("the view degree exceeds the limit");
			}
		}
		else {
			System.err.append("the direction is illegal");
		}
	}
}
