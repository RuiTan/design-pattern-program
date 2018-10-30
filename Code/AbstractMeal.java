
import java.util.*;

/**
 * 
 */
public abstract class AbstractMeal extends AbstractProduct {


    /**
     * Hash map of all meals
     */
    private static HashMap<String , AbstractMeal> mealList = new HashMap<>();

    static {
        mealList.put(MealOne.DEFAULTNAME, MealOne.mealOne);
        mealList.put(MealTwo.DEFAULTNAME, MealTwo.mealTwo);
    }
    /**
     * @param productName
     * @return
     */
    public static AbstractMeal findAndClone(String productName){
        if (productName != null && !productName.equals("")){
            return (AbstractMeal) mealList.get(productName).clone();
        }
        return null;
    }

    protected static void addPrototype(AbstractMeal meal){
        mealList.put(meal.getName(), meal);
    }

    /**
     * Default constructor
     */
    public AbstractMeal() {}


    public abstract HashMap<String, AbstractProduct> getDishes();

    /**
     * 
     */

    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

    /**
     * @param name
     * @return
     */
    public abstract AbstractMeal clone(String name);

    /**
     * @param name
     * @param price
     * @return
     */
    public abstract AbstractMeal clone(String name, Double price);

    public abstract void addDishes(HashMap<String, AbstractProduct> dishes);

    public abstract void initDishes();
}
