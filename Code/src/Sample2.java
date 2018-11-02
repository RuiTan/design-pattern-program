import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Sample2{

    private DishOne dish_1;
    private DishOne dish_2;
    private DishOne dish_3;
    private DishOne dish_4;
    private DishOne dish_5;
    private DishOne dish_6;
    private HashMap<String, Integer> materials_1;
    private HashMap<String, Integer> materials_2;
    AbstractMeal meal_1;
    AbstractMeal meal_2;
    Waiter waiter_1;
    Customer customer_1;
    Customer customer_2;
    RestMediator rm;
    Menu menu;

    public void Initialize(){
        MaterialFactory factory = new MaterialFactory();
        menu = Menu.getInstance();
        factory.createMaterial(Sample.MaterialType.meat,2000,10.0,"Chicken");
        factory.createMaterial(Sample.MaterialType.meat,1000,20.0,"Beef");
        factory.createMaterial(Sample.MaterialType.meat,3000,15.0,"Pork");
        factory.createMaterial(Sample.MaterialType.vegetable,1000,10.0,"Cabbage");
        factory.createMaterial(Sample.MaterialType.vegetable,2000,13.0,"Lettuce");

        materials_1 = new HashMap<>();
        materials_1.put("Chicken", 5);
        materials_1.put("Lettuce", 8);

        materials_2 = new HashMap<>();
        materials_2.put("Beef", 10);
        materials_2.put("Cabbage", 10);

        dish_1 = createDish("Fried Chicken", 20.0, materials_1, Sample.CookingMethod.fried);
        dish_2 = createDish("Steam Chicken", 30.0, materials_1, Sample.CookingMethod.steam);
        dish_3 = createDish("Chicken Hamburger", 40.0, materials_1, Sample.CookingMethod.fried);
        dish_4 = createDish("Salad", 50.0, materials_2, Sample.CookingMethod.doNothing);
        dish_5 = createDish("Roasted Beef", 50.0, materials_2, Sample.CookingMethod.steam);

        meal_1 = getMeal(Sample.MealType.MealOne);
        meal_2 = getMeal(Sample.MealType.MealTwo);

        new MealOneBuilder().addDish(dish_1);
        new MealOneBuilder().addDish(dish_2);
        new MealTwoBuilder().addDish(dish_3);
        new MealTwoBuilder().addDish(meal_1);

        waiter_1 = new Waiter("Satomi");
        customer_1 = new Customer("Midori");
        customer_2 = new Customer("Yuki");

        rm = new RestMediator();
        rm.addRole(waiter_1);
        rm.addRole(customer_1);
        rm.addRole(customer_2);

        menu.printMenu();
    }
    public void SingletonSample() {
        System.out.println("Singleton");
        System.out.println("\nSingleton:Ensure a class only has one instance, and provide a global point of access to it.");
        System.out.println("Try to get two menu instances:");
        Menu menu_ = Menu.getInstance();
        System.out.println("Menu menu = Menu.getInstance() : Memory:(" + menu.toString() + ")");
        System.out.println("Menu menu_ = Menu.getInstance() : Memory:(" + menu_.toString() + ")");
        System.out.println("Are menu and menu_ the same?:" + (menu == menu_));
        System.out.println("menu details:");
        menu.printMenu();
        System.out.println("menu_ details:");
        menu_.printMenu();
        System.out.println("The same menu. Test Success！");
    }

    public void VisitorSample() {
        System.out.println("Visitor");
        System.out.println("\nVisitor:Represent an operation to be performed on the elements of an object structure.");
        System.out.println("In this case user visitor to visit dish and meal.");
        System.out.println("Use NameVisitor to show names of all meal:");
        new NameVisitor().visit(getMeal(Sample.MealType.MealOne), "");
        System.out.println("Use PriceVisitor to show price of all meal:");
        new PriceVisitor().visit(getMeal(Sample.MealType.MealOne), "");
        System.out.println("Use DetailVisitor to show details of all meal:");
        new DetailVisitor().visit(getMeal(Sample.MealType.MealOne), "");
        System.out.println("Visitor test Success!");
    }

    public void CompositeSample() {
        System.out.println("Composite");
        System.out.println("\nComposite:Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.");
        System.out.println("Dish is regarded to an individual object. Meal is regarded to a composition of objects");
        System.out.println("new MealOneBuilder().addDish(dishOne1);\n" + "new MealOneBuilder().addDish(dishOne2);\n"
                + "new MealTwoBuilder().addDish(dishOne3);\n" + "new MealTwoBuilder().addDish(meal1);");
        System.out.println("Meal_2 includes meal_1. Show meal_2:");
        new DetailVisitor().visit(getMeal(Sample.MealType.MealTwo), "");
        System.out.println("Individual objects and compositions are regarded equally. Test Success!");
    }

    public void FactorySample() {
        System.out.println("Factory");
        System.out.println("\nFactory:Define an interface for creating an object, but let subclasses decide which class to instantiate.");
        System.out.println("meal_1 and meal_2 are both types of AbstractMeal Class. But they are instances of different subclasses.");
        System.out.println("AbstractMeal meal1 = getMeal(Sample.MealType.MealOne);\n"
                + "AbstractMeal meal2 = getMeal(Sample.MealType.MealTwo);");
        System.out.println("meal_1 and meal_2 class types:");
        System.out.println("meal_1：" + meal_1.getClass());
        System.out.println("meal_2：" + meal_2.getClass());
        System.out.println("Created by Factory. Test Success!");
    }

    public void BuilderSample() {
        System.out.println("Builder");
        System.out.println(
                "\nBuilder:Separate the construction of a complex object from its representation so that the same construction process can create different representations.");
        System.out.println("The AbstractDish in AbstractMeal can be modified by another class implements IMealBuider.");
        System.out.println("Show meal_2:");
        new DetailVisitor().visit(getMeal(Sample.MealType.MealTwo), "");
        System.out.println("Add a dish to meal_2：new MealOneBuilder().addDish(dish_4);");
        new MealTwoBuilder().addDish(dish_4);
        System.out.println("Show meal_2 after:");
        new DetailVisitor().visit(getMeal(Sample.MealType.MealTwo), "");
        System.out.println("Add by Builder. Test Success!");
    }

    public void StateSample() {
        System.out.println("State");
        System.out.println(
                "\nState:Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.");
        System.out.println("Order has three states: Ready, Preparing, Done.");
        System.out.println("New an Order object：Order o=new Order(1);");
        Order o = new Order(1);
        System.out.println("Change its state：o.getState().doAction(o);");
        o.getState().doAction(o);
        System.out.print("Show the state now:");
        System.out.println(o.getState());
        System.out.println("State changes. Test Success!");
    }

    public void DecoratorSample() {
        System.out.println("Decorator");
        System.out
                .println("\nDecorator:Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.");
        System.out.println("AbstractDish has a decorator to extend its flavour.");
        System.out.println("Add a spicy dish to meal_1.");
        System.out.println("AbstractDish dish = new SpicyDecorator(dish_3);\nnew MealOneBuilder().addDish(dish);");
        AbstractDish dish = new SpicyDecorator(dish_3);
        new MealOneBuilder().addDish(dish);
        System.out.println("Show meal_1:");
        new DetailVisitor().visit(getMeal(Sample.MealType.MealOne), "");
        System.out.println("Add a sweet dish to meal_2:");
        System.out.println("dish = new SweetDecorator(dish_2);\nnew MealTwoBuilder().addDish(dish);");
        dish = new SweetDecorator(dish_2);
        new MealTwoBuilder().addDish(dish);
        System.out.println("Show meal_2:");
        new DetailVisitor().visit(getMeal(Sample.MealType.MealTwo), "");
        System.out.println("Extend flavour. Test Success!");
    }

    public void StrategySample() {
        System.out.println("Strategy");
        System.out.println(
                "\nStrategy:Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.");
        System.out.println("Use Strategy to decide how to make the dish.");
        materials_1.put("Beef", 50);
        System.out.println("Steam:");
        new DetailVisitor().visit(createDish("Steamed Beef", 30.0, materials_1, Sample.CookingMethod.steam), "");
        System.out.println("Fry:");
        AbstractDish dish = createDish("Fried Chicken", 30.0, materials_2, Sample.CookingMethod.fried);
        new DetailVisitor().visit(dish, "");
        System.out.println("Do nothing to the dish just now:");
        dish.setCookingMethod(new DoNothingMethod());
        new DetailVisitor().visit(dish, "");
        System.out.println("Different ways to make a dish. Test success!");
    }

    public void PrototypeSample() {
        System.out.println("Prototype");
        System.out.println(
                "\nPrototype:Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.");
        System.out.println("AbstractDish and AbstractMeal are implemented as Prototype. The prototype of them are placed in Menu.");
        System.out.println("Every product has a count to show how many times it has been cloned.");
        Menu.getInstance().printMenu();
        System.out.println("Create Meals:");
        System.out.println("AbstractMeal meal1 = getMeal(Sample.MealType.MealOne);\n"
                + "AbstractMeal meal2 = getMeal(Sample.MealType.MealTwo);\n"
                + "AbstractMeal meal3 = getMeal(Sample.MealType.MealTwo);");
        System.out.println("Creating the same meal above will use prototype. The count is:");
        System.out.println("MealTwo's count：" + MealTwo.count);
        System.out.println("dish_4 = createDish(\"Salad\", 50.0, materials, Sample.CookingMethod.doNothing);\n"
                + "dish_5 = createDish(\"Salad\", 50.0, materials, Sample.CookingMethod.steam);");
        System.out.println("Create the same dish will use prototype. The count is:");
        System.out.println("Salad's count:" + (((DishOne) Menu.getInstance().getPrototype().get("Salad")).getCount()));
        System.out.println("dish_6 = createDish(\"Salad\", 50.0, materials, Sample.CookingMethod.fried);");
        dish_6 = createDish("Salad", 50.0, materials_1, Sample.CookingMethod.fried);
        System.out.println("Salad's count:" + (((DishOne) Menu.getInstance().getPrototype().get("Salad")).getCount()));
        System.out.println("Clone from prototype. Test Success!");
    }

    public void IteratorSample() {
        System.out.println("Iterator");
        System.out.println(
                "\nIterator:Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.");
        System.out.println("Use Iterator to visit all materials.");
        System.out.println(
                "   Iterator iterator = MaterialManagement.getInstance().getMaterialMap().entrySet().iterator();\n"
                        + "   while (iterator.hasNext()){\n"
                        + "       System.out.print(\" \" + iterator.next().toString());\n" + "   }");
        Iterator iterator = MaterialManagement.getInstance().getMaterialMap().entrySet().iterator();
        System.out.println("The output：");
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next().toString());
        }
        System.out.println();
        System.out.println("Visit using Iterator. Test Success!");
    }

    public void FlyweightSample() {
        System.out.println("Flyweight");
        System.out.println(
                "\nFlyweight:Use sharing to support large numbers of fine-grained objects efficiently.");
        System.out.println("Material objects in this instance are flyweight. Materials used to make dishes with the same name are actually the same object.");
        System.out.println("Beef in dish_1：" + dish_1.getMaterials().get("Chicken"));
        System.out.println("Beef in dish_2" + dish_2.getMaterials().get("Chicken"));
        dish_1.getMaterials().get("Chicken").decreaseAmount(1);
        System.out.println("Only decrease the amount in dish_1:");
        System.out.println("Beef in dish_1" + dish_1.getMaterials().get("Chicken"));
        System.out.println("Beef in dish_2:" + dish_2.getMaterials().get("Chicken"));
        System.out.println("Test Success!");
    }

    public void TemplateMethodSample() {
        System.out.println("TemplateMethod");
        System.out.println(
                "\nTemplateMethod:Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.");
        System.out.println("DishOne extends AbstractDish and implements AbstractDish's getMaterials().");
        System.out.println("The method returns a HashMap. We can use key and value to get materials.");
        System.out.println("for (HashMap.Entry<String, Material> entry : dish_1.getMaterials().entrySet()) {\n"
                + "   System.out.println(entry.getKey()+\" : \"+ entry.getValue());\n" + "}");
        System.out.println("Materials in dish_1");
        for (HashMap.Entry<String, Material> entry : dish_1.getMaterials().entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getAmount());
        }

        System.out.println("Implement the abstract function. Test Success!");
    }

    public void AdapterSample(){
        System.out.println("Adapter");
        System.out.println("\nAdaptor:Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.");
        System.out.println("Cook() in cooker can adapt operate() in Sample.CookingMethod of Dish.");
        System.out.println("Create interface including cook()");
        DishOne d=new DishOne("Hot dog",100.0);
        System.out.println("\nNew a DishOne d=new DishOne(\" Hot dog \",100.0);");
        d.setCookingMethod(new FriedMethod());
        System.out.println("\nSample.CookingMethod: d.setCookingMethod(new FriedMethod());");
        System.out.println("\nCookerAdapter implements Target to transfer operate() of Sample.CookingMethod into pan's cook()");
        System.out.println("\nCookerAdapter adapter=new CookerAdapter(d.getSample.CookingMethod().operate());");
        CookerAdapter adapter=new CookerAdapter(d.getCookingMethod().operate());
        System.out.println("\nCall cook(): adapter.cook()");
        adapter.cook();
        System.out.println("Transfer success. Test completes!");
    }

    public void MediatorSample(){
        System.out.println("Mediator");
        System.out.println("\nMediator:Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.");
        System.out.println("RestMediator extends Mediator and implents Mediator的notify() to notify others and chat() to have a conversation.");
        System.out.println("New a waiter, two customers whose class extends both from Role.");
        System.out.println("New a RestMediator. Add the roles into it");
        System.out.println("Waiter asks two customers what to eat:rm.notify(waiter1);");
        waiter_1.setContent("\nHi, what do you want？");
        customer_1.setContent("Pork Rice.");
        customer_2.setContent("Beef Rice");
        rm.notify(waiter_1);
        System.out.println("\nAnd then two customers are chatting:rm.chat(customer_1,customer_2);");
        customer_1.setContent("The weather is good today.");
        customer_2.setContent("Yes. But I prefer staying home.");
        rm.chat(customer_1,customer_2);
    }
    public void AbstractFactorySample() {
        System.out.println("AbstractFactory");
        System.out.println("\nAbstractFactory:Provide an interface for creating families of related or dependent objects without specifying their concrete classes.");
        System.out.println("In this case, the creation of materials and cookers are all Factory. So we make AbstractFactory of these two.");
        CookerFactory cookerFactory = AbstractFactory.getCookerFactory();
        AbstractCooker cooker_1 = cookerFactory.createCooker(Sample.CookerType.Fryer);
        AbstractCooker cooker_2 = cookerFactory.createCooker(Sample.CookerType.Pan);
        MaterialFactory materialFactory = AbstractFactory.getMaterialFactory();
        Material material_1 = materialFactory.createMaterial(Sample.MaterialType.meat, 10000, 50.0, "Salmon");
        Material material_2 = materialFactory.createMaterial(Sample.MaterialType.vegetable, 50000, 1.6, "Cucumber");
        System.out.println("CookerFactory cookerFactory = AbstractFactory.getCookerFactory();\n" +
                "AbstractCooker cooker_1 = cookerFactory.createCooker(Sample.CookerType.Fryer);\n" +
                "AbstractCooker cooker_2 = cookerFactory.createCooker(Sample.CookerType.Pan);\n" +
                "MaterialFactory materialFactory = AbstractFactory.getMaterialFactory();\n" +
                "Material material_1 = materialFactory.createMaterial(Sample.MaterialType.meat, 10000, 50.0, \"Salmon\");\n" +
                "Material material_2 = materialFactory.createMaterial(Sample.MaterialType.vegetable, 50000, 1.6, \"Cucumber\");");
        System.out.println("Get factory from AbstractFactory. Test Success!");
    }

    public void ObservorSample() {
        System.out.println("Observer");
        System.out.println("\nObserver:Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.");
        new MealOneBuilder().addDish(dish_1);
        System.out.println("Meal_1 includes dish_1.");
        System.out.println("Show meal_1:");
        System.out.println(meal_1.getName() + " : " + meal_1.getPrice());
        System.out.println("Now set a new price to dish_1.");
        dish_1.setPrice(15.0);
        System.out.println("Show meal_1 again:");
        System.out.println(meal_1.getName() + " : " + meal_1.getPrice());
        System.out.println("Use Observer to change. Test Success!");
    }

    public void InterpreterSample(){
        System.out.println("InterpreterMethod");
        System.out.println("\nInterpreterMethod:Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.");
        System.out.println("The material lists of Sushi：");
        dish_6 = createDishByMaterials("Sushi", materials_1, Sample.CookingMethod.doNothing);
        System.out.println("Price of sushi" + dish_6.getPrice());
        System.out.println("Materials of sushi");
        for (HashMap.Entry<String, Material> entry : dish_6.getMaterials().entrySet()) {
            System.out.println(entry.getKey()+" : "+ entry.getValue().getAmount() + ",Price : " + entry.getValue().getPrice());
        }
        System.out.println("Test Success!");
    }

    public void BridgeSample(){
        System.out.println("Bridge");
        System.out.println("\nBridge:Decouple an abstraction from its implementation so that the two can vary independently.");
        System.out.println("DishOne extends AbstractDish and implements AbstractDish's flavor() which add flavor to the dish.");
        DishOne spicyDishOne = new DishOne(new SpicyDish());
        DishOne sweetDishOne = new DishOne(new SweetDish());
        DishOne saltyDishOne = new DishOne(new SaltyDish());
        spicyDishOne.flavor();
        sweetDishOne.flavor();
        saltyDishOne.flavor();
        System.out.println("Test Success!");
    }

    public void CommandSample(){
        System.out.println("Command");
        System.out.println("\nCommand:Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.");
        CookerManagement cm = CookerManagement.getInstance();
        UseCookerCommand use_cmd = new UseCookerCommand(cm);
        FreeCookerCommand free_cmd = new FreeCookerCommand(cm);
        CommandInvoker invoker = new CommandInvoker(use_cmd);
        Pan pan1 = new Pan();
        Pan pan2 = new Pan();
        System.out.println("Use two pans of cooker:");
        invoker.cookerManagementCall(pan1);
        invoker.cookerManagementCall(pan2);
        System.out.println("Release a pan cooker:");
        invoker.setCommand(free_cmd);
        invoker.cookerManagementCall(pan1);
        System.out.println("Test Success!");
    }

    public void MenuMementoSample() {
        System.out.println("Memento");
        System.out.println("\nMemento:Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.");
        System.out.println("As an instance, Menu implements undo() and redo(), which reliase the record and recovery of adding and deletions of product in menu.");
        Menu menu = Menu.getInstance();
        menu.printMenu();
        menu.deleteProduct("Fried Chicken");
        menu.printMenu();
        menu.deleteProduct("Steamed Chicken");
        menu.undo();
        menu.undo();
        menu.printMenu();
        menu.redo();
        menu.redo();
        menu.redo();
        menu.printMenu();
        System.out.println("Redo and undo success. Test Completes!");
    }
    public void FacadeSample(){
        System.out.println("Facade");
        System.out.println("\nFacade:Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.");
        System.out.println("Kitchenmnagement provides a unified interface for cooking Dish:boolean cooking(AbstractDish dish)");
        System.out.println("From outside it seems like just one interface. But actually it's a set of interfaces.");
        KitchenManagement management = KitchenManagement.getInstance();
        System.out.println("Use it to cook dish_1. management.cooking(dish_1)");
        management.cooking(dish_1);
        System.out.println("Use the interface successfully. Test Completes!");

    }
//
//    /**
//     * 原料类型
//     */
//    public enum MaterialType {
//        meat, vegetable
//    }
//
//    /**
//     * 制作方法
//     */
//    public enum CookingMethod {
//        steam, fried, doNothing
//    }
//
//    /**
//     * Meal种类
//     */
//    public enum MealType {
//        MealOne, MealTwo
//    }
//
//    public enum CookerType {
//        Pan, Fryer, Steamer, MicroWave
//    }

    /**
     * 创建一种套餐
     *
     * @param type
     * @return
     */
    public AbstractMeal getMeal(Sample.MealType type) {
        Menu menu = Menu.getInstance();
        switch (type) {
            case MealOne: {
                AbstractProduct product = menu.findAndClone(MealOne.DEFAULTNAME);
                if (!(product instanceof MealOne)) {
                    return new MealOne(MealOne.DEFAULTNAME);
                } else {
                    return (MealOne) product;
                }
            }
            case MealTwo: {
                AbstractProduct product = menu.findAndClone(MealTwo.DEFAULTNAME);
                if (!(product instanceof MealTwo)) {
                    return new MealTwo(MealTwo.DEFAULTNAME);
                } else {
                    return (MealTwo) product;
                }
            }
            default: {
                return null;
            }
        }
    }


    /**
     * 获得原料，总量将从仓库减少
     *
     * @param name
     * @param amount
     * @return
     */
    public Material getMaterial(String name, int amount) {
        MaterialManagement instance = MaterialManagement.getInstance();
        return instance.getMaterial(name, amount);
    }

    /**
     * 创建一种DishOne的菜
     *
     * @param name
     * @param price
     * @param materials
     * @return
     */
    public DishOne createDish(String name, Double price, HashMap<String, Integer> materials, Sample.CookingMethod method) {
        DishOne dishOne = new DishOne(name, price);
        ArrayList<Material> materialArrayList = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : materials.entrySet()) {
            materialArrayList.add(getMaterial(entry.getKey(), entry.getValue()));
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
        return dishOne;
    }

    /**
     * 查看原料仓库
     */
    public void showMaterials() {
        MaterialManagement instance = MaterialManagement.getInstance();
        HashMap<String, Material> materialMap = instance.getMaterialMap();
        for (HashMap.Entry material : materialMap.entrySet()) {
            System.out.println(material.getValue().toString());
        }
    }


    /**
     * 利用原材料构建一个菜的实例
     * @param name
     * @param materials
     * @param method
     * @return
     */
    public DishOne createDishByMaterials(String name, HashMap<String, Integer> materials, Sample.CookingMethod method){

        MaterialManagement instance = MaterialManagement.getInstance();
        HashMap<String, Material> materialHashMap = instance.getMaterialMap();
        ArrayList<String> namelist = new ArrayList<>();

        //从原料表中获取所有需要的原料名并存入list
        Iterator iter = materials.entrySet().iterator();
        while (iter.hasNext()){
            HashMap.Entry entry = (HashMap.Entry) iter.next();
            String dishName = (String) entry.getKey();
            namelist.add(dishName);
        }

        //利用解释器模式计算菜品的价格
        int i = 0;
        double price = 0.0;
        while (i < namelist.size()){
            String name0 = namelist.get(i);
            i++;
            if (i==namelist.size()){//菜品个数为单数
                price += new PriceExpression(name0,materials.get(name0)).interpret(materialHashMap);//计算价格时使用食材单价乘以食材数量
            }
            else {//菜品个数为双数
                String name1 = namelist.get(i);
                i++;
                IExpression expression = new AddExpression(new PriceExpression(name0, materials.get(name0)), new PriceExpression(name1, materials.get(name1)));
                price += expression.interpret(materialHashMap);
            }
        }

        price *= 2.5;


        DishOne dishOne = new DishOne(name, price); //根据名字和价格创建一个dishOne对象
        ArrayList<Material> materialArrayList = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : materials.entrySet()){
            materialArrayList.add(getMaterial(entry.getKey(), entry.getValue()));
        }
        dishOne.setMaterials(materialArrayList);//设置菜品原材料列表

        //设置菜品的制作方法
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

}