import java.util.ArrayList;
import java.util.HashMap;

public class Sample {

    HashMap<String, Integer> materials;
    DishOne dishOne1;
    DishOne dishOne2;
    DishOne dishOne3;
    DishOne dishOne4;


    public void Initialize(){

        System.out.println("Initialize(): 开始初始化");

        Menu menu = Menu.getInstance();

        createMaterial(MaterialType.meat, 1000,  10.0, "牛肉");
        createMaterial(MaterialType.meat, 8000,  20.0, "羊肉");
        createMaterial(MaterialType.meat, 5000,  8.0, "猪肉");
        createMaterial(MaterialType.vegetable, 5000,  1.0, "小青菜");
        createMaterial(MaterialType.vegetable, 2000,  2.0, "大白菜");
        /**
         * 创建一些菜
         */
        materials = new HashMap<>();
        materials.put("牛肉", 5);
        materials.put("小青菜", 10);

        dishOne1 = createDish("菜1", 20.0, materials, CookingMethod.fried);
        dishOne2 = createDish("菜2", 30.0, materials, CookingMethod.fried);
        dishOne3 = createDish("菜3", 40.0, materials, CookingMethod.fried);
        dishOne4 = createDish("菜4", 50.0, materials, CookingMethod.fried);

        /**
         * 创建一些套餐
         */
        AbstractMeal meal1 = getMeal(MealType.MealOne);
        AbstractMeal meal2 = getMeal(MealType.MealTwo);
        AbstractMeal meal3 = getMeal(MealType.MealTwo);

        /**
         * 套餐中加些东西
         */
        new MealOneBuilder().addDish(dishOne1);
        new MealOneBuilder().addDish(dishOne2);

        new MealTwoBuilder().addDish(dishOne3);
        new MealTwoBuilder().addDish(meal1);

        /**
         * 查看套餐详情
         */
//        new PriceVisitor().visit(meal1, "");
//        System.out.println();
//        new PriceVisitor().visit(meal2, "");
//        System.out.println();
//        new PriceVisitor().visit(meal3, "");
//        System.out.println();

        menu.printMenu();

    }

    public void SingletonSample(){
        System.out.println("\n\n**************************Singleton**************************   ");
        System.out.println("说明 : Singleton保证一个类仅有一个实例，并提供一个访问它的全局访问点,本例中一份菜单仅存在一个实例。");
        System.out.println("SingletonSample : 使用单例模式获取菜单");
        Menu menu1 = Menu.getInstance();
        Menu menu2 = Menu.getInstance();

        System.out.println("Menu menu1 = Menu.getInstance() : 对象实际内存块(" + menu1.toString() + ")");
        System.out.println("Menu menu2 = Menu.getInstance() : 对象实际内存块(" + menu2.toString() + ")");

        System.out.println("menu1 == menu2 ? : " + (menu1 == menu2));

        System.out.println("打印menu1菜单详情：");
        menu1.printMenu();
        System.out.println("打印menu2菜单详情：");
        menu2.printMenu();
        System.out.println("\n************************************************************\n\n");
    }

    public void VisitorSample(){
        System.out.println("\n\n**************************Visitor****************************    ");
        System.out.println("说明 : Visitor主要是将主要将稳定的数据结构与易变的数据操作分离,本例中对Meal和Dish采用观察者模式,通常与Composite一起使用。");
        System.out.println("\nVisitorSample : 使用观察者模式查看所有套餐(菜)名");
        new NameVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\nVisitorSample : 使用观察者模式查看套餐(菜)价格");
        new PriceVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\nVisitorSample : 使用观察者模式查看套餐(菜)详情");
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\n************************************************************\n\n");
    }

    public void CompositeSample(){
        System.out.println("\n\n**************************Composite**************************    ");
        System.out.println("说明 : Composite使得用户对单个对象和组合对象的使用具有一致性,通常与Visitor一起使用,本例中使用在对Meal和Dish的操作时有一致的方法。");
        System.out.println("\nAbstractDish : 个别物, AbstractMeal : 复合物(其中可同时放置个别物和复合物)");
        System.out.println("二者继承自同一父类 : AbstractProduct");
        System.out.println("new MealOneBuilder().addDish(dishOne1);\n" +
                "new MealOneBuilder().addDish(dishOne2);\n" +
                "new MealTwoBuilder().addDish(dishOne3);\n" +
                "new MealTwoBuilder().addDish(meal1);");
        System.out.println("meal2套餐中包含meal1套餐,查看meal2套餐详情 : ");
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\n************************************************************\n\n");
    }

    public void FactorySample(){
        System.out.println("\n\n**************************Factory****************************    ");
        AbstractDish dish = new SpicyDecorator(dishOne4);
        new MealTwoBuilder().addDish(dish);
        dish = new SweetDecorator(dishOne1);
        new MealTwoBuilder().addDish(dish);
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
    }

    public void BuilderSample(){
        System.out.println("\n\n**************************Builder****************************    ");
        System.out.println("说明 : Builder将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示,本例中的套餐Meal的所有菜DishList的创建和修改方法放到了Builder中。");
        System.out.println("\nAbstractMeal : 其中套餐中的所有菜DishList构建、修改的方法与套餐的创建分离，用另外一个类(实现了IMealBuilder接口的类)来实现");
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\n为套餐2添加一道菜：new MealOneBuilder().addDish(dishOne4);\n");
        new MealTwoBuilder().addDish(dishOne4);
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\n************************************************************\n\n");
    }

    public void StateSample(){

    }

    public void DecoratorSample(){
        System.out.println("\n\n**************************Decorator****************************    ");
        System.out.println("说明 : Decorator动态地给一个对象添加一些额外的职责，本例中的Dish有一个装饰器AbstractDecorator，它相当于包了一层外壳(Dish的口味)的Dish。");
        

    }

    public void StrategySample(){

    }

    public void PrototypeSample(){

    }

    public void IteratorSample(){

    }

    public void FlyweightSample(){

    }

    public void TemplateMethodSample(){

    }


    /**
     * 原料类型
     */
    public  enum MaterialType {
        meat, vegetable
    }

    /**
     * 制作方法
     */
    public  enum CookingMethod{
        steam, fried
    }

    /**
     * Meal种类
     */
    public  enum MealType{
        MealOne, MealTwo
    }

    /**
     * 创建一种套餐
     * @param type
     * @return
     */
    public  AbstractMeal getMeal(MealType type){
        Menu menu = Menu.getInstance();
        switch (type){
            case MealOne:{
                AbstractProduct product = menu.findAndClone(MealOne.DEFAULTNAME);
                if (!(product instanceof MealOne)){
                    return new MealOne(MealOne.DEFAULTNAME);
                }else {
                    return (MealOne)product;
                }
            }
            case MealTwo:{
                AbstractProduct product = menu.findAndClone(MealTwo.DEFAULTNAME);
                if (!(product instanceof MealTwo)){
                    return new MealTwo(MealTwo.DEFAULTNAME);
                }else {
                    return (MealTwo)product;
                }
            }
            default:{
                return null;
            }
        }
    }

    /**
     * 添加原料，仅当仓库无该原料时添加
     * @param t
     * @param amount
     * @param price
     * @param name
     * @return
     */
    public  void createMaterial(MaterialType t, int amount, Double price, String name){
        MaterialManagement instance =  MaterialManagement.getInstance();
        switch (t){
            case meat:{
                instance.addMaterial(new meat(amount, price, name));
                break;
            }
            case vegetable:{
                instance.addMaterial(new Vegetable(amount, price, name));
                break;
            }
            default:{
                instance.addMaterial(new Material(amount, price, name));
                break;
            }
        }
    }

    /**
     * 获得原料，总量将从仓库减少
     * @param name
     * @param amount
     * @return
     */
    public  Material getMaterial(String name, int amount){
        MaterialManagement instance = MaterialManagement.getInstance();
        return instance.getMaterial(name, amount);
    }

    /**
     * 创建一种DishOne的菜
     * @param name
     * @param price
     * @param materials
     * @return
     */
    public  DishOne createDish(String name, Double price, HashMap<String, Integer> materials, CookingMethod method){
        DishOne dishOne = new DishOne(name, price);
        ArrayList<Material> materialArrayList = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : materials.entrySet()){
            materialArrayList.add(getMaterial(entry.getKey(), entry.getValue()));
        }
        dishOne.setMaterials(materialArrayList);
        switch (method){
            case fried:{
                dishOne.setCookingMethod(new FriedMethod());
                break;
            }
            case steam:{
                dishOne.setCookingMethod(new SteamMethod());
                break;
            }
            default:{}
        }
        return dishOne;
    }

    /**
     * 查看原料仓库
     */
    public  void showMaterials(){
        MaterialManagement instance = MaterialManagement.getInstance();
        HashMap<String, Material> materialMap = instance.getMaterialMap();
        for (HashMap.Entry material : materialMap.entrySet()){
            System.out.println(material.getValue().toString());
        }
    }




}
