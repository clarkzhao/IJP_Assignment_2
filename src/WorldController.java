import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
/**
 * The controller for the world
 * @author zhaosiyuan
 *
 */
public class WorldController {
	private TheLabWorld lab;
	@FXML
	private ImageView imageView, mapView;

	@FXML
	private ImageView basketView, waterView, rabbitView;

	@FXML
	private ImageView basket, water, rabbit;
	@FXML
	private Button forward;
	@FXML
	private MenuItem pickUp0, pickUp1, putDown0, putDown1, pickUp2, putDown2;
	@FXML
	private Text showPosition;

	/**
	 *
	 */
	public void Initialise() {
		lab = new TheLabWorld();
        Image image = new Image("img/Hall0_1.JPG");
        imageView.setImage(image);
        Image mapImage = new Image("img/map.png");
        mapView.setImage(mapImage);
        updateItem();
        updateMenu();
        showPosition.setText("Your are in: "+ lab.getCurrentLocationName());
	}

	/**
	 * Update the image view of item in the pane
	 */
	public void updateItem(){
        Image basketImage = new Image("img/basket.png");
        Image waterImage = new Image("img/water.png");
        Image rabbitImage = new Image("img/rabbit.png");
        ImageView[] itemViewInPocket = new ImageView[3];
        itemViewInPocket[0] = basket;
        itemViewInPocket[1] = water;
        itemViewInPocket[2] = rabbit;
        ImageView[] itemViewInLocation = new ImageView[3];
        itemViewInLocation[0] = basketView;
        itemViewInLocation[1] = waterView;
        itemViewInLocation[2] = rabbitView;
        ImageView[][] itemView = new ImageView[2][3];
        itemView[0] = itemViewInPocket;
        itemView[1] = itemViewInLocation;
        for (ImageView[] view : itemView){
        	for (ImageView v: view){
            	v.setVisible(false);
        	}
        }
        itemViewInPocket[0].setImage(basketImage);
        itemViewInPocket[1].setImage(waterImage);
        itemViewInPocket[2].setImage(rabbitImage);
        itemViewInLocation[0].setImage(basketImage);
        itemViewInLocation[1].setImage(waterImage);
        itemViewInLocation[2].setImage(rabbitImage);
		for (int j =0; j<lab.getItemList().length; j++){
			PortableItem i = lab.getItemList()[j];
			//in pocket
			if (!i.isBeenPutDown()){
				itemViewInPocket[j].setVisible(true);
			}
			//not in pocket
			else {
				itemViewInPocket[j].setVisible(false);
				// in current location
				if (lab.getCurrentLocaiton().equals(i.getCurrentLocation())){
					itemViewInLocation[j].setVisible(true);
				}
				//not in current location
				else {
					itemViewInLocation[j].setVisible(false);
				}
			}
		}
	}

	/**
	 * Pick up action for the basket item
	 * @param event
	 */
    public void pickUpBasket(ActionEvent event){
    	lab.pickUpItem(0);
    	updateItem();
    	updateMenu();
    }

    /**
     * put down action for the basket item
     * @param event
     */
    public void putDownBasket(ActionEvent event){
    	lab.putDownItem(0);
    	updateItem();
    	updateMenu();
    }

    /**
     * Pick up action for the bottle of water item
     * @param event
     */
    public void pickUpWater(ActionEvent event){
    	lab.pickUpItem(1);
    	updateItem();
    	updateMenu();
    }

    /**
     * put down action for the bottle of water item
     * @param event
     */
    public void putDownWater(ActionEvent event){
    	lab.putDownItem(1);
    	updateItem();
    	updateMenu();
    }

    /**
     * Pick up action for the rabbit item
     * @param event
     */
    public void pickUpRabbit(ActionEvent event){
    	lab.pickUpItem(2);
    	updateItem();
    	updateMenu();
    }

    /**
     * put down action for the rabbit item
     * @param event
     */
    public void putDownRabbit(ActionEvent event){
    	lab.putDownItem(2);
    	updateItem();
    	updateMenu();
    }

    /**
     * update the menu set some of menu item disable
     */
    public void updateMenu(){
    	MenuItem[][] menuItem = new MenuItem[3][2];
    	MenuItem[] basketpMenuItem = new MenuItem[2];
    	MenuItem[] waterMenuItem = new MenuItem[2];
    	MenuItem[] rabbitMenuItem = new MenuItem[2];
    	basketpMenuItem[0] = pickUp0;
    	basketpMenuItem[1] = putDown0;
    	waterMenuItem[0] = pickUp1;
    	waterMenuItem[1] = putDown1;
    	rabbitMenuItem[0] = pickUp2;
    	rabbitMenuItem[1] = putDown2;
    	menuItem[0] = basketpMenuItem;
    	menuItem[1] = waterMenuItem;
    	menuItem[2] = rabbitMenuItem;
		for (int j =0; j<lab.getItemList().length; j++){
			MenuItem pickUpMenuItem = menuItem[j][0];
			MenuItem putDownMenuItem = menuItem[j][1];
			if (lab.canPickUp(j)){
				pickUpMenuItem.setDisable(false);
			}
			else {
				pickUpMenuItem.setDisable(true);
			}
			if(lab.canPutdown(j)){
				putDownMenuItem.setDisable(false);
			}
			else{
				putDownMenuItem.setDisable(true);
			}
		}
    }

    /**
     * process the button
     * @param command
     */
	private void processButton(String command){
		lab.processCommand(command);
		if (!lab.isForwardable()){
			forward.setDisable(true);
		}
		else {
			forward.setDisable(false);
		}
    	String labPictureName = lab.getCurrentPictureName();
    	Image image = new Image(labPictureName);
    	imageView.setImage(image);
    	updateItem();
    	updateMenu();
        showPosition.setText("Your are in: "+ lab.getCurrentLocationName());
    }

	/**
	 * process the button to rotate right
	 * @param event
	 */
    public void pressButtonRight(ActionEvent event) {
    	String command = "right";
    	this.processButton(command);
    }

    /**
     * process the button to rotate left
     * @param event
     */
    public void pressButtonLeft(ActionEvent event) {
    	String command = "left";
    	this.processButton(command);
     }

    /**
     * process the button to move forward
     * @param event
     */
    public void pressButtonForward(ActionEvent event) {
    	String command = "forward";
    	this.processButton(command);
     }
}