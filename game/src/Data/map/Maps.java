package Data.map;

import java.io.Serializable;
import java.util.ArrayList;

public class Maps implements Serializable {
     public static ArrayList<MapData> mapData =new ArrayList<>();

    public static MapData Find(int ID)
    {
        for(int i = 0; i<Maps.mapData.size(); i++)
        {
            if(Maps.mapData.get(i).mapID==ID)
            {
                return Maps.mapData.get(i);
            }
        }
        return null;
    }

}
