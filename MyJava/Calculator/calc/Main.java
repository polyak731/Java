package calc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Scene scene;
	private VBox root;
	private final double sceneWidth = 300;
	private final double sceneHeight = 300;
	private Display display;
	private KeyBoard keyboard;
	
	private void buildScene(){
		display = new Display();
		keyboard = new KeyBoard(display);
		root = new VBox();
		root.getChildren().addAll(display,keyboard);
		scene = new Scene(root, sceneWidth, sceneHeight);
	}

	
	public static void main(String args[]){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		buildScene();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Calculator");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
