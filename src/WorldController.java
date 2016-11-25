import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class WorldController {

	@FXML
	private ImageView imageView;

	@FXML
	private ImageView basketView;

	public void Initialise() {
        Image image = new Image("img/Hall0_middle.JPG");
        imageView.setImage(image);
	}

    public void pressButtonRight(ActionEvent event) {
    	String command = "right";
    	Image basket = new Image("img/basket.png");
        basketView.setImage(basket);
    }

    public void pressButtonLeft(ActionEvent event) {
        Image basket = new Image("img/basket.png");
         basketView.setImage(basket);
     }

    public void pressButtonForward(ActionEvent event) {
        Image basket = new Image("img/basket.png");
         basketView.setImage(basket);
     }

}
