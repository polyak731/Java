package calc;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class KeyBoard extends HBox{
	
	private ArrayList<Button> numbers;
	private TilePane nums;
	private VBox attribs;
	private FlowPane head;
	private Display display;
	private Parser parser;
	
	public KeyBoard(Display display){
		super();
		this.display = display;
		init();
	}
	
	private void init(){
		numbers = new ArrayList<>(12);
		nums = new TilePane();
		nums.setPrefWidth(180);
		nums.setPrefHeight(60);
		attribs = new VBox();
		head = new FlowPane();
		head.setPrefHeight(60);
		head.setPrefWidth(120);
		
		numbers.add(buildButton("1",60,20));
		numbers.add(buildButton("2",60,20));
		numbers.add(buildButton("3",60,20));
		
		numbers.add(buildButton("4",60,20));
		numbers.add(buildButton("5",60,20));
		numbers.add(buildButton("6",60,20));
		
		numbers.add(buildButton("7",60,20));
		numbers.add(buildButton("8",60,20));
		numbers.add(buildButton("9",60,20));
		
		numbers.add(buildButton("0",60,20));
		numbers.add(buildButton(".",60,20));
		numbers.add(buildButton("^",60,20));
		
		nums.getChildren().addAll(numbers);
		
		head.getChildren().add(buildButton("+",60,20));
		head.getChildren().add(buildButton("-",60,20));
		
		head.getChildren().add(buildButton("/",60,20));
		head.getChildren().add(buildButton("*",60,20));
		
		head.getChildren().add(buildButton("=",120,20));
		
		head.getChildren().add(buildButton("(",60,20));
		head.getChildren().add(buildButton(")",60,20));
		
		head.getChildren().add(buildButton("<-",60,20));
		head.getChildren().add(buildButton("C",60,20));
		attribs.getChildren().addAll(head);
		
		parser = new Parser(new StringBuilder(""));
		
		getChildren().addAll(nums,attribs);
	}
	
	private Button buildButton(String text, double width, double height){
		Button button = new Button(text);
		button.setPrefWidth(width);
		button.setPrefHeight(height);
		button.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler->{
			switch(button.getText()){
			case "=":
				try{
					parser.setFormule(display.getArgs());
					display.clear();
					display.add(parser.getResult());
					}
					catch(NumberFormatException ex){
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("Incorrect expression");
						alert.setTitle("Sorry...");
						alert.setContentText(ex.getMessage());
						alert.show();
					}
				break;
			case "<-":
				display.dec();
				break;
			case "C": 
				display.clear();
				break;
				default:
					display.add(button.getText());
					break;
			}
		});
		return button;
	}
}
