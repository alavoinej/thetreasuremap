/**
 * 
 */
package fr.carbonit.thetreasuremap.adventurer.impl;

import org.springframework.stereotype.Service;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;
import fr.carbonit.thetreasuremap.adventurer.AdventurerService;

/**
 * Bean service component for adventurer
 * @author jalavoine
 *
 */
@Service
public class AdventurerImpl implements AdventurerService {
	
	@Override
	public Adventurer createAdventurer(String[] adventurerParameters) {
		return new Adventurer(
				adventurerParameters[0], 
				Integer.parseInt(adventurerParameters[1]), 
				Integer.parseInt(adventurerParameters[2]), 
				adventurerParameters[3], 
				adventurerParameters[4]);
	}
	
}
