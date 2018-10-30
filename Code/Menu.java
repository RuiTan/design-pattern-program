
import java.util.*;

/**
 * 
 */
public class Menu {

    private Menu() {
    }

    private static final String PRINT = "Menu.java : ";

    /**
     * 菜单实例，存所有菜名和价格
     */
    private static Menu instance = new Menu();

    /**
     * 原型，存所有菜名和对象
     */
    private static HashMap<String,AbstractProduct> prototype = new HashMap<String, AbstractProduct>();

    public HashMap<String, AbstractProduct> getPrototype() {
        return prototype;
    }

    /**获得菜单实例
     * @return
     */
    public static Menu getInstance() {
        System.out.println(PRINT + "获取单例成功");
        return instance;
    }

    /**增加菜品
     * @param product
     * @return
     */
    public boolean addProduct(AbstractProduct product) {
        if (prototype.containsKey(product.getName())){
            System.out.println(PRINT + "无法添加产品'" + product.getName() + "',已存在");
            return false;
        }
        else{
            prototype.put(product.getName(), product);
            System.out.println(PRINT + "添加产品'" + product.getName() + "'成功");
            return true;
        }
    }

    /**删除菜品
     * @param productName
     * @return
     */
    public boolean deleteProduct(String productName) {
        if (prototype.containsKey(productName)){
            System.out.println(PRINT + "删除产品'" + productName + "'成功");
            prototype.remove(productName);
            return true;
        }
        System.out.println(PRINT + "删除产品'" + productName + "'失败");
        return false;
    }

    /**打印菜品
     * 
     */
    public void printMenu() {
        for (HashMap.Entry<String, AbstractProduct> entry : prototype.entrySet()){
            if (entry.getValue() instanceof AbstractMeal){
                new PriceVisitor().visit((AbstractMeal) entry.getValue(), "");
            }
            else{
                new PriceVisitor().visit((AbstractDish) entry.getValue(), "");
            }
        }
    }

    /**
     * @param productName
     * @return
     */
    public Double getProductPrice(String productName) {
        if (prototype.containsKey(productName)){
            return prototype.get(productName).getPrice();
        }else {
            return -1.0;
        }
    }

}