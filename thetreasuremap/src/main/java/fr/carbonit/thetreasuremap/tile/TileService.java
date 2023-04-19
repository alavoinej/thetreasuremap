/**
 * 
 */
package fr.carbonit.thetreasuremap.tile;

import fr.carbonit.thetreasuremap.constant.TerrainType;

/**
 * Interface services for tiles
 * @author jalavoine
 *
 */
public interface TileService {
	Tile createDefaultTile(int x, int y);
	void updateTile(Tile tile, String[] tileParameter);
	TerrainType getTileTerrainFromString(String stringTerrain);
	String setTileTerrainToString(TerrainType terrainType);
}
