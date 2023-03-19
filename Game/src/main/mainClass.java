package main;

import java.util.Timer;
import java.util.TimerTask;

import Levels.Maps;
import entitys.Player;
import entitys.entity;

public class mainClass {
	public static mainMenu menu;
	public static Game game;
	public static void main(String[] args) {
		menu = new mainMenu();
		mainClass.game = new Game(Maps.level1);	
		game.GameWindow.setVisible(false);
	}
}
