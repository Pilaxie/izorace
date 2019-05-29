import java.io.*;
import java.util.*;

public class Setting{
		
	private HashMap<String, Integer> settings = new HashMap<String, Integer>();
	public static void main(String[] args){
		Setting settings = new Setting();
		settings.load();
		settings.set("WIDTH", 1280);
		settings.save();
	}

	public void load(){
		String line;
		String name;
		int key;
		try{
			FileReader fr = new FileReader("Settings.txt");
			Scanner scan = new Scanner (fr);
			while(scan.hasNextLine()){
				line = scan.nextLine();
				name = line.substring(0, line.indexOf(':'));
				key = Integer.parseInt(line.substring(line.indexOf(':') + 2));
				settings.put(name, new Integer(key));				 	
			}
			fr.close();
			scan.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}	
	}

	public void set(String name, int value){
		if (settings.containsKey(name)){
			settings.replace(name, value);
		}
	}

	public int get(String name){
		if(!settings.containsKey(name) )
			return 0;
		return settings.get(name);
	}

	public void save(){
		try{
			String line;
			FileWriter fw = new FileWriter("Settings.txt");
			BufferedWriter bf = new BufferedWriter(fw);
			
			for(String i : settings.keySet()){
				line = "" + i + ": " + settings.get(i);
				System.out.println(line);
				bf.write(line);
				bf.newLine();
			}
			
			bf.flush();
			bf.close();
			fw.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}