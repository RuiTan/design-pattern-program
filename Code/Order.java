
import java.util.*;

/**
 * 
 */
public class Order {

    /**
     * 构造器指定了桌号
     */
    private int tableId;
    public Order(int tableId) {
        if(tableId>=1 && tableId<100)
            this.tableId=tableId;
        else
            tableId=0;
    }

    /**
     * 点单
     */
     class OrderItem{
        private int num=1;
        private AbstractProduct product;
        public OrderItem(AbstractProduct product,int num){
            this.num=num;
            this.product=product;
        }
    }
    private LinkedList<OrderItem> productList;


    /**
     * 这是一种设死状态切换的实现方式，是否有别种方式是通过设置常量
     */
    private static final ArrayList<IState> timeline=new ArrayList<IState> (){{
        //add(new RawState());
        //add(new CookingState());
        //add(new FinishedState());
        add(new ReadyState());
        add(new PreparingState());
        add(new DoneState());
    }};
    public IState state;


    /**
     * @return
     */
    public double getPrice() {
        double sum=0;
        for (OrderItem item:productList) {
            sum+=item.product.getPrice()*item.num;
        }
        return sum;
    }

    /**
     * 通过调用OderManagement的静态添加订单的方法，王其中的静态成员订单列表里加订单
     */
    public boolean createOrder() {
        OrderManagement.addOrder(this);
        return false;
    }

    /**
     * @return
     */
    public LinkedList<OrderItem> getProductList() {
        return productList;
    }

    /**
     * @param product,num
     * 如果追加同样的菜品则增加数目，否则新建一个OrderItem
     */
    public boolean addProduct(AbstractProduct product,int num) {
        if(product==null || num==0)
            return false;
        for (OrderItem item:productList) {
            if(item.product.getName()==product.getName()){
                item.num+=num;
                return true;
            }
        }
        productList.add(new OrderItem(product,num));
        return true;
    }

    /**
     * 删除已点菜品，有数量限制
     * @param product
     */
    public boolean deleteProduct(AbstractProduct product,int num) {
        if(product==null || num==0)
            return false;
        for (OrderItem item:productList) {
            if(item.product.getName()==product.getName() && item.num<=num){
                productList.remove(item);
                return true;
            }
        }
        return false;
    }

    /**
     * @param state
     * 符合订单的状态转换的时序规则即进行订单的状态转换
     */
    public boolean setState(IState state) {
        if(state==null && state==timeline.get(timeline.size()-1))
            return false;

        for (int i=0;i<timeline.size();i++){
            if(timeline.get(i).getClass()==this.state.getClass()){
                if(timeline.get(i+1).getClass()==state.getClass()){
                    this.state=state;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 返回订单当前状态
     * table 74 's order is preparing/ready/done
     */
    public void getState() {
        System.out.println("table" +tableId+" 's oder is "+this.state.toString());
    }

}

