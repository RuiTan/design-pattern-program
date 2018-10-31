
import java.util.*;

/**
 * 
 */
public abstract class AbstractMeal extends AbstractProduct {


    /**
     * Hash map of all meals
//     */
//    private static HashMap<String , AbstractMeal> mealList = new HashMap<>();
//
//    static {
//        mealList.put(MealOne.DEFAULTNAME, MealOne.mealOne);
//        mealList.put(MealTwo.DEFAULTNAME, MealTwo.mealTwo);
//    }

    /**
     * @param productName 需要找的套餐的名字
     * @return
     */
//    public static AbstractMeal findAndClone(String productName){
//        if (productName != null && !productName.equals("")){
//            return (AbstractMeal) mealList.get(productName).clone();
//        }
//        return null;
//    }

    /**
     *
     * @param meal 添加一个套餐
     */
//    protected static void addPrototype(AbstractMeal meal){
//        mealList.put(meal.getName(), meal);
//    }

    /**
     * Default constructor
     */
    public AbstractMeal() {}


    /**
     *
     * @return 获取套餐里面菜的map
     */
    public abstract HashMap<String, AbstractProduct> getDishes();

    /**
     *
     * @param visitor 用来观察的Visitor
     * @param retract 缩进空格，排版用的
     */
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

//
//    /**
//     * @param name
//     * @return
//     */
//    public abstract AbstractMeal clone(String name);
//
//    /**
//     * @param name
//     * @param price
//     * @return
//     */
//    public abstract AbstractMeal clone(String name, Double price);

    /**
     *
     * @param dishes 需要添加到套餐中的菜
     */
    public abstract void addDishes(HashMap<String, AbstractProduct> dishes);



}
