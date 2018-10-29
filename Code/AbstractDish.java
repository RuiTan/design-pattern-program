
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
    private List materialList;

    /**
     * 
     */
    public ICookingMethod cookingMethod;

    /**
     * 
     */
    public IState state;





    /**
     * @return
     */
    public abstract List getMaterials();

    /**
     * @return
     */
    public String getCookingMethod() {
        // TODO implement here
        return "";
    }

    /**
     * 
     */
    public void accept() {
        // TODO implement here
    }

    /**
     * @param IState 
     * @return
     */
    public boolean setState(void IState) {
        // TODO implement here
        return false;
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