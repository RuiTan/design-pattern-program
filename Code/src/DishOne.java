import java.util.ArrayList;
import java.util.HashMap;

public class DishOne extends AbstractDish {
    
    /*bridge design pattern start*/
    public DishOne(FlavorAPI flavorAPI){
        this.flavorAPI = flavorAPI;
    }

    public void flavor(){
        if(flavorAPI != null){
            flavorAPI.flavorDish();
        }
    }
    /*bridge design pattern end*/


    /**
     * 此菜系的基本信息
     */
    private String name;
    private Double price;
    private int count = 1;
    private ArrayList<AbstractMeal> mealList;
    private ArrayList<AbstractDish> dishList;
    /**
     * 菜需要的原料
     */
    private HashMap<String, Material> materialList;

    public void addCount() {
        count++;
    }

    public int getCount(){
        return count;
    }

    /**
     *  构造函数
     * @param name
     * @param price
     */
    public DishOne(String name, Double price) {
        
        AbstractProduct product = Menu.getInstance().findAndClone(name);
        if (product instanceof DishOne){
            this.name = product.getName();
            this.price = price;
            this.materialList = ((DishOne) product).getMaterials();
        }
        else {
            this.name = name;
            this.price = price;
            this.materialList = new HashMap<>();
            this.mealList = new ArrayList<AbstractMeal>();
            this.dishList = new ArrayList<AbstractDish>();
            Menu.getInstance().addProduct(this);
            
        }
    }
    /* */

    public void notifyAllMeal() {
        for (AbstractDish copyDish:dishList) {
            copyDish.setPrice(this.price);
        }
        for(AbstractMeal meal: mealList) {
            //notify the meal to change the price
            meal.setPrice(meal.getPrice());
        }
    }

    public void addDishToList(AbstractDish dishClone) {
        this.dishList.add(dishClone);
    }

    public void addMealToList(AbstractMeal meal) {
        try {
            for(AbstractMeal mealItem: mealList) {
                if (mealItem.getName() == meal.getName()) {
                    return;
                }
            }
            mealList.add(meal);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return 原料
     */
    @Override
    public HashMap<String, Material> getMaterials() {
        return materialList;
    }

    /**
     *
     * @param materials 添加菜需要的原料
     */
    public void setMaterials(ArrayList<Material> materials){
        for (Material material : materials){
            materialList.put(material.getName(), material);
        }
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
    public Boolean setPrice(Double newPrice) {      
        this.price = newPrice;
        notifyAllMeal();
        return false;
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }


    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }
   

}


    
