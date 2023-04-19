package fr.carbonit.thetreasuremap.treasuremap;

import java.util.List;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;
import fr.carbonit.thetreasuremap.tile.Tile;

/**
 * Interface TreasureMapService
 * @author jalavoine
 *
 */
public interface TreasureMapServices {
	void init();
	TreasureMap createTreasureMap(String inputFile);
	void fillDefaultTreasureMap(TreasureMap treasureMap);
	Tile getTile(int x, int y);
	void addAdventurer(Adventurer adventurer);
	List <String> buildOutputResult();
	void sendResults(String outputFilePath, String outputFileName);

	//TODO
//	void simulateTreasureMap(); 
//	boolean isTileAccessible(Tile t, Adventurer a);
//	boolean isWithinBounds();
//	<?> getAdventurerNextMove(Adventurer a);
//	boolean collectTreasure(Tile t, Adventurer a);
	

}
