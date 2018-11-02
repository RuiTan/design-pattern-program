import java.util.*;

public class Application {
    private static Map<Integer, Vector<String>> orderMap = new HashMap<>();
    private static designPattern.FinanceSystem cashier = new designPattern.FinanceSystem(1000.0);
    public static void main() {
        initMensa();
        while(true) {
            //print the option menu 1.Deal Order 2.Purchase materials 3.Create Dishes 4.Create Meal 5.Cteate materials
            
            //switch case

            // dealOrder : if do not have enough materials, alert and continue

            //create function: end with -1






        }
    }

    public static void initMensa() {
        // init the restaurant
    }

    /**
     * 随机选择菜单中的菜，并把相应的菜名加入到orderMap中
     */
    public static void randomCustomer() {
        // 获取菜单
        Object[] products = Menu.getInstance().getPrototype().keySet().toArray();

        // 随机创建桌号、产品数
        Random random = new Random();
        int table_id = random.nextInt(50)+1;
        int product_num = random.nextInt(5)+1;
        System.out.println("桌号" + table_id + "的顾客下单，含" + product_num + "个产品");

        // 往订单中添加随机的产品
        Vector<String> order = new Vector<>();
        for (int i = 0; i < product_num; i++) {
            int product_id = random.nextInt(products.length);
            String name = (String) products[product_id];
            System.out.println("产品:" + name);
            order.add(name);
        }

        //把新订单加入orderMap
        orderMap.put(table_id, order);
    }

    public static void dealOrder() {

    }

    public static void pay() {

    }

    public static void earn() {

    }

    public static void purchaseMaterials() {
        /* 用户在循环中输入需要的材料和数量，
        系统会判断是否有足够的金额去购买这些材料，如果足够，购买，不够则报错，继续循环。
        直到用户输入指定的终止符号结束采购。*/
    }

    public static void createMaterials(String name, Double price) {
        //· 每次创建一个材料，输入材料的名称和价格
    }

    public static void createDishes(String name, HashMap<String, Integer> materials, Sample.CookingMethod method) {
        // 让用户输入菜名和烹饪方法，然后打印现有的材料列表，让用户进行选择组合，最后以-1（或者特定的符号）结束选择，判断是否有足够的材料来完成这道菜。如果有调用接口创建菜品，没有则报错。

    }

    public static void createMeal(Double price, ArrayList<String> dishes) {
        //让用户输入套餐名称，价格（待定，是否需要自动计算价格），打印菜品列表，让用户进行选择组合，，最后以-1（或者特定的符号）结束选择，判断其中的菜是不是可以做，如果可以调用接口创建套餐，没有则报错。
    }



}