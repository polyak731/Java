package manager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	private Pane root;
	private Scene scene;
	private final double sceneWidth = 600;
	private final double sceneHeight = 600;
	
	private void buildScene(){
		root = new Pane();
		scene = new Scene(root,sceneWidth,sceneHeight);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		buildScene();
		primaryStage.setScene(scene);
		primaryStage.setTitle("File manager");
		primaryStage.show();
	}
	
	public static void main(String args[]){
		launch(args);
	}
}
