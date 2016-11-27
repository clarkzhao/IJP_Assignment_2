import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class WorldController {
	private TheLabWorld lab;
	@FXML
	private ImageView imageView;

	@FXML
	private ImageView basketView;

	public void Initialise() {
		lab = new TheLabWorld();
		String labPictureName = lab.getCurrentPictureName();
		System.out.println(labPictureName);
        Image image = new Image(labPictureName);
        imageView.setImage(image);
	}

    public void pressButtonRight(ActionEvent event) {
    	String command = "right";
    	lab.processCommand(command);
    	String labPictureName = lab.getCurrentPictureName();
		System.out.println(labPictureName);
    	Image image = new Image(labPictureName);
    	imageView.setImage(image);
    }

    public void pressButtonLeft(ActionEvent event) {
    	String command = "left";
    	lab.processCommand(command);
    	String labPictureName = lab.getCurrentPictureName();
		System.out.println(labPictureName);
    	Image image = new Image(labPictureName);
    	imageView.setImage(image);
     }

    public void pressButtonForward(ActionEvent event) {
        Image basket = new Image("img/basket.png");
         basketView.setImage(basket);
     }

}
