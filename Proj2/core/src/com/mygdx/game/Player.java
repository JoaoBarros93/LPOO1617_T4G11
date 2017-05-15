package com.mygdx.game;

public class Player {
	boolean alive;
	int direction;
	int x;
	int y;
	int tailColor;
	
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getTailColor() {
		return tailColor;
	}
	public void setTailColor(int tailColor) {
		this.tailColor = tailColor;
	}
	
	public enum SpriteDirection {
		DOWN, LEFT, RIGHT, UP
	}
	
	public boolean isBot(){
		return false;
	}
	

	
}
