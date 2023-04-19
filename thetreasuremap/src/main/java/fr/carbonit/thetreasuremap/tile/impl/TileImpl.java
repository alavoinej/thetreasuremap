/**
 * 
 */
package fr.carbonit.thetreasuremap.tile.impl;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import fr.carbonit.thetreasuremap.constant.TerrainType;
import fr.carbonit.thetreasuremap.tile.Tile;
import fr.carbonit.thetreasuremap.tile.TileService;

/**
 * bean service component for tile
 * @author jalavoine
 *
 */
@Service
public class TileImpl implements TileService {
	
	@Override
	public Tile createDefaultTile(int x, int y) {
		return new Tile(x,y);
	}
	
	@Override
	public void updateTile(Tile tile, String[] tileParameter) {
		//we don't update the terrain if it comes from treasure line param
		if(!(tileParameter[0].equals("T"))) {
			tile.setTerrain(getTileTerrainFromString(tileParameter[0]));
		}
		
		tile.setxAxe(Integer.parseInt(tileParameter[1]));
		tile.setyAxe(Integer.parseInt(tileParameter[2]));
		if(tileParameter.length>3) {
			tile.setTreasureQuantity(Integer.parseInt(tileParameter[3]));
		}
	}

	@Override
	public TerrainType getTileTerrainFromString(String stringTerrain) {
		return Stream.of(TerrainType.values())
				.filter(terrainType -> terrainType.toString().startsWith(stringTerrain))
				.findFirst()
				.orElse(null);
	}	
	

	@Override
	public String setTileTerrainToString(TerrainType terrainType) {
		String stringTerrain ="";
		if(terrainType.toString().equals("MOUNTAIN")) {
			stringTerrain = "M";
		}else if(terrainType.toString().equals("PLAIN")) {
			stringTerrain= "P";
		}
		return stringTerrain;
	}
}
