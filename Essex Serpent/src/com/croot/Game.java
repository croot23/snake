package com.croot;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Game {
	
	public static void main(String[] args) {
		 Game();
	}
	
	public static void Game() {
		JFrame frame = new JFrame("Essex Serpent");
		frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 400));
        JPanel snake = new Snake();
		snake.setFocusable(true);
		snake.requestFocusInWindow();
        frame.add(snake);
        frame.pack();
        frame.setVisible(true);
	}

}
