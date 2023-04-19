/**
 * 
 */
package fr.carbonit.thetreasuremap.adventurer;

import fr.carbonit.thetreasuremap.constant.Orientation;

/**
 * The adventurer hunting treasure on the map
 * @author jalavoine
 *
 */
public class Adventurer {
	private String adventurerName; //adventurer adventurerName
	private int xAxes; //horizontal position
	private int yAxes; //vertical position
	private Orientation orientation; //orientation is the direction in which adventurer points to
	private String movementSequence; //sequence of movements the player will try to do
	private int collectedTreasure; //treasure collected by the adventurer
	
	/**
	 * @param adventurerName
	 * @param xAxes
	 * @param yAxes
	 * @param orientation
	 * @param movementSequence
	 * @param collectedTreasure
	 */
	public Adventurer(String adventurerName, int xAxes, int yAxes, String orientation, String movementSequence) {
		super();
		this.adventurerName = adventurerName;
		this.xAxes = xAxes;
		this.yAxes = yAxes;
		this.orientation = setOrientation(orientation);
		this.movementSequence = movementSequence;
		this.collectedTreasure = 0;
	}
	/**
	 * @return the adventurerName
	 */
	public String getAdventurerName() {
		return adventurerName;
	}
	/**
	 * @param adventurerName the adventurerName to set
	 */
	public void setAdventurerName(String adventurerName) {
		this.adventurerName = adventurerName;
	}
	/**
	 * @return the xAxes
	 */
	public int getxAxes() {
		return xAxes;
	}
	/**
	 * @param xAxes the xAxes to set
	 */
	public void setxAxes(int xAxes) {
		this.xAxes = xAxes;
	}
	/**
	 * @return the yAxes
	 */
	public int getyAxes() {
		return yAxes;
	}
	/**
	 * @param yAxes the yAxes to set
	 */
	public void setyAxes(int yAxes) {
		this.yAxes = yAxes;
	}
	/**
	 * @return the orientation
	 */
	public String getOrientation() {
		String orientation="";
		if(this.orientation.equals(Orientation.NORTH)) {
			orientation = "N";
		}
		if(this.orientation.equals(Orientation.EAST)) {
			orientation = "E";
		}
		if(this.orientation.equals(Orientation.SOUTH)) {
			orientation = "S";
		}
		if(this.orientation.equals(Orientation.WEST)) {
			orientation = "O";
		}
		return orientation;
	}
	/**
	 * @param orientation the orientation to set
	 */
	public Orientation setOrientation(String orientation) {
		switch (orientation) {
		case "N":
			this.orientation = Orientation.NORTH;
			break;
		case "E":
			this.orientation = Orientation.EAST;
			break;
		case "S":
			this.orientation = Orientation.SOUTH;
			break;
		case "O":
			this.orientation = Orientation.WEST;
			break;
		default:
			throw new IllegalArgumentException("Unknown Orientation pass in parameter");
		}
		return null; 
	}
	/**
	 * @return the movementSequence
	 */
	public String getMovementSequence() {
		return movementSequence;
	}
	/**
	 * @param movementSequence the movementSequence to set
	 */
	public void setMovementSequence(String movementSequence) {
		this.movementSequence = movementSequence;
	}
	/**
	 * @return the collectedTreasure
	 */
	public int getCollectedTreasure() {
		return collectedTreasure;
	}
	/**
	 * @param collectedTreasure the collectedTreasure to set
	 */
	public void setCollectedTreasure(int collectedTreasure) {
		this.collectedTreasure = collectedTreasure;
	}
	@Override
	public String toString() {
		return "Adventurer [adventurerName=" + adventurerName + ", xAxes=" + xAxes + ", yAxes=" + yAxes + ", orientation=" + getOrientation()
				+ ", movementSequence=" + movementSequence + ", collectedTreasure=" + collectedTreasure + "]";
	}
	
	
	
	
	
	
}
