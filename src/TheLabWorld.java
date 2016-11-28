/***
 * describe the the lab world in university of Edinburgh in forest hill.
 * @author zhaosiyuan
 *
 */
public class TheLabWorld {

	private Location currentLocation;
	public PortableItem[] itemList;

	/**
	 * initialize the world
	 */
	public TheLabWorld(){
		createWorld();
	}

	/***
	 * the method to create the world.
	 * All locations and portable items needed is built here.
	 */
    private void createWorld(){
//Locations
    	Location Hall0, Hall1, B30, B31, B32,kitchen;
    	Hall0 = new Location("Hall0", 6);
    	Hall1 = new Room("Hall1",4);
    	kitchen = new Room("kitchen",4);
    	B30 = new Room("B30",4);
    	B31 = new Room("B31",4);
    	B32 = new Room("B32",4);
    	Hall0.setExit(1, B30);
    	Hall0.setExit(6, B31);
    	Hall0.setExit(2, B32);
    	Hall0.setExit(3, Hall1);
    	B30.setExit(3, Hall0);
    	B30.setExit(4, kitchen);
    	B31.setExit(3, Hall0);
    	B32.setExit(3, Hall0);
    	Hall1.setExit(3, Hall0);
    	kitchen.setExit(3, B30);
    	currentLocation = Hall0;
 //Items
    	itemList = new PortableItem[3];
    	itemList[0] = new PortableItem("basket");
    	itemList[1] = new PortableItem("water");
    	itemList[2] = new PortableItem("rabbit");
    }

    /***
     * Get the item list
     * @return returns the PortableItem array
     */
    public PortableItem[] getItemList(){
    	return itemList;
    }

    /***
     * put down one item
     * @param i specifies which item to be put down.
     */
    public void putDownItem(int i){
    	this.itemList[i].putDownItem(currentLocation);
    }

    /***
     * pick up one item
     * @param i specifies which item to be picked up.
     */
    public void pickUpItem(int i){
    	this.itemList[i].pickUpItem();
    }

    /***
     * check if one item can be picked up
     * @param i specifies which item to be picked up.
     * @return a boolean value
     */
    public boolean canPickUp(int i){
    	//in pocket
    	if (itemList[i].getCurrentLocation() == null){
    		return false;
    	}
    	// in current location
    	else if (currentLocation.equals(itemList[i].getCurrentLocation())){
    		return true;
    	}
    	//in other locaiton
    	else {
    		return false;
    	}
    }

    /***
     * check if one item can be put down
     * @param i specifies which item to be put down.
     * @return a boolean value
     */
    public boolean canPutdown(int i){
    	// in pocket
    	if (itemList[i].getCurrentLocation() == null ){
    		return true;
    	}
    	// not in pocket
    	else {
    		return false;
    	}
    }

    /***
     * Process the given command from "right", "left" and "forward"
     * @param command
     */
	public void processCommand(String command){
    	if (command == "right"){
    		currentLocation.rotateRight();
    	}
    	else if (command == "left") {
    		currentLocation.rotateLeft();
    	}
    	else if (command == "forward"){
    		Location nextLocation = currentLocation.moveForward();
    		//If no way to mvoe forward
    		if (nextLocation == null){
                System.out.println("There is no room forward!");
    		}
    		//otherwise
    		else {
    			currentLocation = nextLocation;
    		}
    	}
    	else {
    		System.err.append("Wrong command!");
    	}
    }

	/**
	 * get current location
	 * @return Location
	 */
    public Location getCurrentLocaiton(){
    	return currentLocation;
    }

    /**
     * get current location's name
     * @return a String value represents the name
     */
    public String getCurrentLocationName(){
    	return currentLocation.getLocation();
    }


    /**
     *  the current file url
     * @return the picutre url
     */
    public String getCurrentPictureName(){
    	return "img/"+currentLocation.getCurrentLocationName() + ".JPG";
    }

    /**
     * checks if people can forward in current location
     * @return
     */
    public boolean isForwardable(){
    	return currentLocation.isForwardable();
    }

}
