
import java.util.*;

/**
 * 
 */
public class CookNeededDish extends AbstractDish {

    @Override
    public void flavor() {

    }

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
    public HashMap<String, Material> materialsList;


    @Override
    public AbstractProduct clone() {
        return null;
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
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

    @Override
    public Boolean setPrice(Double newPrice) {
        return null;
    }

    /**
     * @return
     */
    public HashMap<String, Material> getMaterials() {
        // TODO implement here
        return materialsList;
    }
}