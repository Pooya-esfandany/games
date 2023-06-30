package Data.errors;

public class NotEnoughCash extends Exception {
    @Override
    public String toString()
    {
        return "you are too poor...";
    }
    @Override
    public String getMessage()
    {
        return "mission failed";
    }

}
