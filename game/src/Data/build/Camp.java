package Data.build;

public class Camp extends Build{
    int capacity=5;
    int maxLevel=10;
    public Camp(int x, int y, String tower, int hp) {
        super(x, y, hp, tower);
    }
    boolean haveUpgrade()
    {
        if(level<maxLevel)
        {
            return true;
        }
        return false;
    }
    void upgrade()
    {
        if(haveUpgrade())
        {level++;
        capacity=level+5;
    }
    }

    @Override
    public int ID() {
        return 2;
    }
}
