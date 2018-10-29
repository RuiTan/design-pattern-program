
import java.util.*;

/**
 * 
 */
public class AbstractCooker {

    /**
     * Default constructor
     */
    public AbstractCooker() {
    }

    /**
     * 
     */
    public String name;

    /**
     * 
     */
    public float price;

    /**
     * 
     */
    public int amount;

    /**
     * 
     */
    public int available;

    /**
     * 
     */
    public AbstractCooker nextCooker;

    /**
     * @param AbstractCooker 
     * @return
     */
    public boolean setNextCooker(AbstractCooker nextCooker) {
        this.nextCooker = nextCooker;
        return nextCooker == null;
    }

    /**
     * @param AbstractCooker 
     * @return
     */
    public boolean getWork(AbstractCooker cooker) {
        
        return false;
    }

    /**
     * @param AbstractCooker 
     * @return
     */
    public boolean work(AbstractCooker cooker) {
        
        return false;
    }

}