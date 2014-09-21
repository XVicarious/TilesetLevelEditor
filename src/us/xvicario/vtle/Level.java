package us.xvicario.vtle;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by XVicarious on 9/19/2014.
 */
public class Level {

    public BitSet[] levelData;

    public Level(BitSet[] level) {
        levelData = level;
    }

    public BitSet getTileAt(int x, int y, int mapHeight, int mapWidth) throws InvalidArgumentException {
        // Handles problems.
        if (x > mapWidth) {
            throw new InvalidArgumentException(new String[]{"Map not wide enough to have that x-value!"});
        } else if (y > mapHeight) {
            throw new InvalidArgumentException(new String[]{"Map not tall enough to have that y-value!"});
        }
        int tileIndex = (y * mapWidth) + x;
        return levelData[tileIndex];
    }

}
