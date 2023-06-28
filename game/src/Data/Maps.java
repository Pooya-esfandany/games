package Data;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

public class Maps {
    public static ArrayList<Map> maps=new ArrayList<>();
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
}
