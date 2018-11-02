import java.util.*;

public class Application {

    private static HashMap<Integer, Vector<String>> orderMap;

    private static FinanceSystem cashier;

    public static void main() {
        initMensa();
        int operate;

        Scanner scanner = new Scanner(System.in);

        out:
        while(true) {

            System.out.println("\n请输入你要进行的操作: 打印菜单(1) 添加原料(2) 增加原料量(3) 创建一道菜(4) 创建一个套餐(5) 新建订单(6) 处理订单(7)");
            operate = scanner.nextInt();

            //print the option menu 1.Deal Order 2.Purchase materials 3.Create Dishes 4.Create Meal 5.Cteate materials

            //switch case

            // dealOrder : if do not have enough materials, alert and continue

            //create function: end with -1

            switch (operate){
                case 1:
                    Menu.getInstance().printMenu();
                    break;
                case 2:
                    try {
                        createMaterials();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    purchaseMaterials();
                    break;
                case 4:
                    createDishes();
                    break;
                case 5:
                    createMeal();
                    break;
                case 6:
                    randomCustomer();
                    break;
                case 7:
                    dealOrder();
                    break;
                default:
                    System.out.println("\n\n程序成功退出！\n\n");
                    break out;
            }

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
        orderMap = new HashMap<>();

        //初始化资金管理类，启动资金为RMB10000
        System.out.println("正在初始化资金，餐厅启动资金为10000RMB...");
        cashier = new FinanceSystem(10000.0);

        // 食材不需要单独初始化，由于使用singleton模式，全局范围中只存在唯一一个静态MaterialManagement对象
        System.out.println("正在初始化食材列表，当前食材列表为空...");

        // 菜品不需要初始化，开始状态没有菜品，需要由用户自己选择创建
        System.out.println("正在初始化菜品列表，当前菜品列表为空...");

        // 菜单不需要初始化，直接打印空菜单内容即可
        System.out.println("正在初始化菜单，当前菜单为空");
        Menu.getInstance().printMenu();

        Init();

        // 结束初始化过程，打印调试信息
        System.out.println("初始化完成");
        System.out.println(footer());
    }

    public static void Init(){

         HashMap<String, Integer> materials;
         HashMap<String, Integer> materials2;
         DishOne dishOne1;
         DishOne dishOne2;
         DishOne dishOne3;
         DishOne dishOne4;
         DishOne dishOne5;
         DishOne dishOne6;

        Menu menu = Menu.getInstance();

        MaterialFactory factory = new MaterialFactory();

        factory.createMaterial(Sample.MaterialType.meat, 1000, 10.0, "牛肉");
        factory.createMaterial(Sample.MaterialType.meat, 8000, 20.0, "羊肉");
        factory.createMaterial(Sample.MaterialType.meat, 5000, 8.0, "猪肉");
        factory.createMaterial(Sample.MaterialType.vegetable, 5000, 1.0, "小青菜");
        factory.createMaterial(Sample.MaterialType.vegetable, 2000, 2.0, "大白菜");
        factory.createMaterial(Sample.MaterialType.meat, 5000, 12.0, "大猪蹄");

        /**
         * 创建一些菜
         */
        materials = new HashMap<>();
        materials.put("牛肉", 5);
        materials.put("小青菜", 10);

        materials2 = new HashMap<>();
        materials2.put("牛肉", 15);
        materials2.put("大猪蹄", 10);

        dishOne1 = Sample.createDish("菜1", 20.0, materials, Sample.CookingMethod.fried);
        dishOne2 = Sample.createDish("菜2", 30.0, materials, Sample.CookingMethod.steam);
        dishOne3 = Sample.createDish("菜3", 40.0, materials, Sample.CookingMethod.fried);
        dishOne4 = Sample.createDish("菜4", 50.0, materials2, Sample.CookingMethod.doNothing);
        dishOne5 = Sample.createDish("菜4", 50.0, materials2, Sample.CookingMethod.steam);

        /**
         * 创建一些套餐
         */
        AbstractMeal meal1 = Sample.getMeal(Sample.MealType.MealOne);
        AbstractMeal meal2 = Sample.getMeal(Sample.MealType.MealTwo);
        AbstractMeal meal3 = Sample.getMeal(Sample.MealType.MealTwo);

        /**
         * 套餐中加些东西
         */
        new MealOneBuilder().addDish(dishOne1);
        new MealOneBuilder().addDish(dishOne2);

        new MealTwoBuilder().addDish(dishOne3);

        /**
         * 创建一些角色
         */
        Waiter waiter1 = new Waiter("谈瑞");
        Customer customer1 = new Customer("梁程伟");
        Customer customer2 = new Customer("杨丁豪");

        /**
         * 创建一个餐厅对话中介，将角色添加至其中
         */
        RestMediator rm = new RestMediator();
        rm.addRole(waiter1);
        rm.addRole(customer1);
        rm.addRole(customer2);
    }

    /**
     * 随机选择菜单中的菜，并把相应的菜名加入到orderMap中
     */
    public static void randomCustomer() {
        if (Menu.getInstance().getPrototype().isEmpty()){
            System.out.println("当前饭店不买菜，请换一家饭店！");
            return;
        }

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
        // get a order
        // lock the orderlist
        if (orderMap.isEmpty()) {
            System.out.println("当前没有订单，请等待顾客光顾");
            return;
        }
        for (HashMap.Entry<Integer, Vector<String>> entry : orderMap.entrySet()){
            try {
                Vector<String> order = entry.getValue();
                Integer tableNumber = entry.getKey();
                if (order.isEmpty()) {
                    System.out.println("This Order is empty, please try deal next order");
                    return;
                } else {
                    Menu menu = Menu.getInstance();
                    for (String name: order) {
                        AbstractProduct dish = menu.findAndClone(name);
                        if (dish == null) {
                            System.out.printf("The dish %s does not in the menu\n", name);
                            continue;
                        } else {
                            // Check the materials remain number
                            boolean cookAble = true;
                            // Judge if it is dish
                            if (dish instanceof DishOne) {
                                DishOne dishOne = (DishOne)dish;
                                HashMap<String, Material> materials = dishOne.getMaterials();
                                MaterialManagement materialManager = MaterialManagement.getInstance();
                                for (HashMap.Entry<String, Material> material: materials.entrySet()) {
                                    String materialName = material.getKey();
                                    if (materialManager.getMaterialAmount(materialName) < 0) {
                                        System.out.printf("Can't cook %s , cause lack of %s\n", name, materialName);
                                        cookAble = false;
                                        break;
                                    }
                                }
                            } else {
                                // it is meal
                                AbstractMeal meal = (AbstractMeal)dish;
                                HashMap<String, AbstractProduct> dishes = meal.getDishes();
                                for (HashMap.Entry<String, AbstractProduct> aDish: dishes.entrySet()) {
                                    HashMap<String, Material> materials = ((AbstractDish)aDish.getValue()).getMaterials();
                                    MaterialManagement materialManager = MaterialManagement.getInstance();
                                    for (HashMap.Entry<String, Material> material: materials.entrySet()) {
                                        String materialName = material.getKey();
                                        if (materialManager.getMaterialAmount(materialName) < 0) {
                                            System.out.printf("Can't cook %s , cause lack of %s\n", name, materialName);
                                            cookAble = false;
                                            break;
                                        }
                                    }
                                    if (!cookAble) {
                                        break;
                                    }
                                }
                            }
                            if (!cookAble) {
                                continue;
                            }
                            // User material
                            if (dish instanceof DishOne) {
                                DishOne dishOne = (DishOne)dish;
                                HashMap<String, Material> materials = dishOne.getMaterials();
                                MaterialManagement materialManager = MaterialManagement.getInstance();
                                for (HashMap.Entry<String, Material> material: materials.entrySet()) {
                                    String materialName = material.getKey();
                                    materialManager.getMaterial(materialName, 1);
                                }
                            } else {
                                // it is meal
                                AbstractMeal meal = (AbstractMeal)dish;
                                HashMap<String, AbstractProduct> dishes = meal.getDishes();
                                for (HashMap.Entry<String, AbstractProduct> aDish: dishes.entrySet()) {
                                    HashMap<String, Material> materials = ((AbstractDish)aDish.getValue()).getMaterials();
                                    MaterialManagement materialManager = MaterialManagement.getInstance();
                                    for (HashMap.Entry<String, Material> material: materials.entrySet()) {
                                        String materialName = material.getKey();
                                        materialManager.getMaterial(material.getKey(), 1);
                                    }
                                }

                            }

                            System.out.printf("Dish %s cooked\n", name);
                            earn(menu.getProductPrice(name));
                        }
                    }

                }
                orderMap.remove(tableNumber);
                System.out.printf("Table %s's Order was served.\n", tableNumber);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }


        // check if we can do the order item

        // User API to create an order and add the order to the order list

        // Delete the order form the waiting list

    }

    public static void pay() {

    }

    public static void earn(Double money) throws Exception {
        cashier.earn(money);
    }

    public static void purchaseMaterials() {
        /* 用户在循环中输入需要的材料和数量，
        系统会判断是否有足够的金额去购买这些材料，如果足够，购买，不够则报错，继续循环。
        直到用户输入指定的终止符号结束采购。*/

        // 打印购买原料的调试信息
        System.out.println(header("Purchase Materials"));

        // 创建输入流
        Scanner scanner = new Scanner(System.in);
        scanner.reset();

        // 获取存储原料的哈希表
        MaterialManagement instance = MaterialManagement.getInstance();
        HashMap<String, Material> materials = instance.getMaterialMap();

        // 让用户循环输入需要加购的原料和数量
        inner:
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
                break inner;
            }
            // 用户选择增加一种现有的原料
            if ( 0 < number && number <= i){
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
                        break inner;
                    }
                }
                // 捕获异常
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else {
                // 用户输入了不符合要求的编号
                System.out.println("请输入符合要求的编号！\n\n");
            }
        }
//        scanner.close();
    }

    public static void createMaterials() throws Exception {
        // 每次创建一个材料，输入材料的名称和价格
        System.out.println("开始创建新材料：");
        MaterialManagement materialManagement = MaterialManagement.getInstance();
        HashMap<String, Material> materialMap = materialManagement.getMaterialMap();

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要添加的材料名字：(输入 # 退出)");
            String materName = scanner.next();
            if (materialMap.keySet().contains(materName)){
                System.out.println("已经存在该材料。");
                purchase(materName);
                continue;
            }
            if (materName.equals("#")) return;
            System.out.println("请输入该材料价格：(输入 # 退出)");
            String strPrice = scanner.next();
            if (strPrice.equals("#")) return;
            Double price = Double.valueOf(strPrice);
            materialManagement.addMaterial(new Material(0, price, materName));
            System.out.println("添加新材料成功！");
            purchase(materName);
        }
    }

    private static void purchase(String materName) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MaterialManagement materialManagement = MaterialManagement.getInstance();
        HashMap<String, Material> materialMap = materialManagement.getMaterialMap();

        System.out.println("您是否想要购买一定数量的 " + materName +"？Y/N(输入 # 退出)");
        String tempOp = scanner.next();
        if (tempOp.equals("Y")){
            System.out.println("请输入购买的数量：(输入 # 退出)");
            String strAmount = scanner.next();
            if (strAmount.equals("#")) return;
            int amount = Integer.parseInt(strAmount);

            Double cost = materialMap.get(materName).getPrice()*amount;
            if (cashier.getFinance() >= cost){
                materialManagement.purchaseMaterial(materName, amount);
                cashier.expense(cost);
                System.out.println("购买" + materName + "成功，花费资金: [" + cost + "], 剩余资金: [" + cashier.getFinance() + "].");
                System.out.println("仓库中现有材料及其数量为：\n名字\t\t数量\t\t价格");
                for (Map.Entry<String, Material> entry : materialMap.entrySet()){
                    System.out.println(entry.getKey() + "\t\t" +entry.getValue().getAmount() + "\t\t" + entry.getValue().getPrice());
                }
            }else{
                System.out.println("资金不足！无法购买！");
            }
        } else if (tempOp.equals("N")){

        }
    }

    public static void createDishes() {
        // 让用户输入菜名和烹饪方法，然后打印现有的材料列表，让用户进行选择组合，最后以-1（或者特定的符号）结束选择，判断是否有足够的材料来完成这道菜。如果有调用接口创建菜品，没有则报错。
        //input dish's name
        MaterialManagement materialManagement = MaterialManagement.getInstance();
        HashMap<String,Material> materialMap = materialManagement.getMaterialMap();
        Menu menu = Menu.getInstance();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入你要添加的菜名： (输入q结束)");
            String name = (String)sc.next();
            if(name.toLowerCase().equals("q")){
                break;
            }
            //input dish's cooking method
            System.out.println("请输入该菜品所需的烹饪方法序号(1.fried 2.steam 3.doNothing： (输入q结束)");
            String cookingMethod = (String)sc.next();
            Sample.CookingMethod method = Sample.CookingMethod.doNothing;
            if(cookingMethod.toLowerCase().equals("q")){
                break;
            }else{
                if(cookingMethod.toLowerCase().equals("1") || cookingMethod.toLowerCase().equals("fried")){
                    method = Sample.CookingMethod.fried;
                }else if (cookingMethod.toUpperCase().equals("2") || cookingMethod.toLowerCase().equals("steam")){
                    method = Sample.CookingMethod.steam;
                }
            }
            //print material list
            System.out.println("现有的材料列表如下： ");
            if (materialMap.isEmpty()){
                System.out.println("当前仓库空荡荡,无法添加新的菜");
                return;
            }
            Iterator<HashMap.Entry<String, Material>> iter = materialMap.entrySet().iterator();
            Vector<String> materialList = new Vector<String>();
            HashMap<String, Integer> materials = new HashMap<String,Integer>();
            Integer No = 1;
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = (String)entry.getKey();
                Object value = entry.getValue();
                materialList.add((String)key);
                System.out.println(No.toString() + ". " + key);
                No +=  1;
            }
            //select material
            Double price = 0.0;
            System.out.println("请输入需要的材料序号,用空格隔开,输入-1结束）：");
            Integer matNum = 1;
            Integer matAmount = 1;
            Integer size = materialList.size();

            while(sc.hasNextInt() && (matNum = sc.nextInt()) != -1){
//                if(sc.hasNextInt()){
//                    matAmount = sc.nextInt();
                    if(matNum > 0 && matNum <= size){
                        String selectedName = materialList.get(matNum-1);
                        Material selectedMat = materialMap.get(selectedName);
                        price += selectedMat.getPrice()*matAmount;
                        materials.put(selectedName,matAmount);
                    }else {
                        System.out.println("输入的序号有错,请重新输入:");
                    }
//                }else{
//                    break;
//                }
            }

            if (materials.isEmpty()){
                System.out.println("输入的材料暂时仓库还没有,请重新点菜！");
                continue;
            }

            //check if the material is enough
            //create the dish
            price *= 2.5;
            DishOne dishOne = new DishOne(name, price);
            ArrayList<Material> materialArrayList = new ArrayList<>();
            for (HashMap.Entry<String, Integer> entry : materials.entrySet()) {
                materialArrayList.add(MaterialManagement.getInstance().getMaterial(entry.getKey(), entry.getValue()));
            }
            dishOne.setMaterials(materialArrayList);
            switch (method) {
                case fried: {
                    dishOne.setCookingMethod(new FriedMethod());
                    break;
                }
                case steam: {
                    dishOne.setCookingMethod(new SteamMethod());
                    break;
                }
                default: {
                    dishOne.setCookingMethod(new DoNothingMethod());
                    break;
                }
            }
            //add the dish to menu
            menu.addProduct(dishOne);
        }
    }

    public static void createMeal() {
        //让用户输入套餐名称，价格（待定，是否需要自动计算价格），打印菜品列表，让用户进行选择组合，，最后以-1（或者特定的符号）结束选择，判断其中的菜是不是可以做，如果可以调用接口创建套餐，没有则报错。
        //input meal's name
        Menu menu = Menu.getInstance();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入你要添加的套餐名： (输入q结束)");
            String name = (String)sc.next();
            if(name.toLowerCase().equals("q")){
                break;
            }
            //print dish list
            System.out.println("现有的菜品列表如下： ");
            HashMap<String,AbstractProduct> productMap = menu.getPrototype();
            if (productMap.isEmpty()){
                System.out.println("当前菜单空荡荡,无法添加新套餐");
                return;
            }
            Iterator<HashMap.Entry<String, AbstractProduct>> iter = productMap.entrySet().iterator();
            Vector<String> dishList = new Vector<String>();
            HashMap<String,AbstractProduct> dishes = new HashMap<String,AbstractProduct>();
            Integer No = 1;
            while(iter.hasNext()){
                HashMap.Entry<String, AbstractProduct> entry = iter.next();
                Object key = (String)entry.getKey();
                Object value = entry.getValue();
                dishList.add((String)key);
                System.out.println(No.toString() + ". " + key);
                No +=  1;
            }
            //select dish
            //   Double price = 0.0;
            System.out.println("请输入需要的菜品序号，(用空格隔开,输入-1结束）：");
            Integer Num = 1;
            Integer size = dishList.size();
            while(sc.hasNextInt()){
                Num = sc.nextInt();
                if(Num > 0 && Num <= size){
                    String productName = dishList.get(Num-1);
                    AbstractProduct product = productMap.get(productName);
                    dishes.put(productName, product);
                }else if(Num == -1){
                    break;
                }else {
                    System.out.println("输入的序号有错,请重新输入:");
                }
            }
            //create the meal
            //   price *= 2.5;
            if(dishes.isEmpty()){
                continue;
            }
            MealOne mealOne = new MealOne(name);
            mealOne.addDishes((HashMap<String, AbstractProduct>) dishes);
            //add the dish to menu
            menu.addProduct(mealOne);
        }
    }


}
