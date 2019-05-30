package game;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Setting{
	public static final String SETTINGS_PATH = "settings.txt";
	
	private HashMap<String, Integer> settings = new HashMap<String, Integer>();

	public void load(){
		try{
			FileReader fr = new FileReader("SETTINGS_PATH");
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

	public void set(String name, int value){
		if (settings.containsKey(name))
			settings.replace(name, value);
	}

	public int get(String name){
		if(!settings.containsKey(name) )
			return 0;
		return settings.get(name);
	}

	public void save(){
		try{
			String line;
			FileWriter fw = new FileWriter("SETTINGS_PATH");
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
}