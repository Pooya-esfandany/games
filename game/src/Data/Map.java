package Data;

import Data.build.Base;
import Data.build.Build;
import Data.build.Camp;
import Data.build.Defence;

import java.util.ArrayList;

public class Map {
    ArrayList<Build>builds=new ArrayList<>();

    {
        Add(new Base(8, 7, 1000, "Base"));
        Add(new Camp(7, 7, "Camp", 200));
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.safeZone[i][j] = 0;
            }
        }
        Add(new Base(8, 7, 1000, "Base"));
        Add(new Camp(7, 7, "Camp", 200));
        Add(new Defence(8, 8, "cannon", 400, "Defence", 400, 2000, 100));
    }
    int[][] safeZone=new int[15][15];
    public boolean Add(Build build) {
        if (safeZone[build.X][build.Y] == 0) {
            safeZone[build.X][build.Y] = 1;
            builds.add(build);
            return true;
        }
        return false;
    }
}
