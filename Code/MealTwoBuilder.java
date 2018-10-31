import java.util.HashMap;

public class MealTwoBuilder implements IMealBuilder {

        @Override
        public void addDish(AbstractProduct dish) {
            if(!MealTwo.getDishList().containsKey(dish.getName())){
                MealTwo.getDishList().put(dish.getName(), dish);
            }

        }

        @Override
        public boolean deleteDish(AbstractProduct dish) {
            if (!MealTwo.getDishList().containsKey(dish.getName())){
                return false;
            }
            MealTwo.getDishList().remove(dish.getName());
            return true;
        }

        @Override
        public void addDishes(HashMap<String, AbstractProduct> dishes) {
            for (HashMap.Entry<String, AbstractProduct> dish : dishes.entrySet()){
                if (!MealTwo.getDishList().containsKey(dish.getKey())){
                    MealTwo.getDishList().put(dish.getKey(), dish.getValue());
                }
            }
        }
}
