package Data.writeData;

import Data.map.MapData;
import Data.map.Maps;

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

                    Maps.mapData.add((MapData)(objectInputStream.readObject()));
                }
                catch (Exception e)
                {
                    break;
                }
        fileInputStream.close();
            objectInputStream.close();}
         }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
