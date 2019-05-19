package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

	final static int HEIGHT = 547;
	final static int WiDTH = 391;


	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/sample/View.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Timur Kasenov COM-18");
			primaryStage.setMinHeight(HEIGHT);
			primaryStage.setMinWidth(WiDTH);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}