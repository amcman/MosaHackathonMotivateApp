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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DateCell;
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
import java.time.DayOfWeek;
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
public class HomeScreen {
	//Stage width
	private int stageX = 700;
	//Stage height
	private int stageY = 1000;
	//Instantiate empty User Class
	private User user = new User();
	//Idle button formatting
	private String IDLE = "-fx-background-radius: 15; -fx-background-color: #FFEDEA;"
  			+ " -fx-border-color: #FF826E; -fx-border-radius:15";
	//Hovered button formatting
	private String HOVERED = "-fx-background-radius: 15; -fx-background-color: #FFBEB4;"
  			+ " -fx-border-color: #FF826E; -fx-border-radius:15";
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
		title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 30));
		title.setFill(Color.web("#FF826E"));
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
				+ "It's that simple. Please note though, this program only currently serves "
				+ "user with US cell phone numbers. It also currently only supports goals that are "
				+ "at least one week long. \n" + 
				"\n" + 
				"Simply fill out the information below and click continue. "
				);
		introductionText.setWrappingWidth(450);
		introductionText.setTextAlignment(TextAlignment.CENTER);
		Image info = null;
		try {
			info = new Image(new FileInputStream("info.png"), 800, 800, true, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView infoView = new ImageView(info);
		infoView.setFitHeight(15);
		infoView.setFitWidth(15);
		infoView.setPreserveRatio(true);
		Tooltip infoTool = new Tooltip(tooltipInfo());
		infoTool.setTextAlignment(TextAlignment.CENTER);
		infoTool.setWrapText(true);
		Button infoButton = new Button("",infoView);
		infoButton.setTooltip(infoTool);
		infoButton.setStyle("-fx-background-color: transparent;");
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
		//Set range for date pickers
		startDatePicker.setDayCellFactory(picker -> new DateCell() {
        @Override
        public void updateItem(LocalDate date, boolean empty) {
            super.updateItem(date, empty);
            setDisable(empty || date.compareTo(LocalDate.now()) < 0);
        }
        });
		endDatePicker.setDayCellFactory(picker -> new DateCell() {
	    @Override
	    public void updateItem(LocalDate date, boolean empty) {
	        super.updateItem(date, empty);
	        setDisable(empty || date.compareTo(startDatePicker.getValue().plusDays(7)) < 0);
	    }
	    });
		// Phone number field
		TextField phoneNumberInput = new TextField();
		// Add all elements to a VBox
	    VBox inputsVBox = new VBox(40);
	    inputsVBox.getChildren().addAll(nameInput,frequencyComboBox,goalInput,
	    		startDatePicker, endDatePicker, phoneNumberInput);
	    inputsVBox.setMaxWidth(150);
	    inputsVBox.setAlignment(Pos.CENTER);
	    inputsVBox.setPadding(new Insets(300,0,0,0));
		/**
		 * CREATING LABELS FOR INPUT FIELDS
		 */
	    Label nameLabel = new Label("Your Name \n ");
	    nameLabel.setTextAlignment(TextAlignment.CENTER);
	    Label frequencyOfMessagesLabel = new Label("Frequency of Messages");
	    frequencyOfMessagesLabel.setTextAlignment(TextAlignment.CENTER);
	    Label goalLabel = new Label("Your Goal");
	    HBox goalBox = new HBox(5);
	    goalBox.getChildren().addAll(goalLabel,infoButton);
	    goalBox.setAlignment(Pos.CENTER_RIGHT);
	    Label goalStartDate = new Label("Goal Start Date \n (Format: mm/dd/yyyy)");
	    goalStartDate.setTextAlignment(TextAlignment.RIGHT);
	    Label goalEndDate = new Label("Goal End Date \n (Format: mm/dd/yyyy)");
	    goalEndDate.setTextAlignment(TextAlignment.RIGHT);
	    Label phoneNumberLabel = new Label("Your Phone Number \n (10-digits)");
	    phoneNumberLabel.setTextAlignment(TextAlignment.RIGHT);
	    VBox labelBox = new VBox(40);
	    labelBox.getChildren().addAll(nameLabel,frequencyOfMessagesLabel,
	    		goalBox, goalStartDate, goalEndDate,phoneNumberLabel);
	    labelBox.setAlignment(Pos.CENTER_RIGHT);
	    labelBox.setPadding(new Insets(308,0,0,0));
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
		Image play = null;
		try {
			play = new Image(new FileInputStream("forward.png"), 800, 800, true, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView playView = new ImageView(play);
		playView.setFitHeight(10);
		playView.setFitWidth(10);
		playView.setPreserveRatio(true);
	  	Button continueButton = new Button("Continue",playView);
	  	continueButton.setContentDisplay(ContentDisplay.RIGHT);
	  	continueButton.setStyle(IDLE);
	  	continueButton.setOnMouseEntered(e -> {
	  		continueButton.setStyle(HOVERED);
	  	});
	  	continueButton.setOnMouseExited(e -> {
	  		continueButton.setStyle(IDLE);
	  	});
	    HBox buttonHolder = new HBox(continueButton);
	    buttonHolder.setAlignment(Pos.CENTER);
	    VBox allUserInputContent = new VBox(40);
		allUserInputContent.getChildren().addAll(totalInputBox, buttonHolder);
		allUserInputContent.setAlignment(Pos.CENTER);
		allUserInputContent.setPadding(new Insets(135, 0, 0, 0));
		continueButton.setOnAction(e -> {
			try {
				Date startDate = java.sql.Date.valueOf(startDatePicker.getValue());
				Date endDate = java.sql.Date.valueOf(endDatePicker.getValue());
				String validPhoneNumber = phoneNumberInput.getText().replaceAll("[()\\s-]+", "");
				user.setName(nameInput.getText());
				user.setdailyFreq(frequencyComboBox.getValue());
				user.setGoal(goalInput.getText());
				user.setStartDate(startDate);
				user.setEndDate(endDate);
				user.setPhone("+1" + validPhoneNumber);
				// Add in null pointers for the remaining three elements.
				System.out.println(user.getPhone());
				if (user.getName() == null || user.getdailyFreq() == null || user.getPhone() == null
						||user.getStartDate() == null || user.getEndDate() == null || user.getGoal() == null
						||user.getPhone().length() != 12 || !validPhoneNumber.matches("^-?\\d+$")						
						) {
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
				errorBox.setTranslateY(830);
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
	
	/**
	 * Provides the text for the display on the info icon hover.
	 * @return Returns a String value to go into the tooltip.
	 */
	public String tooltipInfo() {
		String info = new String(
				"When you input your goal, try to focus on something specific. \n"
				+ "Instead of saying somethign like \"get fit\", try something like \n"
				+ "\"Get fit for Spring Break in two months.\". Having a more specific \n"
				+ "goal will make it easier for you to write more specific inspirational \n"
				+ "messages that will get to the core of what you want to achieve and then \n"
				+ "push you there."
				);
		return info;
	}
	
}