/**
 * 
 */
package fr.carbonit.thetreasuremap.treasuremaptest.impltest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;
import fr.carbonit.thetreasuremap.tile.Tile;
import fr.carbonit.thetreasuremap.treasuremap.treasuremapimpl.TreasureMapImpl;

/**
 * test class for Treasure Map Impl
 * @author jalavoine
 *
 */
public class TreasureMapImplTest {
	
	@Autowired
	TreasureMapImpl treasureMapImpl;
	
	@BeforeAll
	void setup(){};
	
	@Test
	void testCreateTreasureMap(){};
	
	@Test
	void testFillDefaultTreasureMap(){};
	
	@Test
	void testGetTile(){};
	
	@Test
	void testAddAdventurer(){};
	
	@Test
	void testGetAdventurer(){};
	
	@Test
	void testSimulateTreasureMap(){};
	
//	@Test
//	void TestSimulateTreasureMap();
//	
//	@Test
//	boolean TestIsTileAccessible(Tile t, Adventurer a);
//	
//	@Test
//	boolean TestIsWithinBounds();
//	
//	@Test
//	<?> TestGetAdventurerNextMove(Adventurer a);
//	
//	@Test
//	boolean TestGetCollectTreasure(Tile t, Adventurer a);
	
	@Test
	void testBuildResult(){};
	
	@Test
	void testSendResults(){};
	
	
}
