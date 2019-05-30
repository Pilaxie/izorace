package game;

import java.awt.Toolkit;

import javax.swing.JFrame;

import nightingale.graph.NCanvas;
import nightingale.thread.NThread;

public class IzoRace {

	public static IzoRace game = new IzoRace();
	
	NCanvas canvas = new NCanvas(new Drawer());
	NThread renderThread = new NThread("RENDER_THREAD", canvas);
	
	JFrame gameFrame = new JFrame("Izo race");
	
	public int getFPS() {
		return renderThread.getTicks();
	}
	
	public void init() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		canvas.setSize(640, 480);
		
		gameFrame.add(canvas);
		gameFrame.pack();
		gameFrame.setResizable(false);
		gameFrame.setFocusable(true);
		gameFrame.setLocation(kit.getScreenSize().width /2 - gameFrame.getWidth()/2, 
				  			  kit.getScreenSize().height/2 - gameFrame.getHeight()/2);
		gameFrame.setVisible(true);
		
		renderThread.maxRate = 60;
		renderThread.start();
	}
	
	public static void main(String[] args) {
		game.init();
	}
	
}
