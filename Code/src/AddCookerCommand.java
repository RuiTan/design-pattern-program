
import java.util.*;

/**
 * 
 */
public class AddCookerCommand implements ICommand {

    /**
     * Default constructor
     */
    public AddCookerCommand(CookerManagement object) {
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
        return object.addCooker(cooker);
    }

}