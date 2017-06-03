package SnakeGame;

import java.util.ArrayList;
import static org.lwjgl.opengl.GL11.*;

public class Snake {

	private ArrayList<Part> parts = new ArrayList<Part>(1);
	private Direction dir = Direction.Right;
	private int Scale;
	
	public Snake(int Scale){
		parts.add(new Part(0,0));
		this.Scale = Scale;
	}
	
	public void setDirection(Direction dir){
		this.dir = dir;
	}
	
	public void step(){
		
		for(int i=1;i<parts.size();i++){
			if(parts.get(0).x == parts.get(i).x && parts.get(0).y == parts.get(i).y){
				for(int j=parts.size()-1;j>i;--j){
					parts.remove(j);
				}
			}
		}
		
		for(int i=parts.size()-1;i>0;--i){
			parts.get(i).x =  parts.get(i-1).x;
			parts.get(i).y =  parts.get(i-1).y;
		}
		
		if(dir==Direction.Top) parts.get(0).y+=1;
		if(dir==Direction.Left) parts.get(0).x-=1;
		if(dir==Direction.Right) parts.get(0).x+=1;
		if(dir==Direction.Bottom) parts.get(0).y-=1;
	}
	public boolean increase(Apple apple){
		if(apple.getN() < parts.get(0).x || 0 > parts.get(0).x) {
			parts.clear();
			parts.add(new Part(0,0));
			dir = Direction.Right;
		}
		else if(apple.getM() < parts.get(0).y || 0 > parts.get(0).y){
			parts.clear();
			parts.add(new Part(0,0));
			dir = Direction.Right;
		}
		if(parts.get(0).x == apple.x && parts.get(0).y == apple.y){
			parts.add(new Part(apple.x,apple.y));
			apple.spawn();
			return true;
		}
		return false;
	}
	
	public void draw(){
		glColor3f(0.0f,0.0f,1.0f);
		for(int i=0;i<parts.size();i++){
			glRectf(parts.get(i).x*Scale, parts.get(i).y*Scale,(parts.get(i).x+1)*Scale, (parts.get(i).y+1)*Scale);
		}
	}
}
