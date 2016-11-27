import java.util.ArrayList;

public class TheLabWorld {

	private Location currentLocation;
//	public PortableItem basket;
//	public PortableItem warter;
//	public ArrayList<PortableItem> itemList;
	public PortableItem[] itemList;
	public TheLabWorld(){
		createWorld();
	}

    private void createWorld(){
//Locations
    	Location Hall0, Hall1, B30, B31, B32,kitchen;
    	Hall0 = new Location("Hall0", 5);
    	Hall1 = new Room("Hall1",4);
    	kitchen = new Room("kitchen",4);
    	B30 = new Room("B30",4);
    	B31 = new Room("B31",4);
    	B32 = new Room("B32",4);
    	Hall0.setExit(1, B30);
    	Hall0.setExit(5, B31);
//    	Hall0.setExit(2, B32);
//    	Hall0.setExit(3, Hall1);
    	B30.setExit(3, Hall0);
    	B30.setExit(4, kitchen);
    	B31.setExit(3, Hall0);
    	kitchen.setExit(3, B30);
    	currentLocation = Hall0;
 //Items
    	itemList = new PortableItem[3];
    	itemList[0] = new PortableItem("basket");
    	itemList[1] = new PortableItem("water");
    	itemList[2] = new PortableItem("rabbit");
    }

    public PortableItem[] getItemList(){
    	return itemList;
    }

    public void putDownItem(int i){
    	this.itemList[i].putDownItem(currentLocation);
    }

    public void pickUpItem(int i){
    	this.itemList[i].pickUpItem();
    }

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

	public void processCommand(String command){
    	if (command == "right"){
    		currentLocation.rotateRight();
    	}
    	else if (command == "left") {
    		currentLocation.rotateLeft();
    	}
    	else if (command == "forward"){
    		Location nextLocation = currentLocation.moveforward();
    		if (nextLocation == null){
                System.out.println("There is no room forward!");
    		}
    		else {
    			currentLocation = nextLocation;
    		}
    	}
    	else {
    		System.err.append("Wrong command!");
    	}
    }

    public Location getCurrentLocaiton(){
    	return currentLocation;
    }

    public String getCurrentLocationName(){
    	return currentLocation.getLocation();
    }

    public String getCurrentPictureName(){
    	return "img/" + currentLocation.getCurrentLocationName() + ".JPG";
    }

    public boolean isForwardable(){
    	return currentLocation.isForwardable();
    }

}
