
import java.util.*;

/**
 * 
 */
public interface ICommand {


    /**
     * @param cooker 
     * @return
     */
    public boolean execute(AbstractCooker cooker);

}