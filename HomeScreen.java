import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.application.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import javafx.event.ActionEvent;


/**
 * This class provides the home page UI for the Motivate app. It allows for user 
 * data entry to start reaching their goals. Once their data is entered, it will
 * be saved in the User class and used to manage when they receive messages.
 * @author admin
 *
 */
public class HomeScreen {

	
	//Stage width
	private int stageX = 800;
	//Stage height
	private int stageY = 900;
	//Instantiate empty User Class
	private User user = new User(null, null, null, 0.0, 0, null);
	
	public Scene start() {
		
		Stage mainStage = new Stage();
		Group homeGroup = new Group();
		ScrollPane homeScroll = new ScrollPane(homeGroup);
	    homeScroll.setHmax(0);
		homeScroll.setStyle("-fx-background: rgb(255,255,255)");
		Scene homeScene = new Scene(homeScroll, stageX, stageY);
		mainStage.setScene(homeScene);
		mainStage.setTitle("Motivate");
		

		mainStage.show();
		
		return homeScene;
		
	}
	
	
	
	
}




