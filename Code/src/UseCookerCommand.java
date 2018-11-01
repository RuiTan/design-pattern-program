
import java.util.*;

/**
 * 
 */
public class UseCookerCommand implements ICommand {

    /**
     * Default constructor
     */
    public UseCookerCommand(CookerManagement object) {
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
        return object.useCooker(cooker);
    }

}