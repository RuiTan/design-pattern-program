import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Sample {

    private HashMap<String, Integer> materials;
    private HashMap<String, Integer> materials2;
    private DishOne dishOne1;
    private DishOne dishOne2;
    private DishOne dishOne3;
    private DishOne dishOne4;
    private DishOne dishOne5;
    private DishOne dishOne6;


    public void Initialize(){

        System.out.println(header("开始初始化"));

        Menu menu = Menu.getInstance();

        createMaterial(MaterialType.meat, 1000,  10.0, "牛肉");
        createMaterial(MaterialType.meat, 8000,  20.0, "羊肉");
        createMaterial(MaterialType.meat, 5000,  8.0, "猪肉");
        createMaterial(MaterialType.vegetable, 5000,  1.0, "小青菜");
        createMaterial(MaterialType.vegetable, 2000,  2.0, "大白菜");
        createMaterial(MaterialType.meat, 5000,  12.0, "大猪蹄");
        /**
         * 创建一些菜
         */
        materials = new HashMap<>();
        materials.put("牛肉", 5);
        materials.put("小青菜", 10);

        materials2 = new HashMap<>();
        materials2.put("牛肉", 15);
        materials2.put("大猪蹄", 10);

        dishOne1 = createDish("菜1", 20.0, materials, CookingMethod.fried);
        dishOne2 = createDish("菜2", 30.0, materials, CookingMethod.steam);
        dishOne3 = createDish("菜3", 40.0, materials, CookingMethod.fried);
        dishOne4 = createDish("菜4", 50.0, materials2, CookingMethod.doNothing);
        dishOne5 = createDish("菜4", 50.0, materials2, CookingMethod.steam);

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

        System.out.println("\n\n||| 初始化完成 |||");

        System.out.println(footer());
    }

    public String header(String name){
        return "\n" +
                "**********************************************************************************************************************"
                +  "\n*******************************************************" + name + "******************************************************";
    }

    public String footer(){
        return "\n**********************************************************************************************************************"+
                "\n**********************************************************************************************************************\n\n";
    }

    public void SingletonSample(){
        System.out.println(header("Singleton"));
        System.out.println("\n说明 : Singleton保证一个类仅有一个实例，并提供一个访问它的全局访问点,本例中一份菜单仅存在一个实例。");
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
        System.out.println(footer());
    }

    public void VisitorSample(){
        System.out.println(header("Visitor"));
        System.out.println("\n说明 : Visitor主要是将主要将稳定的数据结构与易变的数据操作分离,本例中对Meal和Dish采用观察者模式,通常与Composite一起使用。");
        System.out.println("\nVisitorSample : 使用观察者模式查看所有套餐(菜)名");
        new NameVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\nVisitorSample : 使用观察者模式查看套餐(菜)价格");
        new PriceVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\nVisitorSample : 使用观察者模式查看套餐(菜)详情");
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println(footer());
    }

    public void CompositeSample(){
        System.out.println(header("Composite"));
        System.out.println("\n说明 : Composite使得用户对单个对象和组合对象的使用具有一致性,通常与Visitor一起使用,本例中使用在对Meal和Dish的操作时有一致的方法。");
        System.out.println("\nAbstractDish : 个别物, AbstractMeal : 复合物(其中可同时放置个别物和复合物)");
        System.out.println("二者继承自同一父类 : AbstractProduct");
        System.out.println("new MealOneBuilder().addDish(dishOne1);\n" +
                "new MealOneBuilder().addDish(dishOne2);\n" +
                "new MealTwoBuilder().addDish(dishOne3);\n" +
                "new MealTwoBuilder().addDish(meal1);");
        System.out.println("meal2套餐中包含meal1套餐,查看meal2套餐详情 : ");
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println(footer());
    }

    public void FactorySample(){
        System.out.println(header("Factory"));
        System.out.println("\n说明 : Factory定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行," +
                            "\n       本例中的创建套餐的方法会根据传入的参数自动选择需要创建的套餐种类。");
        System.out.println("\nmeal1和meal2都指定为AbstractMeal类型：");
        AbstractMeal meal1 = getMeal(MealType.MealOne);
        AbstractMeal meal2 = getMeal(MealType.MealTwo);
        System.out.println("AbstractMeal meal1 = getMeal(MealType.MealOne);\n" +
                "AbstractMeal meal2 = getMeal(MealType.MealTwo);");
        System.out.println("查看meal1和meal2的类格式：");
        System.out.println("meal1：" + meal1.getClass());
        System.out.println("meal2：" + meal2.getClass());
        System.out.println(footer());
    }

    public void BuilderSample(){
        System.out.println(header("Builder"));
        System.out.println("\n\n说明 : Builder将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示,本例中的套餐Meal的所有菜DishList的创建和修改方法放到了Builder中。");
        System.out.println("\nAbstractMeal : 其中套餐中的所有菜DishList构建、修改的方法与套餐的创建分离，用另外一个类(实现了IMealBuilder接口的类)来实现");
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println("\n为套餐2添加一道菜：new MealOneBuilder().addDish(dishOne4);\n");
        new MealTwoBuilder().addDish(dishOne4);
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println(footer());
    }

    public void StateSample(){
        System.out.println(header("State"));
        System.out.println("\n说明 : State模式主要使用一系列ConcreteState类,用以将Context在不同状态下的不同行为进行封装。本例将Order以及Dish在不同完成度状态不同的行为进行了封装。\n");
        System.out.println("一个订单Order被切分成点单Ready，备餐Preparing，完成Done状态下的不同行为");

        System.out.println("新建一个订单：Order o=new Order(1);");
        Order o=new Order(1);

        System.out.println("订单在ready状态下执行状态更改：o.getState().doAction(o);");
        o.getState().doAction(o);

        System.out.print("于是订单进入了备餐状态：");
        System.out.println(o.getState());
        System.out.println(footer());
    }

    public void DecoratorSample(){
        System.out.println(header("Decorator"));
        System.out.println("\n说明 : Decorator动态地给一个对象添加一些额外的职责，本例中的Dish有一个装饰器AbstractDecorator，它相当于包了一层外壳(Dish的口味)的Dish。");
        System.out.println("\n套餐2添加一道辣的口味的菜4：");
        AbstractDish dish = new SpicyDecorator(dishOne4);
        new MealTwoBuilder().addDish(dish);
        System.out.println("\n套餐2添加一道辣的口味的菜1：");
        dish = new SweetDecorator(dishOne1);
        new MealTwoBuilder().addDish(dish);
        new DetailVisitor().visit(getMeal(MealType.MealTwo), "");
        System.out.println(footer());
    }

    public void StrategySample(){
        System.out.println(header("Strategy"));
        System.out.println("\n说明 : Strategy定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换，本例中对Dish的制作方法采用策略模式，同类的菜可以使用不同的制作方法，也可以通过某个菜改变自身的制作方法。");
        materials.put("大猪蹄", 50);
        System.out.println("创建一道菜不指定制作方法：");
        new DetailVisitor().visit(createDish("红烧大猪蹄1", 30.0, materials, CookingMethod.doNothing), "");
        System.out.println("创建一道菜制作方法（炸）：");
        AbstractDish dish = createDish("红烧大猪蹄2", 30.0, materials, CookingMethod.fried);
        new DetailVisitor().visit(dish, "");
        System.out.println("更改刚才创建的菜的制作方法：");
        dish.setCookingMethod(new SteamMethod());
        new DetailVisitor().visit(dish, "");
        System.out.println(footer());
    }

    public void PrototypeSample(){
        System.out.println(header("Prototype"));
        System.out.println("\n说明 : Prototype用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象，本例中的AbstractMeal和AbstractDish都使用了Prototype，原型列表放置在Menu中（原型列表在外部类，而非放置在父类）。");
        System.out.println("        每种Product存在一个count计数器，来记录被克隆的次数");
        Menu.getInstance().printMenu();
        System.out.println("创建如下套餐：");
        System.out.println(
                "AbstractMeal meal1 = getMeal(MealType.MealOne);\n" +
                "AbstractMeal meal2 = getMeal(MealType.MealTwo);\n" +
                "AbstractMeal meal3 = getMeal(MealType.MealTwo);"
        );
        System.out.println("如上创建同名的套餐（具有相同的菜），会从原型克隆，原型的计数如下：");
        System.out.println("MealTwo的克隆数：" + MealTwo.count);
        System.out.println(
                "dishOne4 = createDish(\"菜4\", 50.0, materials, CookingMethod.doNothing);\n" +
                "dishOne5 = createDish(\"菜4\", 50.0, materials, CookingMethod.steam);"
        );
        System.out.println("如上创建同名的菜（需要相同的原料），会从原型克隆，原型的计数如下：");
        System.out.println("菜4的克隆数：" + (((DishOne)Menu.getInstance().getPrototype().get("菜4")).getCount()));
        System.out.println(
                "dishOne6 = createDish(\"菜4\", 50.0, materials, CookingMethod.fried);"
        );
        dishOne6 = createDish("菜4", 50.0, materials, CookingMethod.fried);
        System.out.println("菜4的克隆数：" + (((DishOne)Menu.getInstance().getPrototype().get("菜4")).getCount()));
        System.out.println(footer());
    }

    public void IteratorSample(){
        System.out.println(header("Iterator"));
        System.out.println("\n说明 : Iterator提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示，本例中所有的列表数据结构均使用了Iterator。" +
                "\n例如遍历仓库中所有原料：");
        System.out.println("   Iterator iterator = MaterialManagement.getInstance().getMaterialMap().entrySet().iterator();\n" +
                "   while (iterator.hasNext()){\n" +
                "       System.out.print(\" \" + iterator.next().toString());\n" +
                "   }");
        Iterator iterator = MaterialManagement.getInstance().getMaterialMap().entrySet().iterator();
        System.out.println("输出如下：");
        while (iterator.hasNext()){
            System.out.print(" " + iterator.next().toString());
        }
        System.out.println();
        System.out.println(footer());
    }

    public void FlyweightSample(){
        System.out.println(header("Flyweight"));
        System.out.println("\n说明 : Flyweight运用共享技术有效地支持大量细粒度的对象,本例中的菜的原料Material采用的是Flyweight，不同的菜需要同种原料时，实际上使用的是同一个实体，这里的原料只是原料集合的引用。");
        System.out.println("DishOne1中的牛肉：" + dishOne1.getMaterials().get("牛肉"));
        System.out.println("DishOne2中的牛肉：" + dishOne2.getMaterials().get("牛肉"));
        dishOne1.getMaterials().get("牛肉").decreaseAmount(1);
        System.out.println("仅减少DishOne1中的量后：");
        System.out.println("DishOne1中的牛肉：" + dishOne1.getMaterials().get("牛肉"));
        System.out.println("DishOne2中的牛肉：" + dishOne2.getMaterials().get("牛肉"));
        System.out.println(footer());
    }

    public void TemplateMethodSample(){
        System.out.println(header("TemplateMethod"));
        System.out.println("\n说明 : TemplateMethod 定义一个操作中的算法骨架，子类可以在不改变算法结构情况下重新定义该算法的某些特定步骤。即把相同的代码放在父类中，把有差异的代码放在子类中去实现。");
        System.out.println("DishOne继承自AbstractDish, 实现了AbstracDish中的getMaterials()方法，能够获取Dish中的原料。");
        System.out.println("返回的Material是一个HashMap，可以通过键值对的方式去访问材料的名字和数量，我们使用迭代器来访问材料列表中的所有材料及其数量");
        System.out.println("for (HashMap.Entry<String, Material> entry : dishOne1.getMaterials().entrySet()) {\n" +
                "   System.out.println(entry.getKey()+\" : \"+ entry.getValue());\n" +
                "}");
        System.out.println("DishOne1中的原料：");
        for (HashMap.Entry<String, Material> entry : dishOne1.getMaterials().entrySet()) {
            System.out.println(entry.getKey()+" : "+ entry.getValue().getAmount());
        }

        System.out.println(footer());
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
        steam, fried, doNothing
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
            default:{
                dishOne.setCookingMethod(new DoNothingMethod());
                break;
            }
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