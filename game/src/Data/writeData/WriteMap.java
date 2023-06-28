package Data.writeData;

import Data.Map;
import Data.Maps;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteMap extends Thread{

    @Override
    public void run() {
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("maps.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            for(int i=0;i<Maps.maps.size();i++)
            {
                objectOutputStream.writeObject(Maps.maps.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
