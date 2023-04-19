/**
 * 
 */
package fr.carbonit.thetreasuremap.adventurertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;

/**
 * class test for Adventurer object
 * @author jalavoine
 *
 */
public class AdventurerTest {
	
	
	@Test
	void testToString() {
		String expectedString = "Adventurer [adventurerName=aName, xAxes=1, yAxes=2, orientation=N, movementSequence=ADGAGAD, collectedTreasure=0]";
		Adventurer adventurer1 = new Adventurer("aName",1,2,"N","ADGAGAD");
		assertEquals(expectedString, adventurer1.toString());
	}
}
