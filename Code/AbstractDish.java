
import java.util.*;

/**
 * 
 */
public abstract class AbstractDish extends AbstractProduct {

    /**
     * Default constructor
     */
    public AbstractDish() {
    }

    /**
     * 
     */
    private list materialList;

    /**
     * 
     */
    public ICookingMethod cookingMethod;

    /**
     * 
     */
    public IState state;





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

    /**
     * @return
     */
    public string getCookingMethod() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void accept() {
        // TODO implement here
    }

    /**
     * @param State 
     * @return
     */
    public bool setState(void State) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public IState getState() {
        // TODO implement here
        return null;
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