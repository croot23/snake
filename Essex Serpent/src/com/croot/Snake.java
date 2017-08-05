package com.croot;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class Snake extends JPanel implements Runnable {

	private int x;
	private int y;
	Boolean running = true;
	Thread thread;
	private ArrayList<Body> snakeBody = new ArrayList<Body>();
	int size = 15;
	private boolean right = true;
	private boolean left = false;
	private boolean up = false;
	private boolean down = false;
	private Key key;
	private Mouse mouse = new Mouse(70,70);
	Random rand = new Random();

	public Snake() {
		key = new Key();
		addKeyListener(key);
		y = 50;
		for (int i = 0; i < size; i++) {
			x = i * 10;
			snakeBody.add(new Body(x, y));
		}
		start();
	}
	
	private void createNewMouse() {
		int mouseX = rand.nextInt(19);
		mouseX = (mouseX==0) ? 1: mouseX;
		int mouseY = rand.nextInt(19);
		mouseY = (mouseY==0) ? 1: mouseY;
		mouse = new Mouse(mouseX*20,mouseY*20);
	}

	public void updateSnake() throws InterruptedException {
		if (right)
			x = x + 10;
		if (left)
			x = x - 10;
		if (up)
			y = y - 10;
		if (down)
			y = y + 10;
		checkEdge(x, y);
		Body newBody = new Body(x, y);
		if (CheckCollision.CheckCollision(snakeBody, newBody) == true) {
			running = false;
		}
		if (mouse.mouseEaten(snakeBody, mouse) == true) {
			createNewMouse();
			size++;
		}
		snakeBody.add(newBody);
		if (snakeBody.size() > size)
		snakeBody.remove(0);
		}

	public void checkEdge(int x, int y) {
		if (x >= 400) {
			this.x = 0;
		}
		if (y >= 400) {
			this.y = 0;
		}
		if (x <= 0) {
			this.x = 400;
		}
		if (y <= 0) {
			this.y = 400;
		}
	}

	public void start() {
		running = true;
		thread = new Thread(this, "Game Loop");
		thread.start();
	}

	public void run() {
		while (running) {
			try {
				Thread.sleep(100);
				if (running)
					updateSnake();
					repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		
		super.paint(g);
		for (int i = 0; i < snakeBody.size(); i++) {
			snakeBody.get(i).draw(g);
		}
		mouse.draw(g);
	}
	
	public void setRunning(Boolean running) {
		this.running = running;
	}

	private class Key implements KeyListener {

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT && !left) {
				up = false;
				down = false;
				right = true;
			}

			if (key == KeyEvent.VK_LEFT && !right) {
				up = false;
				down = false;
				left = true;
			}

			if (key == KeyEvent.VK_UP && !down) {
				up = true;
				left = false;
				right = false;
			}

			if (key == KeyEvent.VK_DOWN && !up) {
				down = true;
				left = false;
				right = false;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}

}
