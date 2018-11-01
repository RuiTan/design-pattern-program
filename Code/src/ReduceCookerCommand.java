
import java.util.*;

/**
 * 
 */
public class ReduceCookerCommand implements ICommand {

    /**
     * Default constructor
     */
    public ReduceCookerCommand(CookerManagement object) {
        this.object = object;
    }

    /**
     * 
     */
    private CookerManagement object;

    /**
     * @param cooker 
     * @return
     */
    public boolean execute(AbstractCooker cooker) {
        return object.reduceCooker(cooker);
    }

}