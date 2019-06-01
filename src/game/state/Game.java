package game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.Input;
import game.IzoRace;
import game.obj.Hitbox;
import game.obj.map.MapDrawer;
import game.obj.map.RaceMap;
import game.state.listener.GameActionListener;
import nightingale.game.map.NMapTile;
import nightingale.state.NState;
import nightingale.ui.NActionListener;
import nightingale.ui.NButton;
import nightingale.ui.NLabel;
import nightingale.ui.NUIGroup;

public class Game implements NState, MapDrawer{
	protected NActionListener listener = new GameActionListener(this);

	protected NUIGroup pauseMenu = new NUIGroup();
	
	protected RaceMap currentMap;
	
	public boolean paused = false;
	
	private List<Hitbox> hitbox = new ArrayList<Hitbox>();
	
	public Game() {
		pauseMenu.addElement("PAUSE_LABEL", new NLabel("PAUSED", 340, 250, 100, 30));
		pauseMenu.addElement("RESUME", new NButton(345, 300, 90, 40));
		pauseMenu.addElement("TO MENU", new NButton(345, 400, 90, 40));
		pauseMenu.setActionListener(listener);
	}
	
	@Override
	public void install() {
		Random random = new Random();
		for(int i=0;i<20;i++)
			hitbox.add(new Hitbox(30+random.nextInt(500), 30+random.nextInt(400), 30+random.nextInt(40), 30+random.nextInt(40)));
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
		
		for(Hitbox hit : hitbox) 
			hit.draw(g);
		
		if(paused) 
			pauseMenu.draw(g, g2d, at);
	}

	private float angle = 0;
	
	@Override
	public void update() {
		if(paused) {
			pauseMenu.perform(IzoRace.in);
		}
		
		for(Hitbox hit : hitbox) {
			hit.update();
			for(Hitbox hit2 : hitbox)
				if(hit != hit2)
					if(hit.collideWith(hit2))
						hit.colide = true;
		}
			
		//INPUT
		if(Input.ESC_KEY.isClicked()) paused = !paused;
		
		if(Input.LEFT.isPressed()) angle-=1f;
		else if(Input.RIGHT.isPressed()) angle+=1f;;
		for(Hitbox hit : hitbox) 
			hit.setAngle(angle);
		angle = hitbox.get(0).getAngle();
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