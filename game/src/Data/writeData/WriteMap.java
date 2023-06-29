package Data.writeData;

import Data.map.Maps;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteMap extends Thread{

    @Override
    public void run() {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("maps.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            for(int i = 0; i<Maps.mapData.size(); i++)
            {
                objectOutputStream.writeObject(Maps.mapData.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
