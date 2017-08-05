package com.croot;

import java.awt.Color;
import java.awt.Graphics;

public class Body {
	
private int x, y;
	
	public Body(int x, int y) {
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

}
