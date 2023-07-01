package Data.map;

import Data.AttackData.BuildLocation;
import Data.build.*;

import java.io.Serializable;
import java.util.ArrayList;

public class MapData implements Serializable {

    private static int total=1;
    public ArrayList<BuildLocation> getLocation()
    {
        ArrayList<BuildLocation> buildLocations =new ArrayList<>();
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                if(safeZone[i][j]!=-1)
                {
                    BuildLocation buildLocation =new BuildLocation(i,j,safeZone[i][j]);
                    buildLocations.add(buildLocation);
                }
            }
        }
        return buildLocations;
    }
     public MapData(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                this.safeZone[i][j] = -1;
            }
        }
        Base base=new Base(1000,"Base");
        Add(3,3,base);
        Defence cannon=new Defence("cannon",500,"Defence",100,500,150,1);
        Add(3,4,cannon);
        Storage storage=new Storage(300,"Storage",1000);
        Add(4,3,storage);
        Camp camp=new Camp("Camp",200);
        Defence smasher=new Defence("crusher", 600, "Defence", 1000, 2000, 70, 4);
        Add(3,2,camp);
        Add(2,3,smasher);
        this.mapID=total;
        total++;
    }

    public int mapID;
    public int[][] safeZone=new int[7][7];
    public boolean Add(int x,int y,Build build) {
        if (safeZone[x][y] == -1) {
            safeZone[x][y] = build.ID()*10+ build.level-1;
            return true;
        }
        return false;
    }
    public int get(int x,int y)
    {
        return safeZone[x][y];
    }

    public boolean Add(int x,int y,int build) {
        if (safeZone[x][y] == -1) {
            safeZone[x][y] = build;
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
