package Data.writeData;

import Data.map.MapData;
import Data.map.Maps;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class WriteMap extends Thread{
    @Override
    public void run() {
        try {
            OutputStream fileOutputStream = new FileOutputStream("maps.txt");
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(bufferedOutputStream));

            for (MapData mapData : Maps.mapData) {
                objectOutputStream.writeObject(mapData);
            }
            objectOutputStream.flush();
            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}