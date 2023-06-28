package Data;

import Data.build.Base;
import Data.build.Build;
import Data.build.Camp;
import Data.build.Defence;

import java.io.Serializable;
import java.util.ArrayList;

public class Map implements Serializable {

    private static int total=1;
    public Map(){

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.safeZone[i][j] = -1;
            }
        }
        Add(new Base(8, 7, 1000, "Base"));
        Add(new Camp(7, 7, "Camp", 200));
        Add(new Defence(8, 8, "cannon", 400, "Defence", 400, 2000, 100));
        this.mapID=total;
        total++;
    }
    int mapID;
    int[][] safeZone=new int[15][15];
    public boolean Add(Build build) {
        if (safeZone[build.X][build.Y] == 0) {
            safeZone[build.X][build.Y] = build.ID();
            return true;
        }
        return false;
    }
    public static Map Find(int ID)
    {
        for(int i=0;i<Maps.maps.size();i++)
        {
            if(Maps.maps.get(i).mapID==ID)
            {
                return Maps.maps.get(i);
            }
        }
        return null;
    }
    public static void added()
    {
        total++;
    }
}
