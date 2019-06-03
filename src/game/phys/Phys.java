package game.phys;

import game.obj.Car;
import game.obj.map.RaceMap;
import game.obj.map.RaceMapTile;
import game.state.Game;

public class Phys {

	public static void mapCollision(Car car, RaceMap map) {
		Game.collide = false;
		/*
		for(int i= (int)(car.getHitbox().getY() / map.getTile(0, 0).getHeight());
				i < (int)((car.getHitbox().getY()+car.getHitbox().getHeight())/map.getTile(0, 0).getHeight()); i++) {
			for(int j= (int)(car.getHitbox().getX() / map.getTile(0, 0).getWidth());
					j < (int)( (car.getHitbox().getX()+car.getHitbox().getWidth())/map.getTile(0, 0).getWidth() ); j++) {
		*/
		for(int i=0;i<map.getTiles().length;i++) {
			for(int j=0;j<map.getTiles()[0].length;j++) {
				if(map.getTile(i, j).getType()!=0 &&
						car.getHitbox().collideWith(((RaceMapTile)map.getTile(i, j)).getHitbox())) {
					Game.collide = true;
					car.move(car.getAngle()+180);
				}	
			}
		}
	}
	
}
