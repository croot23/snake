package com.croot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Mouse {
	
private int x, y;
private Boolean eaten;
	
	public Mouse(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x,y, 10, 10);
	}
	
	public Boolean mouseEaten(ArrayList<Body> snake, Mouse mouse) {
		eaten = false;
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getX() == mouse.getX() && snake.get(i).getY() == mouse.getY()) 
				eaten = true;
		}
		return eaten;
	}

}
