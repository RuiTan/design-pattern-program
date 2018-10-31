package designPattern;

import java.util.*;

/**
 * 
 */
public class OrderManagement {

    /**
     * Default constructor
     */
    public OrderManagement() {

    }

    /**
     * 由于增删操作较多，所以改用List的实例LinkedList类作为订单表数据结构
     */
    private static LinkedList<Order> orderList =new LinkedList<Order>();;


    /**
     * 提前创建好一个Order对象（传入productList&id），然后将其加入orderMap
     * @param order
     * @return
     */
    public static boolean addOrder(Order order) {
        if(order==null){
            System.out.println("New order is empty");
            return false;
        }
        /**
         * 在列表末尾加入
         */
        orderList.addLast(order);
        System.out.println("New order has been created");
        return true;
    }

    /**
     * @param id
     * 移除
     */
    public static boolean deleteOrder(int id) {
        for (Order order: orderList) {
            if (order.getTableId() == id) {
                orderList.remove(order);
                System.out.printf("Order %s has been deleted successfully!\n", id);
                return true;
            }
        }
        System.out.printf("Order %s do not exist!\n", id);
        return false;
    }

    /**
     * @desription 对整个列表内的单子进行内容打印
     */
    public LinkedList<Order> getOrderList() {
       return orderList;
    }

}