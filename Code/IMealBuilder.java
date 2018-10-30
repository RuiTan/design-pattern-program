
import java.util.*;

/**
 * 
 */
public interface IMealBuilder {

    /**
     * @param dish
     */
    public abstract void addDish(AbstractProduct dish);

    /**
     * @param dish
     */
    public abstract boolean deleteDish(AbstractProduct dish);


    /**
     *
     * @param dishes
     */
    public abstract void addDishes(HashMap<String, AbstractProduct> dishes);

}