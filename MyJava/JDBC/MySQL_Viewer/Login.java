package MySQL_Viewer;

import java.sql.SQLException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Login extends Stage{
	
	private String login;
	private String password;
	private TilePane root = new TilePane();
	private Scene scene;
	private Text textLogin = new Text();
	private Text textPassword = new Text();
	private TextField editLogin = new TextField();
	private TextField editPassword = new TextField();
	private VBox main = new VBox();
	private HBox log = new HBox();
	private HBox pas = new HBox();
	private HBox btns = new HBox();
	private Button accept = new Button("Accept");
	private Button cancel = new Button("Cancel");
	JDBCConnection connection;
	
	public Login(){
		super();
		
		buildLogin();
		
		show();
	}
	
	public void buildLogin(){
		
		initListeners();
		
		textLogin.setText("Login:      ");
		textPassword.setText("Password:");
		textLogin.setTextAlignment(TextAlignment.RIGHT);
		textPassword.setTextAlignment(TextAlignment.RIGHT);
			
		log.getChildren().addAll(textLogin,editLogin);
		pas.getChildren().addAll(textPassword,editPassword);
		
		btns.getChildren().addAll(accept,cancel);
		
		main.getChildren().addAll(log,pas,btns);
		
		root.getChildren().add(main);
		StackPane.setAlignment(main, Pos.CENTER_RIGHT);
		scene = new Scene(root,400,200);
		setTitle("Login");
		setResizable(false);
		setScene(scene);
	}
	
	public void initListeners(){
		accept.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler->{
			try {
				connection = new JDBCConnection(editLogin.getText(),editPassword.getText());
				close();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				Alert message = new Alert(AlertType.INFORMATION);
				message.setHeaderText("Exception");
				message.setContentText(e.getMessage());
				message.show();
			}
		});
		
		cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler->{
			close();
		});
	}
}
