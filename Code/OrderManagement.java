
import java.util.*;

/**
 * 
 */
public class OrderManagement {

    /**
     * Default constructor
     */
    public OrderManagement() {
        orderList=new LinkedList<Order>();
    }

    /**
     * 由于增删操作较多，所以改用List的实例LinkedList类作为订单表数据结构
     */
    private static LinkedList<Order> orderList;


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
    public boolean deleteOrder(int id) {
        if(orderList.size()<id || id<1){
            System.out.println("Order"+id+"has been removed successfully");
            return false;
        }
        orderList.remove(id-1);
        System.out.println("Order"+id+"has been removed successfully");
        return true;
    }

    /**
     * @desription 对整个列表内的单子进行内容打印
     */
    public void getOrderList() {
        for (Order o:orderList) {
            System.out.println(o);
        }
    }

}