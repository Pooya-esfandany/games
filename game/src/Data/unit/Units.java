package Data.unit;

public class Units {
    public static Unit getByID(int id) {
        Unit unit=null;
        switch (id) {
            case 1:
                unit = new Knight("Knight", 40000, 250, 400, 40, 50);
                break;
            case 2:
                unit = new Enchantress("Enchantress", 30000, 150, 500, 50, 50);
                break;
            case 3:
                unit = new Archer("Archer", 2000, 5000, 1820, 21, 150);
                break;
            case 4:
                unit = new Wizard("Wizard", 2000, 1000, 7200, 30, 100);
                break;
        }
        return unit;


    }
}
