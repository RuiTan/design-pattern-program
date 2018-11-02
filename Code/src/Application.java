import java.util.*;

import Sample.CookingMethod;

public class Main {
    private static ArrayList<Vector<String>> orderList = new ArrayList<Vector<String>>();
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
    
    public static void randomCustomer() {
        // 随机选择菜单中的菜，并把相应的菜名加入到orderList中。

    }

    public static void dealOrder() {

    }

    public static void pay() {

    }

    public static void earn() {

    }

    public static void purchaseMaterials() throws Exception {
        /* 用户在循环中输入需要的材料和数量，
        系统会判断是否有足够的金额去购买这些材料，如果足够，购买，不够则报错，继续循环。
        直到用户输入指定的终止符号结束采购。*/

    }

    public static void createMaterials() throws Exception {
        // 每次创建一个材料，输入材料的名称和价格
        System.out.println("开始创建新材料: (输入 # 退出)");
        MaterialManagement materialManagement = MaterialManagement.getInstance();
        HashMap<String, Material> materialMap = materialManagement.getMaterialMap();

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入材料名字：(输入 # 退出)");
            String materName = scanner.next();
            if (materialMap.keySet().contains(materName)){
                System.out.println("已经存在该材料。");
                continue;
            }
            if (materName == "#") return;
            System.out.println("请输入材料价格：(输入 # 退出)");
            String strPrice = scanner.next();
            if (strPrice == "#") return;
            Double price = Double.valueOf(strPrice);
            materialManagement.addMaterial(new Material(0, price, materName));
            System.out.println("添加新材料成功！(输入 # 退出)");
            System.out.println("是否购买一定数量新材料？Y/N(输入 # 退出)");
            String tempOp = scanner.next();
            if (tempOp == "Y"){
                System.out.println("请输入购买的数量: (输入 # 退出)");
                String strAmount = scanner.next();
                if (strAmount == "#") return;
                int amount = Integer.parseInt(strAmount);

                Double cost = materialMap.get(materName).getPrice()*amount;
                if (cashier.getFinance() >= cost){
                    materialManagement.purchaseMaterial(materName, amount);
                    cashier.expense(cost);
                    System.out.println("购买" + materName + "成功，花费资金: " + cost + ".");
                    System.out.println("仓库中现有材料及其数量为：\n名字\t\t数量");
                    for (Map.Entry<String, Material> entry : materialMap.entrySet()){
                        System.out.println(entry.getKey() + "\t\t" + entry.getValue().getName());
                    }
                }else{
                    System.out.println("资金不足！无法购买！");
                }
            } else if (tempOp == "N"){
                continue;
            }
        }
    }

    public static void createDishes(String name, HashMap<String, Integer> materials, CookingMethod method) {
        // 让用户输入菜名和烹饪方法，然后打印现有的材料列表，让用户进行选择组合，最后以-1（或者特定的符号）结束选择，判断是否有足够的材料来完成这道菜。如果有调用接口创建菜品，没有则报错。

    }

    public static void createMeal(Double price, ArrayList<String> dishes) {
        //让用户输入套餐名称，价格（待定，是否需要自动计算价格），打印菜品列表，让用户进行选择组合，，最后以-1（或者特定的符号）结束选择，判断其中的菜是不是可以做，如果可以调用接口创建套餐，没有则报错。
    }



}