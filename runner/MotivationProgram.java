package runner;
import java.io.FileInputStream;

import backend.SmsSender;
import backend.User;
import backend.ValueCalculators;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ui.HomeScreen;

/**
 * The program manages the run flow of the application. It 
 * handles running particular pages, and running them in the correct
 * order.
 * @author andrew.mcmanus
 *
 */
public class MotivationProgram extends Application {


  //@Override
  /**
   * This method provides a main stage for the application
   * and allows the alternation between pages on the same stage.
   * It handles the process flow of the application.
   */ 
  public void start(Stage primaryStage) {

        //create user and resultsViewer object
        HomeScreen introPage = new HomeScreen();
        introPage.start();
        //Thank you pop up    

    }
}
