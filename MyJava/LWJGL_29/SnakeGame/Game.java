package SnakeGame;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;


public class Game 
{
	private int N=30;
	private int M=20;
	private int Scale=25;
	
	private int width = Scale*N;
	private int height = Scale*M;
	private Snake snake = new Snake(Scale);
	private int speed=3;
	private Apple apple = new Apple(N,M,Scale);
	
	private void start(){
		apple.spawn();
	}
	
	private void gameLoop(){
		start();
		while(!Display.isCloseRequested())
		{
			
			Display.sync(speed);
			glClear(GL_COLOR_BUFFER_BIT);
			//glLoadIdentity();
			snake.step();
			snake.draw();
			apple.draw();
			if(snake.increase(apple)) speed++;
			drawField();
			Display.update();
		}
	}
	
	private synchronized void input(){
		while(true)
			try {
				Thread.sleep(16);
				while (Keyboard.next()) {
			        if (Keyboard.getEventKeyState()) {
			            if (Keyboard.getEventKey() == Keyboard.KEY_A) {
			            snake.setDirection(Direction.Left);
			        }
			        if (Keyboard.getEventKey() == Keyboard.KEY_S) {
			        	snake.setDirection(Direction.Bottom);
			        }
			        if (Keyboard.getEventKey() == Keyboard.KEY_D) {
			        	snake.setDirection(Direction.Right);
			        }
			        if (Keyboard.getEventKey() == Keyboard.KEY_W) {
			        	snake.setDirection(Direction.Top);
			        }
			        } 
			    }
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(IllegalStateException e){
				e.printStackTrace();
			}
	}
	
	private void drawField(){
		glColor3f(0.0f,1.0f,0.0f);
		glBegin(GL_LINES);
			for(int i=0;i<width;i+=Scale){
				glVertex2f(i,0);
				glVertex2f(i,height);
			}
			for(int i=0;i<height;i+=Scale){
				glVertex2f(0,i);
				glVertex2f(width,i);
			}
		glEnd();
	}
	
	private void initGL(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,Display.getWidth(),0,Display.getHeight(),0,200);
		glMatrixMode(GL_MODELVIEW);
	
		glClearColor(0,0,0,1);
		
		glDisable(GL_DEPTH_TEST);
	}
	
	private void cleanUp(){
		Display.destroy();
	}
	
	private void initDisplay(){
		try
		{
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
		}
		catch (LWJGLException ex)
		{
		
		}
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.initDisplay();
		game.initGL();
		Thread input = new Thread(()->{ 
				game.input();
		});
		input.start();
		game.gameLoop();
		game.cleanUp();
		System.exit(0);
	}
}