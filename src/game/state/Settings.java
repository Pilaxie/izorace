package game.state;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import game.IzoRace;
import game.state.listener.SettingsActionListener;
import nightingale.state.NState;
import nightingale.ui.NActionListener;
import nightingale.ui.NButton;
import nightingale.ui.NUIGroup;

public class Settings implements NState{
	//public static final String SETTINGS_PATH = "./settings.settings";
	public static final String SETTINGS_PATH = "settings.settings";
	
	private static HashMap<String, Integer> settings = new HashMap<String, Integer>();

	public static void setDefaultSettings() {
		settings.clear();
		settings.put("WIDTH", 800);
		settings.put("HEIGHT", 600);
		//settings.put("FULLSCREEN", 0);
		//settings.put("VOLUME", 100);
		//settings.put("ANTI-ALIASING", 0);
	}
	
	public static void load(){
		File settingsFile = new File(SETTINGS_PATH);
		try {
			if( settingsFile.createNewFile() ) {
				System.out.println("kavo");
				setDefaultSettings();
				save();
			}
		} catch (IOException e) { e.printStackTrace(); }
		try{
			FileReader fr = new FileReader(settingsFile);
			Scanner scan = new Scanner (fr);
			
			String line;
			String name;
			int key;
			
			while(scan.hasNextLine()){
			//while((line = scan.nextLine())!=null) {
				line = scan.nextLine();
				name = line.substring(0, line.indexOf(':'));
				key = Integer.parseInt(line.substring(line.indexOf(':') + 2));
				settings.put(name, key);				 	
			}
			fr.close();
			scan.close();
		}catch(Exception e){}	
	}

	public static void set(String name, int value){
		if (settings.containsKey(name))
			settings.replace(name, value);
	}

	public static int get(String name){
		if(!settings.containsKey(name) )
			return 0;
		return settings.get(name);
	}

	public static void save(){
		try{
			String line;
			FileWriter fw = new FileWriter(SETTINGS_PATH);
			BufferedWriter bf = new BufferedWriter(fw);
			
			for(String i : settings.keySet()){
				line = "" + i + ": " + settings.get(i);
				bf.write(line);
				bf.newLine();
			}
			
			bf.flush();
			bf.close();
			fw.close();
		}catch(Exception e){}	
	}
	
	// State
	protected NActionListener listener = new SettingsActionListener(this);
	
	NUIGroup uigroup = new NUIGroup();
	{
		uigroup.addElement("DEFAULT_SETTINGS", new NButton(100, 400, 100, 60));
		// Set listener to all elements in group(MUST BE LAST LINE)
		uigroup.setActionListener(listener);
	}
	
	@Override
	public void draw(Graphics g, Graphics2D g2d, AffineTransform at) {
		uigroup.draw(g, g2d, at);
	}

	@Override
	public void update() {
		uigroup.perform(IzoRace.in);
	}
}