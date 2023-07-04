package Data.build;

public class Builds {

    public static Build getByID(int id) {
        int level = id % 10;
        int baseId = (id - level) / 10;
        Build build = null;
        switch (baseId) {
            case 0:
                build = new Base(50000, "Base");break;
            case 1:
                build = new Cannon("cannon", 15000, "Defence", 1700, 800, 300, 1);break;
            case 2:
                build = new Camp("Camp", 3000);break;
            case 3:
                build = new Storage(3500, "Storage", 10000);break;
            case 4:
                build = new Crusher("crusher", 30000, "Defence", 4000, 10000, 100, 4);break;
        }
        for (int i = 0; i < level; i++) {
            build.upgrade();
        }
        return build;
    }

    }

