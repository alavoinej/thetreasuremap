/**
 * 
 */
package fr.carbonit.thetreasuremap.adventurertest.impltest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;
import fr.carbonit.thetreasuremap.adventurer.impl.AdventurerImpl;

/**
 * class test for service component adventurerImpl
 * @author jalavoine
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class AdventurerImplTest {
	
	private Adventurer adventurer;
	private String[] params;
	
	@Autowired
	static AdventurerImpl adventurerImpl;
	
	@BeforeAll
	void setUp() {
		adventurerImpl = new AdventurerImpl();
		adventurer = new Adventurer("JohnDoe",1,2,"E","AADAGA");
		params = new String[]{"JohnDoe","1","2","E","AADAGA"};
	}
	@Test
	void createAdventurerTest() {
		adventurerImpl.createAdventurer(params).equals(adventurer);
	}
	
	
	@Test
	void getAdventurerNameTest() {
		assertEquals("JohnDoe", adventurerImpl.createAdventurer(params).getAdventurerName());		
	}
	
	@Test
	void getXAxesTest() {
		assertEquals(1, adventurerImpl.createAdventurer(params).getxAxes());		
	}
	
	@Test
	void getYAxesTest() {
		assertEquals(2, adventurerImpl.createAdventurer(params).getyAxes());		
	}
	
	@Test
	void getOrientationTest() {
		assertEquals("E", adventurerImpl.createAdventurer(params).getOrientation());		
	}
	
	@Test
	void getMovementSequenceTest() {
		assertEquals("AADAGA", adventurerImpl.createAdventurer(params).getMovementSequence());		
	}
	
	@Test
	void getCollectedTreasureTest() {
		assertEquals(0, adventurerImpl.createAdventurer(params).getCollectedTreasure());		
	}
}
