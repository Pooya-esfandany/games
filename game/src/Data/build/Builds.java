package Data.build;

import java.util.ArrayList;

public class Builds {
    public static ArrayList<Build>builds=new ArrayList<>();
    public static Build getByID(int id)
    {
        int level=id%10;
        int baseId=(id-level)/10;
        for(int i=0;i<builds.size();i++)
        {
            if(builds.get(i).ID()==baseId)
            {
                return  builds.get(i);
            }
        }
        return null;
    }
}
