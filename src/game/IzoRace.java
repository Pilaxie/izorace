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

	public static IzoRace instance;
	
	public NInput in = new Input();
	public NCanvas canvas = new NCanvas(new Drawer());
	public NStateHandler stateHandler = new NStateHandler();
	NThread renderThread = new NThread("RENDER_THREAD", canvas);
	NThread updateThread = new NThread("UPDATE_THREAD", new Runnable() {
		public void run() {
			stateHandler.updateCurrentState();
		}
	});
	
	JFrame gameFrame = new JFrame("Izo race");
	
	public int getFPS() {
		return renderThread.getTicks();
	}
	
	public void init() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		stateHandler.addState("MENU_STATE", new Menu());
		stateHandler.addState("SETTINGS_STATE", new Settings());
		stateHandler.addState("GAME_STATE", new Game());
		
		stateHandler.setState("MENU_STATE");
		
		canvas.setSize(640, 480);
		//canvas.setSize(Settings.get("WIDTH"), Settings.get("HEIGHT"));
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
	
	public static void main(String[] args) {
		instance = new IzoRace();
		instance.init();
	}
	
}
