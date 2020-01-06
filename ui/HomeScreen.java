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
	private int stageY = 1000;
	//Instantiate empty User Class
	private User user = new User(null, null, null, null, null);
	/**
	 * This class controls creation of the main stage for the program, as well
	 * as creation of the home screen scene. It provides information on the app
	 * as well as a brief form for users to fill out before using it.
	 * @return This method returns a scene for the home screen (type Scene).
	 */
	public Scene start() {
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
		/**
		 * ADDING IMAGE
		 */
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
		img.setPadding(new Insets(10,10,0,10));
		/**
		 * CREATING GREEN BOX
		 */
		//Input Rectangle
		Rectangle inputRect = new Rectangle(520, 650);
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
		
		/**
		 * CREATING INTRODUCTION TEXT
		 */
		Text introductionText = new Text(
				"Welcome to Motivate! When setting long-term goals, it can be "
				+ "hard to stay focused and motivated. Simple cell phone reminders "
				+ "and sticky notes lose their meaning over time.\n" + 
				"\n" + 
				"With Motivate though, you can write yourself numerous personalized "
				+ "motivational messages that will be randomized and sent to you as "
				+ "often as you'd like until you reach your goal. That way, messages "
				+ "stay fresh,  motivation doesn't die, and you achieve your goal. "
				+ "It's that simple. \n" + 
				"\n" + 
				"Simply fill out the information below and click continue. "
				);
		introductionText.setWrappingWidth(450);
		introductionText.setTextAlignment(TextAlignment.CENTER);
		HBox textBox = new HBox(introductionText);
		textBox.setAlignment(Pos.TOP_CENTER);
		textBox.setPadding(new Insets(230,0,0,0));
		/**
		 * CREATING INPUT FIELDS
		 */
		//Name input field
		TextField nameInput = new TextField();
		//Frequency Dropdown
		ComboBox<String> frequencyComboBox = new ComboBox<>();
		frequencyComboBox.getItems().add("Twice a day");
		frequencyComboBox.getItems().add("Once a day");
		frequencyComboBox.getItems().add("Every other day");
		frequencyComboBox.getItems().add("Once a week");
		frequencyComboBox.setVisibleRowCount(4);
		frequencyComboBox.setPrefWidth(165);
		//Goal input field
		TextField goalInput = new TextField();
		//Date picking field for goal end date
		DatePicker startDatePicker = new DatePicker();
		//Date picking field for goal end date
		DatePicker endDatePicker = new DatePicker();
		//Phone number field
		TextField phoneNumberInput = new TextField();
		//Add all elements to a VBox
	    VBox inputsVBox = new VBox(40);
	    inputsVBox.getChildren().addAll(nameInput,frequencyComboBox,goalInput,
	    		startDatePicker, endDatePicker, phoneNumberInput);
	    inputsVBox.setMaxWidth(150);
	    inputsVBox.setAlignment(Pos.CENTER);
	    inputsVBox.setPadding(new Insets(300,0,0,0));
		/**
		 * CREATING LABELS FOR INPUT FIELDS
		 */
	    Label nameLabel = new Label("Your Name");
	    Label frequencyOfMessagesLabel = new Label("Frequency of Messages");
	    Label goalLabel = new Label("Your Goal");
	    Label goalStartDate = new Label("Goal Start Date");
	    Label goalEndDate = new Label("Goal End Date");
	    Label phoneNumberLabel = new Label("Your Phone Number");
	    VBox labelBox = new VBox(50);
	    labelBox.getChildren().addAll(nameLabel,frequencyOfMessagesLabel,
	    		goalLabel, goalStartDate, goalEndDate,phoneNumberLabel);
	    labelBox.setAlignment(Pos.CENTER_LEFT);
	    labelBox.setPadding(new Insets(295,0,0,0));
	    /**
	     * ADDING THEM ALL TO ONE BOX
	     */
	    HBox totalInputBox = new HBox(30);
	    totalInputBox.getChildren().addAll(labelBox,inputsVBox);
	    totalInputBox.setAlignment(Pos.CENTER);
	    
	    /**
		 * ADDING CONTINUE BUTTON
		 */
	    //Create button 
	  	Button continueButton = new Button("Continue");
	    HBox buttonHolder = new HBox(continueButton);
	    buttonHolder.setAlignment(Pos.CENTER);
	    VBox allUserInputContent = new VBox(55);
		allUserInputContent.getChildren().addAll(totalInputBox, buttonHolder);
		allUserInputContent.setAlignment(Pos.CENTER);
		allUserInputContent.setPadding(new Insets(135, 0, 0, 0));
		continueButton.setOnAction(e -> {
			try {

				user.setName(nameInput.getText());
				user.setdailyFreq(frequencyComboBox.getValue());
				// user.setGoal
				// user.setStartDate()
				// user.setEndDate()
				user.setPhone(phoneNumberInput.getText().replaceAll("[()\\s-]+", ""));
				System.out.println(user.getPhone());
				// Add in null pointers for the remaining three elements.
				if (user.getName() == null || user.getdailyFreq() == null || user.getPhone() == null) {

					throw new NullPointerException();

				}
				// Add pass off to scene 2: message page.
				MessagePage messagePage = new MessagePage();
				messagePage.showMessageEntryPage(mainStage, user);
			} catch (NullPointerException e1) {
				Text error = new Text("Please fill all fields correctly to continue.");
				error.setFont(Font.font("Veranda", 12));
				error.setFill(Color.web("#FF1000"));
				HBox errorBox = new HBox();
				errorBox.setMinWidth(300);
				errorBox.getChildren().add(error);
				errorBox.setTranslateX(250);
				errorBox.setTranslateY(820);
				errorBox.setMouseTransparent(true);
				rootNode.getChildren().add(errorBox);
			}
		});
		/**
		 * FINAL PAGE EDITS - ADD CHILDREN TO ROOTNODE AND SHOW PAGE/RETURN SCENE
		 */
		// Add all children to master VBox
		rootNode.getChildren().addAll(img, titleBox, inputRectangle, textBox, allUserInputContent);
		// Show the stage
		mainStage.show();
		return homeScene;
	}
}