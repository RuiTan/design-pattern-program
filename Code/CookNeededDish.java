
import java.util.*;

/**
 * 
 */
public class CookNeededDish extends AbstractDish {

    /**
     * Default constructor
     */
    public CookNeededDish() {
    }

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public Double price;

    /**
     * 
     */
    public ArrayList<Material> materialsList;

    @Override
    public void accept() {

    }

    @Override
    public AbstractProduct clone() {
        return null;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Double getPrice() {
        // TODO implement here
        return price;
    }

    /**
     * @return
     */
    public ArrayList<Material> getMaterials() {
        // TODO implement here
        return materialsList;
    }
}