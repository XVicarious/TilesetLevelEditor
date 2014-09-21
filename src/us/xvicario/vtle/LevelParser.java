package us.xvicario.vtle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by XVicarious on 9/20/2014.
 */
public class LevelParser {

    /**
     *
     * @param file The path to the file of the level
     * @param tileSize The number of bits to use as the tile size, 8 for 255 size tileset, 4 for a 15 size tileset, 2 for a size 3 tileset etc
     * @return The level in an array of bitset
     */
    public static BitSet[] parseLevel(Path file, int tileSize) {
        byte[] level;
        try {
            level = Files.readAllBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        System.out.println(level);
        // We want the map to stay a static size that it was.
        // Naturally, the number of tiles will be how long the byte array was over the number of bits used to represent
        // the tileset of the level
        BitSet[] levelSet = new BitSet[level.length/tileSize];
        for(int i = 0; i < levelSet.length-1; i++) {
            // Set how many bits the bitset can have
            levelSet[i] = new BitSet(4);
            // Easier access to which byte we are working in
            int levelByte = (int)Math.ceil(i / 2);
            if (Utilities.isEven(i)) {
                for (int j = 0; j < 4; j++) {
                    System.out.println("" + i + "," + j);
                    // set the bit of levelSet[i] to the corresponding bit
                    levelSet[i].set(j, (level[levelByte] & j) == 1);
                }
            } else {
                for (int j = 4; j < 9; j++) {
                    levelSet[i].set(j-3, (level[levelByte] & j) == 1);
                }
            }
        }
        return levelSet;
    }

}
