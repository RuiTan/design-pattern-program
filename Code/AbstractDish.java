
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
         
        return "";
    }

    /**
     * @param state
     * @return
     */
    public boolean setState(IState state) {
        
        return false;
    }

    /**
     * @return
     */
    public IState getState() {
        
        return null;
    }

    /**
     * 
     */
    public abstract String getName();

    /**
     * 
     */
    public abstract Double getPrice();

    /**
     * 
     */
    public abstract void accept();

    /**
     * @return
     */
    public abstract AbstractProduct clone();

}