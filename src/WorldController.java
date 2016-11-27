import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
public class WorldController {
	private TheLabWorld lab;
	@FXML
	private ImageView imageView;

	@FXML
	private ImageView basketView, waterView;

	@FXML
	private ImageView basket, water;
	@FXML
	private ImageView pocketView;
	@FXML
	private Button forward;
	@FXML
	private MenuItem pickUp0, pickUp1, putDown0, putDown1;


	public void Initialise() {
		lab = new TheLabWorld();
		String labPictureName = lab.getCurrentPictureName();
		System.out.println(labPictureName);
        Image image = new Image("img/Hall0_1.JPG");
        imageView.setImage(image);
        Image pocketImage = new Image("img/pocket.png");
        pocketView.setImage(pocketImage);
        Image basketImage = new Image("img/basket.png");
        updateItem();
        updateMenu();
	}

	public void updateItem(){
        Image basketImage = new Image("img/basket.png");
        Image waterImage = new Image("img/water.png");
        ImageView[] itemViewInPocket = new ImageView[2];
        itemViewInPocket[0] = basket;
        itemViewInPocket[1] = water;
        ImageView[] itemViewInLocation = new ImageView[2];
        itemViewInLocation[0] = basketView;
        itemViewInLocation[1] = waterView;
        ImageView[][] itemView = new ImageView[2][2];
        itemView[0] = itemViewInPocket;
        itemView[1] = itemViewInLocation;
        for (ImageView[] view : itemView){
        	for (ImageView v: view){
            	v.setVisible(false);
        	}
        }
        itemViewInPocket[0].setImage(basketImage);
        itemViewInPocket[1].setImage(waterImage);
        itemViewInLocation[0].setImage(basketImage);
        itemViewInLocation[1].setImage(waterImage);
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
					System.out.println(i.getCurrentLocation().getLocation());
					itemViewInLocation[j].setVisible(true);
				}
				//not in current location
				else {
					itemViewInLocation[j].setVisible(false);
				}
			}
		}
	}
    public void pickUpBasket(ActionEvent event){
    	lab.pickUpItem(0);
    	updateItem();
    	updateMenu();
    }
    public void putDownBasket(ActionEvent event){
    	lab.putDownItem(0);
    	updateItem();
    	updateMenu();
    }

    public void pickUpWater(ActionEvent event){
    	lab.pickUpItem(1);
    	updateItem();
    	updateMenu();
    }
    public void putDownWater(ActionEvent event){
    	lab.putDownItem(1);
    	updateItem();
    	updateMenu();
    }

    public void updateMenu(){
    	MenuItem[][] menuItem = new MenuItem[2][2];
    	MenuItem[] basketpMenuItem = new MenuItem[2];
    	MenuItem[] waterMenuItem = new MenuItem[2];
    	basketpMenuItem[0] = pickUp0;
    	basketpMenuItem[1] = putDown0;
    	waterMenuItem[0] = pickUp1;
    	waterMenuItem[1] = putDown1;
    	menuItem[0] = basketpMenuItem;
    	menuItem[1] = waterMenuItem;
		for (int j =0; j<lab.getItemList().length; j++){
			System.out.println("j :"+j);
			MenuItem pickUpMenuItem = menuItem[j][0];
			MenuItem putDownMenuItem = menuItem[j][1];
			if (lab.canPickUp(j)){
				System.out.println(lab.getItemList()[j].getName() + "can pick up");
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

	private void processButton(String command){
		lab.processCommand(command);
		if (!lab.isForwardable()){
			forward.setDisable(true);
		}
		else {
			forward.setDisable(false);
		}
    	String labPictureName = lab.getCurrentPictureName();
		System.out.println(labPictureName);
    	Image image = new Image(labPictureName);
    	imageView.setImage(image);
    	updateItem();
    	updateMenu();
    }

    public void pressButtonRight(ActionEvent event) {
    	String command = "right";
    	this.processButton(command);
    }

    public void pressButtonLeft(ActionEvent event) {
    	String command = "left";
    	this.processButton(command);
     }

    public void pressButtonForward(ActionEvent event) {
    	String command = "forward";
    	this.processButton(command);
     }
}