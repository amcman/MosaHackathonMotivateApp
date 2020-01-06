package ui;

import backend.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessagePage {
	
	private int stageX = 700;
	//Stage height
	private int stageY = 1000;
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
		Scene messageScene = new Scene(scroll, stageX, stageY);
		mainStage.setScene(messageScene);
		mainStage.setTitle("Motivate");
		// Create and format a title
		Text title = new Text("Motivate");
		title.setFont(Font.font("Arial Rounded MT", FontWeight.BOLD, FontPosture.ITALIC, 30));
		// Create an HBox for the title
		HBox titleBox = new HBox(title);
		titleBox.setAlignment(Pos.TOP_CENTER);
		titleBox.setPadding(new Insets(145, 0, 0, 0));
		
		rootNode.getChildren().addAll(titleBox);
		
		
		mainStage.show();
		
		return messageScene;
		
	}

}
