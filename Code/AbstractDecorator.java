
import java.util.*;

/**
 * 
 */
public abstract class AbstractDecorator extends AbstractDish {

    /**
     * Default constructor
     */
    public AbstractDecorator() {
    }

    /**
     * 
     */
    private Dish Dish;

    /**
     * 
     */
    public void decorate() {
        // TODO implement here
    }

    /**
     * 
     */
    public abstract void getName();

    /**
     * 
     */
    public abstract void getPrice();

    /**
     * @return
     */
    public abstract list getMaterials();

}