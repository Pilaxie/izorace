package game.obj.map;

import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import nightingale.game.NGameObject;

public class MapLoader {
	private static Scanner scan;
	public static RaceMap load(String name) {
		FileReader fr;
		String path = "data/"+name+".map";		
		int[][] tiles;	
		ArrayList<String> matrix = new ArrayList<String>();
		ArrayList<String> cp = new ArrayList<String>();
		List<NGameObject> checkpoints = new ArrayList<NGameObject>();	
		boolean isTile = false;
		boolean isCheckPoint = false;
		
		try {
			fr = new FileReader(path);
			scan = new Scanner(fr);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				if (line.equals("[MAP]")) {
					isTile = true;
					continue;
				}		
				if(line.equals("[CHECKPOINTS]")) {
					isCheckPoint = true;
					isTile = false;
					continue;
				}			
				if (isTile)
					matrix.add(line);	
				if (isCheckPoint)
					cp.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			scan.close();
		}
		tiles = getTiles(matrix);	
		checkpoints = getCheckPoints(cp);
		RaceMap map = new RaceMap(tiles, checkpoints);
		
		return map;
	}
	
	private static int[][] getTiles(ArrayList<String> lines) {	
		int[][] tempArr;
		int columns = lines.get(0).replaceAll("[0-9]", "").length();
		tempArr = new int[lines.size()][columns];
		int i = 0;
		
		for(String line : lines) {
			String[] row = line.split("[.]");
			for (int j = 0; j < row.length; j++) {
				tempArr[i][j] = Integer.parseInt(row[j]);
			}
			i++;		
		}
		return tempArr;
	}
	
	private static List<NGameObject> getCheckPoints(ArrayList<String> lines) {
		List<NGameObject> tempList = new ArrayList<NGameObject>();
		for(String line: lines) {
			String[] row = line.split("[.]");
			tempList.add(new NGameObject(Float.parseFloat(row[0]),Float.parseFloat(row[1]),Float.parseFloat(row[2]),Float.parseFloat(row[3])));
		}
		return tempList;
	}
}
