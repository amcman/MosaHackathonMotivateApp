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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
public class ThankYouPopUp {
	//Stage width
	private int stageX = 550;
	//Stage height
	private int stageY = 250;
	//Instantiate empty User Class
	/**
	 * This class controls creation of the main stage for the program, as well
	 * as creation of the home screen scene. It provides information on the app
	 * as well as a brief form for users to fill out before using it.
	 * @return This method returns a scene for the home screen (type Scene).
	 */
	public Scene start(User user) {
		/**
		 * INITIAL PAGE SETUP
		 */
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
		Scene thankYouScene = new Scene(scroll, stageX, stageY);
		mainStage.setScene(thankYouScene);
		mainStage.setTitle("Motivate");
		/**
		 * ADDING ICON
		 */
		Image checkMark = null;
		try {
			checkMark = new Image(new FileInputStream("completeIcon.png"), 800, 800, true, true);
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		ImageView messageIcon = new ImageView(checkMark);
		messageIcon.setFitHeight(30);
		messageIcon.setFitWidth(30);
		messageIcon.setPreserveRatio(true);
		HBox imageBox = new HBox(messageIcon);
		imageBox.setPadding(new Insets(20,0,0,0));
		imageBox.setAlignment(Pos.TOP_CENTER);
		// Create and format a title
		Text title = new Text("Thank You!");
		title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 30));
		title.setFill(Color.web("#FF826E"));
		// Create an HBox for the title
		HBox titleBox = new HBox(title);
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(0, 0, 10, 0));
		/**
		 * CREATING THE TEXT BOX
		 */
		Text closeOutText = new Text(
				"Thank you for using Motivate, " + user.getName() + "! You should receive an introduction text message "
				+ "momentarily. You'll then begin receiving your motivational texts "
				+  user.getdailyFreq().toLowerCase() + ". \n"
				+ "\n"
				+ "GOOD LUCK!"
				);
		closeOutText.setTextAlignment(TextAlignment.CENTER);
		closeOutText.setWrappingWidth(500);
		HBox textBox = new HBox(closeOutText);
		textBox.setAlignment(Pos.BOTTOM_CENTER);
		/**
		 * EXIT BUTTON
		 */
		Button exitAppButton = new Button("  Exit  ");
		exitAppButton.setAlignment(Pos.CENTER);
		exitAppButton.setStyle("-fx-background-radius: 15; -fx-background-color: #FFBEB4;"
	  			+ " -fx-border-color: #FF826E; -fx-border-radius:15");
		exitAppButton.setOnAction(e -> {
			mainStage.close();
		});
		/**
		 * FINAL PAGE EDITS - ADD CHILDREN TO ROOTNODE AND SHOW PAGE/RETURN SCENE
		 */
		// Add all children to master VBox
		VBox allContent = new VBox(20);
		allContent.setAlignment(Pos.CENTER);
		allContent.getChildren().addAll(imageBox,titleBox,closeOutText,exitAppButton);
		rootNode.getChildren().addAll(allContent);
		// Show the stage
		mainStage.show();
		return thankYouScene;
	}
}