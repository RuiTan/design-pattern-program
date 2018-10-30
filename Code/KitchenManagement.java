
import java.util.*;
/**
 * 
 */
public class KitchenManagement {
    private static KitchenManagement instance = new KitchenManagement();
    static public Menu menu = Menu.getInstance();

    /**
     * 
     */
    static public MaterialManagement materialManager = MaterialManagement.getInstance();

    /**
     * 
     */
    static public CookerManagement cookerManager;

    private KitchenManagement() {

    }

    /**
     * 做一个菜品
     */
    public boolean cooking(AbstractDish dish) {
        HashMap<String, Material> material = dish.getMaterials();
        System.out.print("做'" + dish.getName() + "'的原料是 : ");
        for(HashMap.Entry<String, Material> entry : material.entrySet()){
            System.out.print(entry.getKey() + " ");
        }
        dish.getCookingMethod();
        return true;
    }

    /**
     * @return
     *
     */
    public static KitchenManagement getInstance() {
       return instance;
    }

}