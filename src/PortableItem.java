public class PortableItem {
	private String name;
	private Location currentLocation;

	public PortableItem(String name){
		this.name = name;
		currentLocation = null;
	}

	public String getName(){
		return name;
	}

	public Location getCurrentLocation(){
		return currentLocation;
	}

	public void putDownItem(Location location){
		currentLocation = location;
	}

	public void pickUpItem(){
		currentLocation = null;
	}

	public boolean isBeenPutDown(){
		if (currentLocation == null){
			return false;
		}
		else{
			return true;
		}
	}
}
