import java.util.HashMap;

public class MealOne extends AbstractMeal {

    private String name;
    private Double price;

    protected static final String DEFAULTNAME = "MEALONE";
    protected static final Double DEFAULTPRICE = 100.0D;

    protected static MealOne mealOne = new MealOne();

    private static HashMap<String, AbstractProduct> dishList = new HashMap<>();
    private static int count = 1;

    /**
     * 构造函数，外部无法调用
     */
    protected MealOne(){
        addPrototype(this);
    }

    protected MealOne(String name, Double price){
        this.name = name;
        this.price = price;
        count++;
    }

    protected MealOne(String name){
        this(name, DEFAULTPRICE);
        count++;
    }

    /**
     *
     * @return MealOne套餐中的菜
     */
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
        return new MealOne(DEFAULTNAME, DEFAULTPRICE);
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

    @Override
    public AbstractMeal clone(String name) {
        return new MealOne(name);
    }

    @Override
    public AbstractMeal clone(String name, Double price) {
        return new MealOne(name, price);
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
