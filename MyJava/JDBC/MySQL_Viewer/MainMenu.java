package MySQL_Viewer;

import java.util.ArrayList;

import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;

public class MainMenu extends MenuBar{

	private ArrayList<Menu> titles = new ArrayList<>();
	private ArrayList<MenuItem> file = new ArrayList<>();
	private ArrayList<MenuItem> data = new ArrayList<>();
	private ArrayList<MenuItem> window = new ArrayList<>();
	private ArrayList<MenuItem> help = new ArrayList<>();
	
	public MainMenu() {
		super();	
		buildMenu();
	}

	public MainMenu(Menu... menus) {
		super(menus);
		buildMenu();
	}

	private void buildMenu(){
		titles.add(new Menu("File"));
		titles.add(new Menu("Data"));
		titles.add(new Menu("Window"));
		titles.add(new Menu("Help"));
		
		file.add(new MenuItem("Chose database"));
		file.add(new MenuItem("New relation"));
		file.add(new MenuItem("New table"));
		
		data.add(new MenuItem("Tables"));
		data.add(new MenuItem("Schema"));
		
		titles.get(0).getItems().addAll(file);
		titles.get(1).getItems().addAll(data);
		
		getMenus().addAll(titles);
	}
}
