/**
 * 
 */
package fr.carbonit.thetreasuremap.tiletest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.carbonit.thetreasuremap.constant.TerrainType;
import fr.carbonit.thetreasuremap.tile.Tile;

/**
 * class test for tile object
 * 
 * @author jalavoine
 *
 */
public class TileTest {
	
	
	@Test
	void testToString() {
		String expectedString = "Tile [terrain=PLAIN, xAxe=2, yAxe=3, hasTreasure=false, treasureQuantity=0]";
		Tile tile = new Tile(2,3);
		assertEquals(expectedString, tile.toString());
	}
	
	@Test
	void testMountainToString() {
		String expectedString = "Tile [terrain=MOUNTAIN, xAxe=2, yAxe=3, hasTreasure=false, treasureQuantity=0]";
		Tile tile = new Tile(2,3);
		tile.setTerrain(TerrainType.MOUNTAIN);
		System.out.println(tile.toString());
		assertEquals(expectedString, tile.toString());
	}
	
	@Test
	void TestWithTreasureToString() {
		String expectedString = "Tile [terrain=PLAIN, xAxe=2, yAxe=3, hasTreasure=true, treasureQuantity=3]";
		Tile tile = new Tile(2,3);
		tile.setTreasureQuantity(3);
		System.out.println(tile.toString());
		assertEquals(expectedString, tile.toString());
	}
}
