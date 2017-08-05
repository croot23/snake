package com.croot;

import java.util.ArrayList;

public class CheckCollision {
	
	static Boolean collision;
	
	public static Boolean CheckCollision(ArrayList<Body> snake, Body body) {
		collision = false;
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getX() == body.getX() && snake.get(i).getY() == body.getY()) 
				collision = true;
		}
		return collision;
	}

}
