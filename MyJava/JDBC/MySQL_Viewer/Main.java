package MySQL_Viewer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private String title = "MySQL Viewer";
	private MainWindow root = new MainWindow(600,600);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Scene scene = new Scene(root,600,600);
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Login login = new Login();
		login.centerOnScreen();
	}
	
	public static void main(String args[]){
		launch(args);
	}
}
