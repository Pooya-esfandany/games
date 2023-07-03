package Data.build;

public class Builds {

    public static Build getByID(int id) {
        int level = id % 10;
        int baseId = (id - level) / 10;
        Build build = null;
        switch (baseId) {
            case 0:
                build = new Base(10000, "Base");break;
            case 1:
                build = new Cannon("cannon", 5000, "Defence", 1000, 800, 200, 1);break;
            case 2:
                build = new Camp("Camp", 300);break;
            case 3:
                build = new Storage(350, "Storage", 10000);break;
            case 4:
                build = new Crusher("crusher", 10000, "Defence", 10000, 5000, 100, 4);break;
        }
        for (int i = 0; i < level; i++) {
            build.upgrade();
        }
        return build;
    }

    }

