
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
            System.out.println(PRINT + "无法添加产品'" + product.getName() + "',原型已存在,将进行克隆操作");
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
        int i = 1;
        for (HashMap.Entry<String, AbstractProduct> entry : prototype.entrySet()){
            System.out.print(i++); System.out.println(" : ");
            if (entry.getValue() instanceof AbstractMeal){
                new DetailVisitor().visit((AbstractMeal) entry.getValue(), "");
            }
            else{
                new DetailVisitor().visit((AbstractDish) entry.getValue(), "");
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

    /**
     *
     * @param productName
     * @return
     */
    public AbstractProduct findAndClone(String productName){
        if (prototype.containsKey(productName)){
            System.out.println(PRINT + "菜品(" + productName + ")已被克隆");
            AbstractProduct product = prototype.get(productName);
            if (product instanceof DishOne){
                DishOne dish = (DishOne)product;
                dish.addCount();
            }
            return product.clone();
        }else {
            System.out.println(PRINT + "菜品(" + productName + ")未找到");
            return null;
        }
    }

}