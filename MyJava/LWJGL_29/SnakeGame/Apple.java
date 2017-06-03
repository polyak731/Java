package SnakeGame;

import java.util.Random;
import static org.lwjgl.opengl.GL11.*;
public class Apple {

	public int x;
	public int y;
	
	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public int getM() {
		return M;
	}

	public void setM(int m) {
		M = m;
	}

	private int N=30;
	private int M=20;
	
	private int Scale = 25;
	
	public Apple(int N, int M, int Scale){
		this.N = N;
		this.M = M;
		this.Scale = Scale;
	}
	
	public void draw(){
		glColor3f(1.0f,0.0f,0.0f);
		glRectf(x*Scale,y*Scale,(x+1)*Scale,(y+1)*Scale);
		
	}
	
	public void spawn(){
		x = new Random().nextInt(N);
		y = new Random().nextInt(M);
	}
}
