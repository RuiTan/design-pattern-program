
import java.util.*;

/**
 * 
 */
public class FreeCookerCommand implements ICommand {

    /**
     * Default constructor
     */
    public FreeCookerCommand(CookerManagement object) {
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
        return object.freeCooker(cooker);
    }

}