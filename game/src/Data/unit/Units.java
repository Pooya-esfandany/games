package Data.unit;

public class Units {
    public static Unit getByID(int id) {
        Unit unit=null;
        switch (id) {
            case 1:
                unit = new Knight("Knight", 40000, 250, 400, 2500, 50);
                break;
            case 2:
                unit = new Enchantress("Enchantress", 30000, 100, 500, 2000, 50);
                break;
            case 3:
                unit = new Archer("Archer", 2000, 5000, 1820, 4000, 150);
                break;
            case 4:
                unit = new Wizard("Wizard", 2000, 500, 7200, 5000, 100);
                break;
        }
        return unit;


    }
}
