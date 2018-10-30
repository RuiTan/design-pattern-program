import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MealTwo extends AbstractMeal {

    private String name;
    private Double price;

    protected static final String DEFAULTNAME = "MEALTWO";
    protected static final Double DEFAULTPRICE = 200.0D;

    protected static MealTwo mealTwo = new MealTwo();

    private static HashMap<String, AbstractProduct> dishList = new HashMap<>();
    private static int count = 1;

    /**
     * 私有构造函数，外部无法调用
     */
    protected MealTwo(){
        addPrototype(this);
    }

    protected MealTwo(String name, Double price){
        this.name = name;
        this.price = price;
        count++;
    }

    protected MealTwo(String name){
        this(name, DEFAULTPRICE);
        count++;
    }

    @Override
    public HashMap<String, AbstractProduct> getDishes() {
        return dishList;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public AbstractProduct clone() {
        return new MealTwo(DEFAULTNAME, DEFAULTPRICE);
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

    @Override
    public AbstractMeal clone(String name) {
        return new MealTwo(name);
    }

    @Override
    public AbstractMeal clone(String name, Double price) {
        return new MealTwo(name, price);
    }

    @Override
    public void addDishes(HashMap<String, AbstractProduct> dishes) {
        for (HashMap.Entry<String, AbstractProduct> dish : dishes.entrySet()){
            if (!dishList.containsKey(dish.getKey())){
                dishList.put(dish.getKey(), dish.getValue());
            }
        }
    }


    public static HashMap<String, AbstractProduct> getDishList(){
        return dishList;
    }
}
