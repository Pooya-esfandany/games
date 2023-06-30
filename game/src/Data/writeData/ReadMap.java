package Data.writeData;

import Data.map.MapData;
import Data.map.Maps;

import java.io.*;
public class ReadMap extends Thread{
    @Override
    public void run() {
        try {
            FileInputStream fileInputStream = new FileInputStream("maps.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            while (true) {
                try {
                    Maps.mapData.add((MapData) objectInputStream.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
            objectInputStream.close();
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

