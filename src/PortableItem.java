/***
 * describe the portable item to be picked up and put down by user.
 * @author zhaosiyuan
 *
 */
public class PortableItem {
	private String name;
	private Location currentLocation;
	/***
	 *	constructor for the class
	 * @param the name of the item
	 */
	public PortableItem(String name){
		this.name = name;
		currentLocation = null;
	}

	/***
	 * returns the name of the item.
	 * @return the name of the item.
	 */
	public String getName(){
		return name;
	}

	/***
	 *
	 * @return the current location of the item.
	 */
	public Location getCurrentLocation(){
		return currentLocation;
	}

	/***
	 * put down the item
	 * @param location is the new location to put down.
	 */
	public void putDownItem(Location location){
		currentLocation = location;
	}

	/***
	 * pick up the item
	 */
	public void pickUpItem(){
		currentLocation = null;
	}

	/***
	 * to check if the item has been put down in any locations.
	 * @return a boolean value
	 */
	public boolean isBeenPutDown(){
		if (currentLocation == null){
			return false;
		}
		else{
			return true;
		}
	}
}
