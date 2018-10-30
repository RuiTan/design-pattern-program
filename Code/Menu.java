
import java.util.*;

/**
 * 
 */
public class Menu {

    private Menu() {
    }

    /**
     * 菜单实例，存所有菜名和价格
     */
    private static Menu instance = new Menu();

    /**
     * 原型，存所有菜名和对象
     */
    private static HashMap<String,AbstractProduct> prototype = new HashMap<String, AbstractProduct>();

    /**
     * 存储menu的map<菜名，菜价>
     */
    private static HashMap<String, Double> menu = new HashMap<String, Double>();

    /**获得菜单实例
     * @return
     */
    public static Menu getInstance() {
        return instance;
    }

    /**增加菜品
     * @param product
     * @return
     */
    public boolean addProduct(AbstractProduct product) {
        AbstractProduct a = prototype.get(product);
        if(a != null){
            return false;
        }
        else{
            prototype.put(product.getName(),product);
            menu.put(product.getName(),product.getPrice());
            return true;
        }
    }

    /**删除菜品
     * @param productName
     * @return
     */
    public boolean deleteProduct(String productName) {
        prototype.remove(productName);
        menu.remove(productName);
        return true;
    }

    /**打印菜品
     * 
     */
    public void printMenu() {
        for(HashMap.Entry<String, Double> entry : menu.entrySet() ){
            System.out.println("Name: "+entry.getKey()+"  Price: "+entry.getValue());
        }
    }

    /**
     * @param productName
     * @return
     */
    public float getProductPrice(String productName) {
        AbstractProduct a = prototype.get(productName);
        if(a == null){
            return 0;
        }
        else{
            return a.getPrice().floatValue();
        }
    }

}