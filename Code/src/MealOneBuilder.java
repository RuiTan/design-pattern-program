import java.util.HashMap;

public class MealOneBuilder implements IMealBuilder {

    @Override
    public void addDish(AbstractProduct dish) {
        if(!MealOne.getDishList().containsKey(dish.getName())){
            MealOne.getDishList().put(dish.getName(), dish);
        }
    }

    @Override
    public boolean deleteDish(AbstractProduct dish) {
        if (!MealOne.getDishList().containsKey(dish.getName())){
            return false;
        }
        MealOne.getDishList().remove(dish.getName());
        return true;
    }

    @Override
    public void addDishes(HashMap<String, AbstractProduct> dishes) {
        for (HashMap.Entry<String, AbstractProduct> dish : dishes.entrySet()){
            if (!MealOne.getDishList().containsKey(dish.getKey())){
                MealOne.getDishList().put(dish.getKey(), dish.getValue());
            }
        }
    }

}
