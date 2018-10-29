
import java.util.*;

/**
 * 
 */
public class Menu {

    /**
     * Default constructor
     */
    public Menu() {
    }

    /**
     * 菜单实例，存所有菜名和价格
     */
    private static Menu instance;

    /**
     * 原型，存所有菜名和对象
     */
    private static HashMap<String,AbstractProduct> prototype;

    /**
     * 存储menu的map<菜名，菜价>
     */
    private static HashMap<String, Double> menu;


    /**
     * @return
     */
    public static Menu getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    private void Menu() {
        // TODO implement here
    }

    /**
     * @param product
     * @return
     */
    public boolean addProduct(AbstractProduct product) {
        // TODO implement here
        return false;
    }

    /**
     * @param productName
     * @return
     */
    public boolean deleteProduct(String productName) {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public void printMenu() {
        // TODO implement here
    }

    /**
     * @param productName
     * @return
     */
    public float getProductPrice(String productName) {
        // TODO implement here
        return 0.0f;
    }

}