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
    public static void debug()
    {
        ArrayList<MapData> debug=new ArrayList<>();
        for(int i=mapData.size()-1;i>0;i--)
        {
            boolean value;
            value=true;
            for(int j=0;j<debug.size();j++)
            {
                if(debug.get(j).mapID==mapData.get(i).mapID)
                {
                    value=false;
                }
            }
            if(value)
            {
                debug.add(mapData.get(i));
            }
        }
        mapData=new ArrayList<>();
        for(int i=0;i<debug.size();i++)
        {
            mapData.add(debug.get(i));
        }
    }
}
