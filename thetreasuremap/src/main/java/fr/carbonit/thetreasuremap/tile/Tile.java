/**
 * 
 */
package fr.carbonit.thetreasuremap.tile;

import fr.carbonit.thetreasuremap.constant.TerrainType;

/**
 * tile composing the map 
 * @author jalavoine
 *
 */
public class Tile {
	private TerrainType terrain; //define if tile is mountain or plain
	private int xAxe; // horizontal position of the tile
	private int yAxe; //vertical position of the tile
	private boolean hasTreasure; //is one or more treasure present in the tile
	private int treasureQuantity; //quantity of treasure in the tile

	/**
	 * @param terrain
	 * @param xAxe
	 * @param yAxe
	 * @param treasureQuantity
	 */
	public Tile(int xAxe, int yAxe) {
		super();
		this.terrain = TerrainType.PLAIN;
		this.xAxe = xAxe;
		this.yAxe = yAxe;
		this.treasureQuantity = 0;
	}

	/**
	 * @return the terrain
	 */
	public TerrainType getTerrain() {
		return terrain;
	}

	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(TerrainType terrain) {
		this.terrain = terrain;
	}

	/**
	 * @return the xAxe
	 */
	public int getxAxe() {
		return xAxe;
	}

	/**
	 * @param xAxe the xAxe to set
	 */
	public void setxAxe(int xAxe) {
		this.xAxe = xAxe;
	}

	/**
	 * @return the yAxe
	 */
	public int getyAxe() {
		return yAxe;
	}

	/**
	 * @param yAxe the yAxe to set
	 */
	public void setyAxe(int yAxe) {
		this.yAxe = yAxe;
	}

	/**
	 */
	public void hasTreasure() {
		this.hasTreasure = !(this.treasureQuantity>0)?false:true;
	}
	
	/**
	 * @return the treasureQuantity
	 */
	public int getTreasureQuantity() {
		return treasureQuantity;
	}

	/**
	 * @param treasureQuantity the treasureQuantity to set
	 */
	public void setTreasureQuantity(int treasureQuantity) {
		this.treasureQuantity = treasureQuantity;
		this.hasTreasure();
	}

	@Override
	public String toString() {
		return "Tile [terrain=" + terrain + ", xAxe=" + xAxe + ", yAxe=" + yAxe + ", hasTreasure=" + hasTreasure
				+ ", treasureQuantity=" + treasureQuantity + "]";
	}
	
	
}
