package Data.unit;

public class Units {
    public static Unit getByID(int id) {
        Unit unit=null;
        switch (id) {
            case 1:
                unit = new Unit("Knight", 15000, 20, 400, 500, 60);
                break;
            case 2:
                unit = new Unit("Enchantress", 5000, 50, 500, 300, 80);
                break;
            case 3:
                unit = new Unit("Archer", 2000, 50, 1820, 200, 250);
                break;
            case 4:
                unit = new Unit("Wizard", 2000, 500, 7200, 200, 250);
                break;
        }
        return unit;


    }
}
