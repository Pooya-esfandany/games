package Data.writeData;

import Data.Map;
import Data.Maps;

import java.io.*;

public class ReadMap extends Thread{
    @Override
    public void run()
    {
        try {
            FileInputStream fileInputStream=new FileInputStream("maps.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            while(1==1)
            {
                try {
                    Map map = (Map) objectInputStream.readObject();
                    Maps.maps.add(map);
                }
                catch (Exception e)
                {
                    break;
                }
            }

         }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
