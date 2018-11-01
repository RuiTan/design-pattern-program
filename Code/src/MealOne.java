import java.util.HashMap;

public class MealOne extends AbstractMeal {

    private String name;
    private static Double price;
    protected static int count = 0;

    protected static final String DEFAULTNAME = "MEALONE";
    protected static final Double DEFAULTPRICE = 0.0D;

    protected static MealOne mealOne = new MealOne();


    private static HashMap<String, AbstractProduct> dishList = new HashMap<>();

    /**
     * 构造函数，外部无法调用
     */
    private MealOne(){
        this.name = DEFAULTNAME;
        price = DEFAULTPRICE;
        Menu.getInstance().addProduct(this);
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void addCount() {
        count++;
    }


    public MealOne(String name){
        this.name = name;
        addCount();
    }
    
    @override
    public static  void setPrice(Double newPrice){
        price = newPrice;
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
        return super.getPrice();
    }

    @Override
    public AbstractProduct clone() {
        return new MealOne(DEFAULTNAME);
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
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
