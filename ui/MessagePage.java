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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		Scene messageScene = new Scene(scroll,StageX,StageY);
		mainStage.setScene(messageScene);
		mainStage.setTitle("Motivate");
		// Create and format a title
		Text title = new Text("Motivate");
		title.setFont(Font.font("Arial Rounded MT", FontWeight.BOLD, FontPosture.ITALIC, 30));
		// Create an HBox for the title
		HBox titleBox = new HBox(title);
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(30, 0, 0, 0));
		/*
		 * ADDING INTRODUCTION TEXT
		 */
		Text directionsText = new Text(
				
				"The box below will allow you to create and save motivational "
				+ "messages for your future self. Simply type in a message and "
				+ "click \"Save and Continue\" to write another. When you are done "
				+ "writing messages for yourself, click submit. \n" + 
				"\n" + 
				"Because your goal is XX days long and you would like to receive "
				+ "messages, at a frequency of XXXX, you can input up to YY unique "
				+ "messages. However, if you'd like to submit fewer than that, that "
				+ "is okay. Just click submit when you are done. \n" + 
				"\n" + 
				"Please note that if you do not submit the recommended number of "
				+ "messages, some messages will be repeated when you receive texts "
				+ "from the app. You must submit at least one message."
				);
		directionsText.setTextAlignment(TextAlignment.CENTER);
		directionsText.setWrappingWidth(450);
		HBox introTextBox = new HBox(directionsText);
		introTextBox.setAlignment(Pos.TOP_CENTER);
		introTextBox.setPadding(new Insets(100,0,0,0));
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
		infoButton.setOnAction(e -> messageInspiration());
		HBox infoBox = new HBox();
		infoBox.getChildren().add(infoButton);
		infoBox.setAlignment(Pos.CENTER);		
		HBox preMessageBox = new HBox();
		preMessageBox.getChildren().addAll(preMessageText,infoView);
		preMessageBox.setAlignment(Pos.BOTTOM_CENTER);	
		/**
		 * SET FIELD FOR ADDING MESSAGES
		 */
		TextArea messageHolder = new TextArea();
		messageHolder.setMaxHeight(100);
		messageHolder.setMaxWidth(150);
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
		HBox messageListTextBox = new HBox();
		messageListTextBox.getChildren().add(messageListText);
		messageListTextBox.setAlignment(Pos.CENTER);
		/**
		 * CREATING COLUMNS OF MESSAGES
		 */
		VBox leftMessageColumn = new VBox();
		leftMessageColumn.setAlignment(Pos.CENTER_LEFT);
		VBox centerMessageColumn = new VBox();
		centerMessageColumn.setAlignment(Pos.CENTER);
		VBox rightMessageColumn = new VBox();
		rightMessageColumn.setAlignment(Pos.CENTER_RIGHT);
		HBox messageColumnsBox = new HBox();
		messageColumnsBox.getChildren().addAll(leftMessageColumn,centerMessageColumn,
				rightMessageColumn);
		messageColumnsBox.setAlignment(Pos.CENTER);
		
		saveAndContinue.setOnAction(e -> {
			
			try {
				
				
				if(messageHolder.getText() == null) {
					throw new NullPointerException();
				}
				
			}
			catch(NullPointerException e1) {
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
		 * FINAL STAGE - ADDING ITEMS TO OVERALL BOXES AND SHOWING THE SCREEN
		 */
		VBox allMessageContents = new VBox(20);
		allMessageContents.getChildren().addAll(preMessageBox,messageHolderBox,buttonBox,
				messageListTextBox);
		allMessageContents.setAlignment(Pos.BOTTOM_CENTER);
		
		rootNode.getChildren().addAll(titleBox,introTextBox,
				allMessageContents,messageColumnsBox);
		
		
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

}
