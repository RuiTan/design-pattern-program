
import java.util.*;

/**
 * 
 */
public class CookerManagement {

    /**
     * Default constructor
     */
    public CookerManagement() {
    }

    /**
     * 
     */
    private AbstractCooker cookerChain;

    public AbstractCooker getCookerChain() {
       return cookerChain;
    }

    /**
     * @param cooker 
     * @return
     */
    public boolean useCooker(AbstractCooker cooker) {
        return false;
    }

    /**
     * @param cooker 
     * @return
     */
    public boolean freeCooker(AbstractCooker cooker) {
        // TODO implement here
        return false;
    }

    /**
     * @param cooker 
     * @return
     */
    public boolean addCooker(AbstractCooker cooker) {
        // TODO implement here
        return false;
    }

    /**
     * @param cooker
     * @return
     */
    public boolean reduceCooker(AbstractCooker cooker) {
        // TODO implement here
        return false;
    }

}