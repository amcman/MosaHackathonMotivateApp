package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import backend.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MessagePage {
	//Stage width
	private int StageX = 700;
	//Stage height
	private int StageY = 1000;
	//Set the currentColumn variable for message display
	static int currentColumn = 1;
	//Set message number in display below textarea
	static int currentNumber = 1;
	/**
	 * This method handles displaying the message entry page of the program.
	 * This page will be responsible for collecting motivational messages from 
	 * the user as well as displaying the messages as they continue to enter 
	 * more.
	 * @param primaryStage The stage that is used for the home screen so that 
	 * there is no change of window when the user clicks the "continue" button
	 * on the home screen.
	 * @param user The user class that the home screen stored all the user info 
	 * in. This will be used after this class to send messages to the user.
	 * @return
	 */
	public Scene showMessageEntryPage(Stage primaryStage, User user) {
		/**
		 * INITIAL PAGE SETUP
		 */
		Stage mainStage = primaryStage;
		StackPane rootNode = new StackPane();
		ScrollPane scroll = new ScrollPane(rootNode);
		//make that node fill entire width
		scroll.setFitToWidth(true);
		//set background white
		scroll.setStyle("-fx-background: white");
		//Create Scene and link it with ScrollPane can have only one node
		//If you omit the width and height, the scene will be sized 
		//automatically based on the size of the elements contained
		Scene messageScene = new Scene(scroll,StageX, StageY);
		mainStage.setScene(messageScene);
		mainStage.setTitle("Motivate");
		// Create and format a title
		Text title = new Text("Motivate");
		title.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 30));
		title.setFill(Color.web("#FF826E"));		/**
		 * ADDING MESSAGE ICON
		 */
		// Adding info image
		Image texting = null;
		try {
			texting = new Image(new FileInputStream("textMessageIcon.png"), 800, 800, true, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView textMessageIcon = new ImageView(texting);
		textMessageIcon.setFitHeight(75);
		textMessageIcon.setFitWidth(75);
		textMessageIcon.setPreserveRatio(true);
		VBox titleBox = new VBox(3);
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(0,0,60,0));
		titleBox.getChildren().addAll(textMessageIcon,title);
		/*
		 * ADDING INTRODUCTION TEXT
		 */
		Text directionsText = new Text(
				
				"The box below will allow you to create and save motivational "
				+ "messages for your future self. Simply type in a message and "
				+ "click \"Save and Continue\" to write another. When you are done "
				+ "writing messages for yourself, click submit. \n" + 
				"\n" + 
				"Because your goal is \"" + "INPUT GOAL DAYS HERE" + "\" days long and you would like to receive "
				+ "messages, at a frequency of \"" + user.getdailyFreq() + "\", you can input up "
				+ "to " + "INPUT NUMBER OF MESSAGES" +  " unique "
				+ "messages. However, if you'd like to submit fewer than that, that "
				+ "is okay. Just click submit when you are done. \n" + 
				"\n" + 
				"Please note that if you do not submit the recommended number of "
				+ "messages, some messages will be repeated when you receive texts "
				+ "from the app. You must submit at least one message.\n"
				+ "\n"
				);
		directionsText.setTextAlignment(TextAlignment.CENTER);
		directionsText.setWrappingWidth(450);
		HBox introTextBox = new HBox(directionsText);
		introTextBox.setAlignment(Pos.TOP_CENTER);
		/**
		 * CREATING COLOR BOX
		 */
		Rectangle inputRect = new Rectangle(520, 430);
		inputRect.setFill(Color.rgb(212, 255, 215));
		inputRect.setStroke(Color.rgb(98, 245, 108));
		inputRect.setStrokeWidth(1);
		inputRect.setArcHeight(35.0);
		inputRect.setArcWidth(25.0);
		//Putting input box within a child vbox
		VBox inputRectangle = new VBox();
		inputRectangle.getChildren().add(inputRect);
		inputRectangle.setAlignment(Pos.CENTER);
		inputRectangle.setMaxHeight(460);
		inputRectangle.setPadding(new Insets(120,0,50,0));
		/**
		 * CREATE INTRO TEXT ABOVE MESSAGE AREA
		 */
		Text preMessageText = new Text(
				"Something that motivates me to reach my goal:"
				);
		preMessageText.setWrappingWidth(150);
		preMessageText.setTextAlignment(TextAlignment.CENTER);
		//Adding info image
		Image image = null;
		try {
			image = new Image(new FileInputStream("info.png"), 800, 800, true, true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageView infoView = new ImageView(image);
		infoView.setFitHeight(15);
		infoView.setFitWidth(15);
		infoView.setPreserveRatio(true);
		Button infoButton = new Button("",infoView);
		infoButton.setStyle("-fx-background-color: transparent");
		HBox preMessageBox = new HBox(5);
		preMessageBox.getChildren().addAll(preMessageText,infoButton);
		preMessageBox.setAlignment(Pos.BOTTOM_CENTER);
		preMessageBox.setPadding(new Insets(0, 0, 0, 20));
		infoButton.setOnAction(e -> {
			System.out.println("TEST");
		});
		HBox textIconBox = new HBox(5);
		textIconBox.getChildren().addAll(preMessageText, infoButton);
		textIconBox.setAlignment(Pos.TOP_CENTER);
		textIconBox.setPadding(new Insets(0, 0, 0, 20));
		/**
		 * SET FIELD FOR ADDING MESSAGES
		 */
		TextArea messageHolder = new TextArea();
		messageHolder.setMaxHeight(100);
		messageHolder.setMaxWidth(200);
		messageHolder.setWrapText(true);
		HBox messageHolderBox = new HBox();
		messageHolderBox.getChildren().addAll(messageHolder);
		messageHolderBox.setAlignment(Pos.CENTER);
		/**
		 * SAVE AND SUBMIT BUTTON BOXES
		 */
		Button saveAndContinue = new Button("Save");
		saveAndContinue.setWrapText(true);
		saveAndContinue.setMaxWidth(80);
		Button submit = new Button("Submit");
		HBox buttonBox = new HBox(15);
		buttonBox.getChildren().addAll(saveAndContinue,submit);
		buttonBox.setAlignment(Pos.CENTER);
		/**
		 * SET INTRO TEXT ABOVE PAST MESSAGE COLUMNS
		 */
		Text messageListText = new Text(
				"Hover over the info icons to see one of your previous messages."
				+ "If you want to see some messages more often than others, click "
				+ "the info icon, and copy and paste that message text into the box above "
				+ "to create a duplicate."
				);
		messageListText.setTextAlignment(TextAlignment.CENTER);
		messageListText.setWrappingWidth(450);
		messageListText.setFill(Color.web("FFFFFF"));
		HBox messageListTextBox = new HBox();
		messageListTextBox.getChildren().add(messageListText);
		messageListTextBox.setAlignment(Pos.CENTER);
		messageListTextBox.setPadding(new Insets(15,0,0,0));
		/**
		 * CREATING AN EMPTY ERROR MESSAGE
		 */
		Text errorMessage = new Text("Please enter some text before moving forward.");
		errorMessage.setFont(Font.font("Veranda", 12));
		errorMessage.setFill(Color.web("#D4FFD7"));
		HBox errorBox = new HBox();
		errorBox.setMinWidth(300);
		errorBox.getChildren().add(errorMessage);
		errorBox.setAlignment(Pos.CENTER);
		errorBox.setMaxHeight(20);
		/**
		 * ADDING ALL INTERACTIVE ELEMENTS TO A VBOX
		 */
		VBox allMessageContents = new VBox(10);
		allMessageContents.getChildren().addAll(preMessageBox,messageHolderBox,buttonBox,
				errorBox, messageListTextBox);
		allMessageContents.setAlignment(Pos.CENTER);
		/**
		 * ADDING ALL ELEMENTS TO FINAL VBOX
		 */
		VBox wholePageVBox = new VBox();
		wholePageVBox.getChildren().addAll(titleBox,introTextBox,
				allMessageContents);
		wholePageVBox.setPadding(new Insets(0,0,0,0));
		/**
		 * CREATING COLUMNS OF MESSAGES
		 */
		VBox leftMessageColumn = new VBox(5);
		leftMessageColumn.setAlignment(Pos.CENTER_LEFT);
		VBox centerMessageColumn = new VBox(5);
		centerMessageColumn.setAlignment(Pos.CENTER);
		VBox rightMessageColumn = new VBox(5);
		rightMessageColumn.setAlignment(Pos.CENTER_RIGHT);
		HBox messageColumnsBox = new HBox(100);
		messageColumnsBox.getChildren().addAll(leftMessageColumn,centerMessageColumn,
				rightMessageColumn);
		messageColumnsBox.setTranslateX(100);
		messageColumnsBox.setTranslateY(350);
		/**
		 * SETTING A BACK BUTTTON
		 */
		Button back = new Button("Save");
		back.setWrapText(true);
		back.setMaxWidth(80);
		HBox backButton = new HBox(back);
		backButton.setAlignment(Pos.BOTTOM_CENTER);
		/**
		 * GIVING THE BUTTONS ACTION
		 */
		saveAndContinue.setOnAction(e -> {
			try {
				if(messageHolder.getText().equals("")) {
					throw new NullPointerException();
				}
				//Add the message to the arrayList.
				//Clear the text area
				messageListText.setFill(Color.web("#000000"));
				if(currentColumn == 1) {
					leftMessageColumn.getChildren().add(messageDisplayer(messageHolder.getText()));
					currentColumn = 2;
				}
				else if(currentColumn == 2) {
					centerMessageColumn.getChildren().add(messageDisplayer(messageHolder.getText()));
					currentColumn = 3;
				}
				else {
					rightMessageColumn.getChildren().add(messageDisplayer(messageHolder.getText()));
					currentColumn = 1;
				}
				user.setMsg(messageHolder.getText());
				errorMessage.setFill(Color.web("#D4FFD7"));
				messageHolder.clear();
			}
			catch(NullPointerException e1) {
				errorMessage.setFill(Color.web("#FF1000"));
			}
		});
		submit.setOnAction(e -> {
			try {
				if(messageHolder.getText().equals("")) {
					throw new NullPointerException();
				}
			}
			catch(NullPointerException e2) {
				errorMessage.setFill(Color.web("#FF1000"));
			}
		});
		/**
		 * FINAL STAGE - ADDING ITEMS TO OVERALL BOXES AND SHOWING THE SCREEN
		 */
		rootNode.getChildren().addAll(inputRectangle,messageColumnsBox,wholePageVBox);
		mainStage.show();
		return messageScene;
	}
	/**
	 * Handles displaying the popup when the info button is clicked next to the
	 * motivation text field header.
	 */
	private void messageInspiration() {
	   System.out.println("Worked");
	}
	/**
	 * Create a Text object that takes on the value of the message inputted.
	 * @param indexNumber The message number that is being inputted
	 * @return Returns the string Message # where # represents the number the message is.
	 */
	public HBox messageDisplayer(String messageToDisplay) {
		
		Text message = new Text("Message " + currentNumber);
		message.setFont(Font.font("Veranda", FontWeight.BOLD, 14));
		message.setFill(Color.web("41A641"));
		// messageIcon.png
		Image iconImage = null;
		try {
			iconImage = new Image(new FileInputStream("messageIcon.png"), 800, 800, true, true);
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		ImageView messageIcon = new ImageView(iconImage);
		messageIcon.setFitHeight(10);
		messageIcon.setFitWidth(10);
		messageIcon.setPreserveRatio(true);
		Button messageButton = new Button("", messageIcon);
		messageButton.setStyle("-fx-background-color: transparent");
		Tooltip buttonTool = new Tooltip(messageToDisplay);
		buttonTool.prefWidth(150);
		buttonTool.setWrapText(true);
		messageButton.setTooltip(buttonTool);
		messageButton.setAlignment(Pos.TOP_CENTER);
		HBox messageInfoBox = new HBox(2);
		messageInfoBox.getChildren().addAll(message,messageButton);
		currentNumber++;
		return messageInfoBox;
	}
}
