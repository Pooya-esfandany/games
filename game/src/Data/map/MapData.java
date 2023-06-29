package Data.map;

import Data.build.Base;
import Data.build.Build;
import Data.build.Camp;
import Data.build.Defence;

import java.io.Serializable;

public class MapData implements Serializable {

    private static int total=1;
    public MapData(){

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                this.safeZone[i][j] = -1;
            }
        }
        Add(new Base(1000, "Base"));
        Add(new Camp( "Camp", 200));
        Add(new Defence("cannon", 400, "Defence", 400, 2000, 100,1));
        this.mapID=total;
        total++;
    }
    public int mapID;
    int[][] safeZone=new int[15][15];
    public boolean Add(Build build) {
        if (safeZone[build.X][build.Y] == 0) {
            safeZone[build.X][build.Y] = build.ID()*10+ build.level-1;
            return true;
        }
        return false;
    }
    public static MapData Find(int ID)
    {
        for(int i = 0; i< Maps.mapData.size(); i++)
        {
            if(Maps.mapData.get(i).mapID==ID)
            {
                return Maps.mapData.get(i);
            }
        }
        return null;
    }
    public static void added()
    {
        total++;
    }
}
