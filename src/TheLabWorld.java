public class TheLabWorld {

	private Location currentLocation;

	public TheLabWorld(){
		createWorld();
	}

    private void createWorld(){
    	Location Hall0, Hall1, B31;
    	Hall0 = new Location("Hall0");
    	Hall0.addView("right", 1);
    	Hall1 = new Location("Hall1");
    	B31 = new Location("B31");
//    	Hall0.setExit(1, neighbor);
    	currentLocation = Hall0;
    }

    public void processCommand(String command){
    	if (command == "right"){
    		currentLocation.rotateRight();
    	}else if  (command == "left") {
    		currentLocation.rotateLeft();
    	} else {
    		System.err.append("Wrong command!");
    	}
    }

    public String getCurrentPictureName(){
    	return "img/" + currentLocation.getCurrentLocationName() + ".JPG";
    }

//    private void changeCurrentLocation(){
//
//    }

}
