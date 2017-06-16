package calc;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Display extends StackPane{

	private Label args;
	
	public Display(){
		super();
		init();
	}
	
	public void add(String arg){
		args.setText(args.getText() + arg);
	}
	
	public void dec(){
		if(args.getText().length()>0) args.setText(args.getText().substring(0, args.getText().length()-1));
	}
	
	public String getArgs(){
		return args.getText();
	}
	
	public void clear(){
		args.setText("");
	}
	
	private void init(){
		args = new Label("");
		args.setFont(new Font(15));
		setPrefHeight(100);
		getChildren().add(args);
	}
}
