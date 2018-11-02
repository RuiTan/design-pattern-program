
import javafx.util.Pair;

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
    public AbstractProduct addProduct(AbstractProduct product) {
        if (prototype.containsKey(product.getName())){
            System.out.println(PRINT + "无法添加产品'" + product.getName() + "',原型已存在,将进行克隆操作");
            return null;
        }
        else{
            prototype.put(product.getName(), product);
            operationsStack.add(new Pair<>(Operations.AddOp, product));
            System.out.println(PRINT + "添加产品'" + product.getName() + "'成功");
            return product;
        }
    }

    /**删除菜品
     * @param productName
     * @return
     */
    public AbstractProduct deleteProduct(String productName) {
        if (prototype.containsKey(productName)){
            System.out.println(PRINT + "删除产品'" + productName + "'成功");
            AbstractProduct tempProduct = prototype.get(productName);
            operationsStack.add(new Pair<>(Operations.DeleteOp, tempProduct));
            prototype.remove(productName);
            return tempProduct;
        }
        System.out.println(PRINT + "删除产品'" + productName + "'失败");
        return null;
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
            AbstractProduct clone = product.clone();
            if (product instanceof DishOne){
                DishOne dish = (DishOne)product;
                // clone the exist product and add it to the orinal list
                dish.addDishToList((DishOne)clone);
                dish.addCount();
            }
            return clone;
            
        }else {
            System.out.println(PRINT + "菜品(" + productName + ")未找到");
            return null;
        }
    }

    /** 操作符
     *
     *
     */
    public enum Operations{
        AddOp, DeleteOp;
    }

    /**
     * operationsStack : 操作栈
     * redoStack : 恢复栈
     * 无上限
     */
    private static Stack<Pair<Operations, AbstractProduct>> operationsStack = new Stack<>();
    private static Stack<Pair<Operations, AbstractProduct>> redoStack = new Stack<>();

    /**
     *
     */
    public boolean undo(){
        System.out.println(operationsStack.empty());
        if (operationsStack.empty()){
            System.out.println("There isn't operation to be undone.");
            return false;
        }
        Pair<Operations, AbstractProduct> tempPair = operationsStack.pop();

        if (tempPair.getKey()==Operations.AddOp){
            deleteProduct(tempPair.getValue().getName());
            operationsStack.pop();
            redoStack.add(new Pair<>(Operations.AddOp, tempPair.getValue()));
            System.out.println("Undo: add " + tempPair.getValue().getName() + " successfully!");

        }else {
            addProduct(tempPair.getValue());
            operationsStack.pop();
            redoStack.add(new Pair<>(Operations.DeleteOp, tempPair.getValue()));
            System.out.println("Undo: delete " + tempPair.getValue().getName() + " successfully!");

        }

        return true;
    }

    /**
     *
     */
    public boolean redo(){
        if (redoStack.empty()){
            System.out.println("There isn't operation to be redone.");
            return false;
        }
        Pair<Operations, AbstractProduct> tempPair = redoStack.pop();

        if (tempPair.getKey()==Operations.AddOp){
            addProduct(tempPair.getValue());
            System.out.println("Redo: add " + tempPair.getValue().getName() + " successfully!");
        }else {
            deleteProduct(tempPair.getValue().getName());
            System.out.println("Redo: delete " + tempPair.getValue().getName() + " successfully!");
        }

        return true;
    }
}