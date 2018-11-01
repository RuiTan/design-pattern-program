
import java.util.*;

/**
 * 
 */
public abstract class AbstractMeal extends AbstractProduct {


    /**
     * Default constructor
     */
    public AbstractMeal() {}


    public abstract int getCount();

    public abstract void addCount();


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

    /**
     *
     * @param dishes 需要添加到套餐中的菜
     */
    public abstract void addDishes(HashMap<String, AbstractProduct> dishes);

      /**
     *
     * @param difference 一个实数差值，原有价格加上这个差值得到新的价格
     * 
     */

    public Double getPrice() {
        Double sum = 0;                             
        HashMap<String, AbstractProduct> dishes = getDishes();
        for(HashMap.Entry<String, AbstractProduct> dish: dishes.entrySet()) {
            sum += dish.getValue().getPrice();
        }
        return sum;
    }

}
