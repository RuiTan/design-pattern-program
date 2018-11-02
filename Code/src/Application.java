import java.util.ArrayList;
import java.util.Vector;
import java.util.Scanner;
import java.util.*;


public class Application {
    private static ArrayList<Vector<String>> orderList;
    private static FinanceSystem cashier;

    public static void run() {
        initMensa();
        while(true) {
            //print the option menu 1.Deal Order 2.Purchase materials 3.Create Dishes 4.Create Meal 5.Cteate materials

            //switch case

            // dealOrder : if do not have enough materials, alert and continue

            //create function: end with -1
            System.out.println("结束初始化");
            break;
        }
    }


    public static String header(String name){
        return "\n" +
                "****************************************************************************************************************************"
                +  "\n*******************************************************" + name + "******************************************************";
    }

    public static String footer(){
        return "\n**********************************************************************************************************************"+
                "\n**********************************************************************************************************************\n\n";
    }


    public static void initMensa() {
        // init the restaurant
        // 资金、食材、菜品、菜单、订单列表初始化

        // 打印初始化函数调试信息
        System.out.println(header("Initialization"));

        // 初始化订单列表，初始值为空
        System.out.println("正在初始化订单列表...");
        orderList = new ArrayList<>();

        //初始化资金管理类，启动资金为RMB1000
        System.out.println("正在初始化资金，餐厅启动资金为1000RMB...");
        cashier = new FinanceSystem(1000.0);

        // 食材不需要单独初始化，由于使用singleton模式，全局范围中只存在唯一一个静态MaterialManagement对象
        System.out.println("正在初始化食材列表，当前食材列表为空...");

        // 菜品不需要初始化，开始状态没有菜品，需要由用户自己选择创建
        System.out.println("正在初始化菜品列表，当前菜品列表为空...");

        // 菜单不需要初始化，直接打印空菜单内容即可
        System.out.println("正在初始化菜单，当前菜单为空");
        Menu.getInstance().printMenu();

    }

    public static void randomCustomer() {
        // 随机选择菜单中的菜，并把相应的菜名加入到orderList中。
        // 随机选择菜单中的菜，并把相应的菜名加入到orderList中。

    }

    public static void dealOrder() {

    }

    public static void purchaseMaterials() {
        /* 用户在循环中输入需要的材料和数量，
        系统会判断是否有足够的金额去购买这些材料，如果足够，购买，不够则报错，继续循环。
        直到用户输入指定的终止符号结束采购。*/

        // 打印购买原料的调试信息
        System.out.println(header("Purchase Materials"));

        // 创建输入流
        Scanner scanner = new Scanner(System.in);

        // 获取存储原料的哈希表
        MaterialManagement instance = MaterialManagement.getInstance();
        HashMap<String, Material> materials = instance.getMaterialMap();

        // 让用户循环输入需要加购的原料和数量
        while (true){

            System.out.println("当前原料列表如下：");

            HashMap<Integer, String> names = new HashMap<Integer, String>();
            int i = 0;
            for (HashMap.Entry<String, Material> entry : materials.entrySet()) {
                System.out.println(i+1 + ". " + entry.getKey()+" : "+ entry.getValue().getAmount() + ",价格 : " + entry.getValue().getPrice());
                names.put(i, entry.getKey());
                i++;
            }

            System.out.println("请输入您要增加的原料编号，或输入[0]退出本次操作：");
            int number = -1, amount = 0;
            number = scanner.nextInt();

            // 根据用户输入的选项执行对应操作
            if (number == 0){
                // 退出本次操作
                System.out.println("退出本次操作");
                System.out.println(footer());
                break;
            }
            // 用户选择增加一种现有的原料
            if ( 0 < number && number < i){
                // 获取用户要添加的原料对象
                Material material = materials.get(names.get(number-1));
                // 获取用户要增加的原料数量
                System.out.println("请输入您要增加的原料数量：");
                amount = scanner.nextInt();
                // 计算用户需要花费的金额
                Double price = material.getPrice() * amount;
                // 打印调试信息
                System.out.println("您要增加的原料为【" + names.get(number-1) + "】，要购买【" + amount + "】份，共需要【" + price + "】元");
                try {
                    // 获取当前余额
                    Double finance = cashier.getFinance();
                    // 资金足够，则从资金中扣除相应数目，同时购进原料
                    if (finance >= price){
                        cashier.expense(price);
                        instance.purchaseMaterial(names.get(number-1), amount);
                        Double new_finance = cashier.getFinance();
                        System.out.println("当前资金余额为【" + finance + "】元，进行原料购买，购买后的资金余额为【" + new_finance + "】元\n\n");
                    }
                    else {
                        System.out.println("当前资金余额为" + finance + "元，无法购买原料，退出本次操作\n\n");
                        break;
                    }
                }
                // 捕获异常
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                // 用户输入了不符合要求的编号
                System.out.println("请输入符合要求的编号！");
                continue;
            }
        }
        scanner.close();
    }

    public static void createMaterials(String name, Double price) {
        // 每次创建一个材料，输入材料的名称和价格
    }

    public static void createDishes(String name, HashMap<String, Integer> materials, ICookingMethod method) {
        // 让用户输入菜名和烹饪方法，然后打印现有的材料列表，让用户进行选择组合，最后以-1（或者特定的符号）结束选择，判断是否有足够的材料来完成这道菜。如果有调用接口创建菜品，没有则报错。

    }

    public static void createMeal(Double price, ArrayList<String> dishes) {
        //让用户输入套餐名称，价格（待定，是否需要自动计算价格），打印菜品列表，让用户进行选择组合，，最后以-1（或者特定的符号）结束选择，判断其中的菜是不是可以做，如果可以调用接口创建套餐，没有则报错。
    }



}
