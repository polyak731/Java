package MySQL_Viewer;

import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainWindow extends Pane{
	
	private MainMenu menu;
	private ListView<String> bases = new ListView<>();
	private VBox root = new VBox();
	private HBox left = new HBox();
	
	public MainWindow(double width, double height) {
		super();
		super.setHeight(height);
		super.setWidth(width);
		buildWindow();
	}
	
	private void buildWindow(){
		menu = new MainMenu();
		
		bases.getItems().add("Base 1");
		left.getChildren().add(bases);
		root.getChildren().add(menu);
		root.getChildren().add(bases);
		getChildren().add(root);
	}
}
