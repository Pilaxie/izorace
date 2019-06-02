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
import game.obj.map.MapLoader;
import game.obj.map.RaceMap;
import game.obj.map.RaceMapTile;
import game.phys.Phys;
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
		currentMap = MapLoader.load("testmap");
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
		Phys.mapCollision(car.getHitbox(), this.currentMap);
		
		//INPUT
		if(Input.ESC_KEY.isClicked()) paused = !paused;
		if(Input.LEFT.isPressed()) car.turnLeft();
		else if(Input.RIGHT.isPressed()) car.turnRight();
		if(Input.UP.isPressed()) car.Gas();
	}
	
	@Override
	public void drawTile(NMapTile tile, Graphics g, Graphics2D g2d, AffineTransform at) {
		switch(tile.getType()) {
		case 3:
		case 4:
		case 2:
			g.setColor(Color.MAGENTA);
			try {
				((RaceMapTile)tile).getHitbox().draw(g);
			}catch(NullPointerException e) {}
			break;
		}
	}
}