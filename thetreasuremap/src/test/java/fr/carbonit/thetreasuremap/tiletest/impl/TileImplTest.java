/**
 * 
 */
package fr.carbonit.thetreasuremap.tiletest.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import fr.carbonit.thetreasuremap.constant.TerrainType;
import fr.carbonit.thetreasuremap.tile.Tile;
import fr.carbonit.thetreasuremap.tile.impl.TileImpl;

/**
 * class test for tiles
 * @author jalavoine
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class TileImplTest {

	private List<Tile> tiles = new ArrayList<>();
	private String[] mountainParams;
	private String[] treasureParams;
	
	@Autowired
	static TileImpl tileImpl;
	
	@BeforeAll
	void setUp() {
		tileImpl = new TileImpl();
		Tile tile1 = new Tile(0,1);
		tiles.add(tile1);
		Tile tile2 = new Tile(2,5);
		tiles.add(tile2);
		Tile tile3 = new Tile(4,3);
		tiles.add(tile3);
		mountainParams = new String[]{"MOUNTAIN","2","5"};
		treasureParams = new String[]{"PLAIN","4","3","2"};
	}
	@Test
	void createDefaultTileTest() {
		tileImpl.createDefaultTile(0, 1).equals(tiles.get(0));
	}
	
	
	@Test
	void updateTileToMountain() {
		String m = "Tile [terrain=MOUNTAIN, xAxe=2, yAxe=5, hasTreasure=false, treasureQuantity=0]";
		Tile mountainTile = tiles.get(1);
		tileImpl.updateTile(mountainTile, mountainParams);
		assertEquals(m, mountainTile.toString());
	}
	
	@Test
	void updateTileToTreasure() {
		String t = "Tile [terrain=PLAIN, xAxe=4, yAxe=3, hasTreasure=true, treasureQuantity=2]";
		Tile treasureTile = tiles.get(2);
		tileImpl.updateTile(treasureTile, treasureParams);
		assertEquals(t, treasureTile.toString());
	}
	
	@Test
	void getXAxesTest() {
		assertEquals(1, tileImpl.createDefaultTile(1, 0).getxAxe());		
	}
	
	@Test
	void getYAxesTest() {
		assertEquals(2, tileImpl.createDefaultTile(0, 2).getyAxe());		
	}
	
	@Test
	void getTerrainTypePlain() {
		assertEquals(TerrainType.PLAIN, tileImpl.createDefaultTile(0, 1).getTerrain());
	}
	
	@Test
	void getTreasureQuantity() {
		assertEquals(0, tileImpl.createDefaultTile(0, 2).getTreasureQuantity());		
	}
}
