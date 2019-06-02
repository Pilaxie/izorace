package game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import game.Input;
import game.IzoRace;
import game.obj.Car;
import game.obj.Cars;
import game.obj.map.MapDrawer;
import game.obj.map.RaceMap;
import game.state.listener.GameActionListener;
import nightingale.game.map.NMapTile;
import nightingale.state.NState;
import nightingale.ui.NActionListener;
import nightingale.ui.NButton;
import nightingale.ui.NLabel;
import nightingale.ui.NUIGroup;
import nightingale.util.NCamera;

public class Game implements NState, MapDrawer{
	protected NActionListener listener = new GameActionListener(this);
	protected NCamera cam = new NCamera();

	protected NUIGroup pauseMenu = new NUIGroup();
	
	protected RaceMap currentMap;
	
	public Car car = new Car(Cars.Hatch, 250, 250);
	
	public boolean paused = false;
	
	public Game() {
		pauseMenu.addElement("PAUSE_LABEL", new NLabel("PAUSED", 340, 250, 100, 30));
		pauseMenu.addElement("RESUME", new NButton(345, 300, 90, 40));
		pauseMenu.addElement("TO MENU", new NButton(345, 400, 90, 40));
		pauseMenu.setActionListener(listener);
	}
	
	@Override
	public void install() {
		int[][] types = new int[][] {
			{0,0,1,1,1,0},
			{0,1,1,0,1,1},
			{1,1,0,0,1,1},
			{1,1,0,1,1,0}
		};
		currentMap = new RaceMap(types, null);
	}
	
	@Override
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at) {
		currentMap.draw(this, g, g2d, at);
		car.draw(g, g2d, at, cam);
		
		if(paused) 
			pauseMenu.draw(g, g2d, at);
	}

	
	@Override
	public void update() {
		if(paused) {
			pauseMenu.perform(IzoRace.in);
		}
		
		car.update();
		
		//INPUT
		if(Input.ESC_KEY.isClicked()) paused = !paused;
		if(Input.LEFT.isPressed()) car.turnLeft();
		else if(Input.RIGHT.isPressed()) car.turnRight();
		if(Input.UP.isPressed()) car.Gas();
	}
	
	@Override
	public void drawTile(NMapTile tile, Graphics g, Graphics2D g2d, AffineTransform at) {
		switch(tile.getType()) {
		case 1:
			g.setColor(Color.MAGENTA);
			g.drawRect((int)tile.getX(), (int)tile.getY(), (int)tile.getWidth(), (int)tile.getHeight());
			break;
		}
	}

}