package ui;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.text.FontPosture;
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

import backend.User;
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
	private int stageX = 700;
	//Stage height
	private int stageY = 900;
	//Instantiate empty User Class
	private User user = new User(null, null, null, null, null);
	
	public Scene start() {
		
		//Setting up the main stage and scene
		Stage mainStage = new Stage();
		StackPane rootNode = new StackPane();
		ScrollPane scroll = new ScrollPane(rootNode);
		// make that node fill entire width
		scroll.setFitToWidth(true);
		// set background white
		scroll.setStyle("-fx-background: white");
		// Create Scene and link it with ScrollPane can have only one node
		// If you omit the width and height, the scene will be sized automatically based on the size of
		// the elements contained
		Scene homeScene = new Scene(scroll, stageX, stageY);
		mainStage.setScene(homeScene);
		mainStage.setTitle("Motivate");
		// Create and format a title
		Text title = new Text("Motivate");
		title.setFont(Font.font("Arial Rounded MT", FontWeight.BOLD, FontPosture.ITALIC, 30));
		// Create an HBox for the title
		HBox titleBox = new HBox(title);
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(145, 0, 0, 0));
		
		// Gender Image
		Image image = null;
		try {
			image = new Image(new FileInputStream("logo.png"), 800, 800, true, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(125);
		imageView.setFitWidth(125);
		imageView.setPreserveRatio(true);

		HBox img = new HBox(imageView);
		img.setAlignment(Pos.TOP_CENTER);
		img.setPadding(new Insets(10,10,10,10));

		//Input Rectangle
		Rectangle inputRect = new Rectangle(520, 500);
		inputRect.setFill(Color.rgb(212, 255, 215));
		inputRect.setStroke(Color.rgb(98, 245, 108));
		inputRect.setStrokeWidth(1);
		inputRect.setArcHeight(35.0);
		inputRect.setArcWidth(25.0);
		//Putting input box within a child vbox
		VBox inputRectangle = new VBox();
		inputRectangle.getChildren().add(inputRect);
		//inputRectangle.setViewOrder(5.0);
		inputRectangle.setAlignment(Pos.BOTTOM_CENTER);
		inputRectangle.setPadding(new Insets(200,0,50,0));
		
		//Name input field
		TextField nameInput = new TextField();
		nameInput.setMinWidth(150);
		HBox nameBox = new HBox(nameInput);
		//nameBox.setViewOrder(0.0);
		nameBox.setAlignment(Pos.CENTER);
		nameBox.setPadding(new Insets(0,50,0,0));
		
		//Goal input field
		TextField goalInput = new TextField();
		goalInput.setMinWidth(150);
		HBox goalBox = new HBox(goalInput);
		//goalBox.setViewOrder(0.0);
		goalBox.setAlignment(Pos.CENTER);
		goalBox.setPadding(new Insets(150,50,0,0));
		
		//Frequency Dropdown
		ComboBox frequencyComboBox = new ComboBox();
		frequencyComboBox.getItems().add("Twice a day");
		frequencyComboBox.getItems().add("Once a day");
		frequencyComboBox.getItems().add("Every other day");
		frequencyComboBox.getItems().add("Once a week");		
		HBox comboHBox = new HBox(frequencyComboBox);
		//goalBox.setViewOrder(0.0);
		goalBox.setAlignment(Pos.CENTER);
		goalBox.setPadding(new Insets(300,50,0,0));
		

		//Date picking field for goal end date
		DatePicker datePicker = new DatePicker();
	    HBox theDatePicker = new HBox(datePicker);
	    theDatePicker.setAlignment(Pos.CENTER);
	    theDatePicker.setPadding(new Insets(450,25,0,0));
	    

		//Add all children to master VBox
		rootNode.getChildren().addAll(img,titleBox,inputRectangle,
				nameBox,goalBox,frequencyComboBox,theDatePicker);
		//Show the stage
		mainStage.show();

		return homeScene;
		
	}
	
	
	
	
}




