package us.xvicario.vtle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/**
 * Created by XVicarious on 9/19/2014.
 */
public class Level {

    public ArrayList<BitSet> levelData;

    public Level() {
        levelData = new ArrayList<BitSet>();
    }

    public Level(ArrayList<BitSet> level) {
        levelData = level;
    }

    public Level(byte[] level) {
        levelData = new ArrayList<BitSet>();
    }

}
