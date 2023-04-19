/**
 * 
 */
package fr.carbonit.thetreasuremap.treasuremap.treasuremapimpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.carbonit.thetreasuremap.adventurer.Adventurer;
import fr.carbonit.thetreasuremap.adventurer.impl.AdventurerImpl;
import fr.carbonit.thetreasuremap.constant.TerrainType;
import fr.carbonit.thetreasuremap.iotreasuremapdata.impl.IOTreasureMapDataImpl;
import fr.carbonit.thetreasuremap.tile.Tile;
import fr.carbonit.thetreasuremap.tile.impl.TileImpl;
import fr.carbonit.thetreasuremap.treasuremap.TreasureMap;
import fr.carbonit.thetreasuremap.treasuremap.TreasureMapServices;

/**
 * @author jalavoine
 *
 */
@Service
public class TreasureMapImpl implements TreasureMapServices {
	
	private static final Logger LOGGER = LogManager.getLogger(TreasureMapImpl.class);
	private TreasureMap treasureMap;
	
	@Autowired
	AdventurerImpl adventurerImpl;
	
	@Autowired
	TileImpl tileImpl;
	
	@Autowired
	IOTreasureMapDataImpl ioTreasureMapDataImpl;
	
	
	/**
	 * @return the treasureMap
	 */
	public TreasureMap getTreasureMap() {
		return treasureMap;
	}

	/**
	 * @param treasureMap the treasureMap to set
	 */
	public void setTreasureMap(TreasureMap treasureMap) {
		this.treasureMap = treasureMap;
	}
	
	@Override
	public void init() {
		if(this.adventurerImpl==null) {
			adventurerImpl = new AdventurerImpl();
			LOGGER.info("Component " + adventurerImpl.getClass().getName() + " instancied" );
		}
		if(this.tileImpl==null) {
			tileImpl = new TileImpl();
			LOGGER.info("Component " + tileImpl.getClass().getName() + " instancied" );
		}
		if(this.ioTreasureMapDataImpl==null) {
			ioTreasureMapDataImpl = new IOTreasureMapDataImpl();
			LOGGER.info("Component " + ioTreasureMapDataImpl.getClass().getName() + " instancied" );
		}
		
		LOGGER.info("Component " + this.getClass().getCanonicalName() + " initialized" );
	}

	@Override
	public TreasureMap createTreasureMap(String inputFile) {
		
		List<String> inputDatas = ioTreasureMapDataImpl.readDataFromTextFile(inputFile);
		
		inputDatas.stream().forEach(line -> {
			
			if(!(line.startsWith("#"))) {
				String[] params = line.split(" - ");
				
				switch (String.valueOf(line.charAt(0))){
					case "C":
						treasureMap = new TreasureMap(params[0],Integer.parseInt(params[1]),Integer.parseInt(params[2]));
						this.fillDefaultTreasureMap(treasureMap);
						break;
					case "M":
						tileImpl.updateTile(
								this.getTile(Integer.parseInt(params[1]),Integer.parseInt(params[2])), params);
						break;
					case "T":
						tileImpl.updateTile(
								this.getTile(Integer.parseInt(params[1]),Integer.parseInt(params[2])), params);
						break;
					case "A":
						this.addAdventurer(adventurerImpl.createAdventurer(params));
						break;
					default:
						throw new IllegalArgumentException("Unknown arguments on line ");
				
				}
			}
		});
		return treasureMap;
	}

	@Override
	public void fillDefaultTreasureMap(TreasureMap treasureMap) {
		//filling map with default tiles
		for(int i=0;i<treasureMap.getWidth();i++) {
			for(int j=0;j<treasureMap.getHeight();j++) {
				treasureMap.getTiles().add(tileImpl.createDefaultTile(i, j));
			}
		}	
	}
	
	@Override
	public Tile getTile(int x, int y) {
		Tile aTile=null;
		for (Tile tile : treasureMap.getTiles()) {
			if (tile.getxAxe()==x && tile.getyAxe()==y ) {
				aTile = tile;
			}
		}
		return aTile;
	}
	
	@Override
	public void addAdventurer(Adventurer adventurer) {
		if(!(adventurer==null)) {
			treasureMap.getAdventurers().add(adventurer);
			LOGGER.info("adventurer :" + adventurer.getAdventurerName() + " add to adventurers list");
		} else
			throw new IllegalArgumentException("Adventurer in parameter is null");
	}

	@Override
	public List<String> buildOutputResult() {
		List <String> resultLines = new ArrayList<>();
		
		//Map information line 
		String lineC = "C - " + getTreasureMap().getWidth() + " - " + getTreasureMap().getHeight(); 
		resultLines.add(lineC);
		
		
		//Moutain information lines
		List <Tile> mountainTiles = getTreasureMap().getTiles()
				.stream()
				.filter(Objects::nonNull)
				.filter(t -> t.getTerrain().equals(TerrainType.MOUNTAIN))
				.collect(Collectors.toList());
		
		mountainTiles.stream().forEach(tileM -> {
			String lineM = "M - " + tileM.getxAxe() + " - " + tileM.getyAxe();
			resultLines.add(lineM);
		});
		
		
		//Treasure information lines
		List <Tile> treasureTiles = getTreasureMap().getTiles()
				.stream()
				.filter(Objects::nonNull)
				.filter(t -> t.getTreasureQuantity()>0)
				.collect(Collectors.toList());
		
		treasureTiles.stream().forEach(tileT -> {
			String lineT = "T - " + tileT.getxAxe() + " - " + tileT.getyAxe() + " - " + tileT.getTreasureQuantity();
			resultLines.add(lineT);
		});
		
		//Adventurers Information lines
		getTreasureMap().getAdventurers().stream().forEach((a) -> {
			String lineA = "A - " + a.getAdventurerName() + " - " + a.getxAxes() + " - " + a.getyAxes() + " - " + a.getOrientation() + " - " + a.getCollectedTreasure();
			resultLines.add(lineA);
		});
		
		return resultLines;
	}

	@Override
	public void sendResults(String outputFilePath, String outputFileName) {
		File outputFile = new File(outputFilePath);
		ioTreasureMapDataImpl.writeResultsOnTextFile(buildOutputResult(), outputFile, outputFileName);
		
	}
}
