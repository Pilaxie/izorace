package game;

import java.awt.Toolkit;

import javax.swing.JFrame;

import game.state.Game;
import game.state.Menu;
import game.state.Settings;
import nightingale.graph.NCanvas;
import nightingale.input.NInput;
import nightingale.state.NStateHandler;
import nightingale.thread.NThread;

public class IzoRace {
	
	//public static IzoRace instance;
	
	public static NInput in = new Input();
	public static NCanvas canvas = new NCanvas(new Drawer());
	public static Toolkit kit = Toolkit.getDefaultToolkit();
	public static NStateHandler stateHandler = new NStateHandler();
	static NThread renderThread = new NThread("RENDER_THREAD", canvas);
	static NThread updateThread = new NThread("UPDATE_THREAD", new Runnable() {
		public void run() {
			stateHandler.updateCurrentState();
		}
	});
	
	static JFrame gameFrame = new JFrame("Izo race");
	
	
	public static void frameRefresh() {
		gameFrame.pack();
		gameFrame.setLocation(kit.getScreenSize().width /2 - gameFrame.getWidth()/2, 
	  			  kit.getScreenSize().height/2 - gameFrame.getHeight()/2);
	}
	
	public static int getFPS() {
		return renderThread.getTicks();
	}
	
	public static int getUPS() {
		return updateThread.getTicks();
	}
	
	public static void init() {		
		Settings.load();
		
		stateHandler.addState("MENU_STATE", new Menu());
		stateHandler.addState("SETTINGS_STATE", new Settings());
		stateHandler.addState("GAME_STATE", new Game());
		
		stateHandler.setState("MENU_STATE");
		
		canvas.setSize(Settings.get("WIDTH"), Settings.get("HEIGHT"));
		canvas.addKeyListener(in);
		canvas.addMouseListener(in);
		canvas.addMouseMotionListener(in);
		
		gameFrame.add(canvas);
		gameFrame.pack();
		gameFrame.setResizable(false);
		gameFrame.setFocusable(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLocation(kit.getScreenSize().width /2 - gameFrame.getWidth()/2, 
				  			  kit.getScreenSize().height/2 - gameFrame.getHeight()/2);
		gameFrame.setVisible(true);
		
		renderThread.maxRate = 60;
		updateThread.maxRate = 60;
		renderThread.start();
		updateThread.start();
	}

	public static void setFullScreen(int value) {
		//TODO
		
	}

	public static void setVolume(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
