package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primarystage) throws IOException
	{
		try
		{
			
			Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
			Scene scene = new Scene(root);
			
//			primarystage.getIcons().add(new Image("file:logo.png"));
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primarystage.getIcons().add(new Image(Main.class.getResourceAsStream("logo.png")));
			primarystage.setTitle("FlipFX");
			primarystage.setScene(scene);
			primarystage.show();
		} catch(Exception e){	
			e.printStackTrace();
		}
		
	}
	
	public static void main (String[] args){
		
		launch(args);
		
	}
}
