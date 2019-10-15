package com.mygdx.game;

public class Map {

	private byte[][] map;

	public Map(int ARENA_WIDTH, int ARENA_HEIGHT) {
		map = new byte[ARENA_WIDTH][ARENA_HEIGHT];

	}

	byte getPosMap(int x, int y) {
		return map[y][x];
	}

	void setPosMap(int x, int y, byte value) {
		map[y][x] = value;
	}
}
