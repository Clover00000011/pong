package pong;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	Ball ball;
	
	Ball(int x, int y, int width, int height){
		super(x, y, width, height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0) {
			randomXDirection --;
			setXDirection(randomXDirection * initialSpeed);
		}
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0) {
			randomYDirection --;
			setYDirection(randomYDirection * initialSpeed);
		}
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
//OWN CODE
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			random = new Random();
			setYDirection(initialSpeed);
			setXDirection(-initialSpeed);
			move();
		}
		if(e.getKeyCode()== KeyEvent.VK_SHIFT) {
			stillBall();
		}
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			setYDirection(0);
			setXDirection(0);
			move();
		}
	}
	public void stillBall() {
	xVelocity = 0;
	yVelocity = 0;
	}
}