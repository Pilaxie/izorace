package game;

import java.awt.event.KeyEvent;

import nightingale.input.NInput;
import nightingale.input.NKey;
import nightingale.input.NMouse;

public class Input extends NInput{

	public static NMouse mouse = new NMouse();
	
	public Input() {
		setMouse(mouse);
	}
	
	public static NKey ESC_KEY   = new NKey();
	public static NKey LEFT      = new NKey();
	public static NKey RIGHT     = new NKey();
	public static NKey UP        = new NKey();
	public static NKey DOWN      = new NKey();
	public static NKey SPACE_KEY = new NKey();
	
	@Override
	public void toggleKey(int keyCode, boolean isPressed) {
		switch(keyCode) {
		case KeyEvent.VK_ESCAPE:
			ESC_KEY.toggle(isPressed);
			break;
		case KeyEvent.VK_A:
			LEFT.toggle(isPressed);
			break;
		case KeyEvent.VK_D:
			RIGHT.toggle(isPressed);
			break;
		}
	}

}
