
import java.util.*;

/**
 * 
 */
public class AbstractMeal extends AbstractProduct {

    /**
     * Default constructor
     */
    public AbstractMeal() {
    }

    /**
     * 
     */
    private List dishList;


    /**
     * 
     */
    public void getName() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getPrice() {
        // TODO implement here
    }

    /**
     * 
     */
    public void accept() {
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
     * 
     */
    public abstract void accept();

    /**
     * @return
     */
    public abstract Product clone();

}