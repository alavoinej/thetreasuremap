/**
 * 
 */
package fr.carbonit.thetreasuremap.treasuremap;

import java.util.ArrayList;
import java.util.List;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;
import fr.carbonit.thetreasuremap.tile.Tile;

/**
 * @author jalavoine
 *
 */
public class TreasureMap {
	private String treasureMapName; //the treasure map name
	private int width; // horizontal treasure map dimension
	private int height; // vertical treasure map dimension 
	private List <Adventurer> adventurers;//adventurers list
	private List <Tile> tiles; // tiles composing the map
	/**
	 * @param treasureMapName
	 * @param width
	 * @param height
	 * @param adventurers
	 * @param tiles
	 */
	public TreasureMap(String treasureMapName, int width, int height) {
		super();
		this.treasureMapName = treasureMapName;
		this.width = width;
		this.height = height;
		this.adventurers = new ArrayList<>();
		this.tiles = new ArrayList<>();
	}
	/**
	 * @return the treasureMapName
	 */
	public String getTreasureMapName() {
		return treasureMapName;
	}
	/**
	 * @param treasureMapName the treasureMapName to set
	 */
	public void setTreasureMapName(String treasureMapName) {
		this.treasureMapName = treasureMapName;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the adventurers
	 */
	public List<Adventurer> getAdventurers() {
		return adventurers;
	}
	/**
	 * @param adventurers the adventurers to set
	 */
	public void setAdventurers(List<Adventurer> adventurers) {
		this.adventurers = adventurers;
	}
	/**
	 * @return the tiles
	 */
	public List<Tile> getTiles() {
		return tiles;
	}
	/**
	 * @param tiles the tiles to set
	 */
	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}
	
	
	
	
}
