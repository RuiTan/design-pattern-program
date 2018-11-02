import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

import com.sun.prism.Material;

import java.io.*;

import Sample.CookingMethod;
import jdk.internal.jline.internal.InputStreamReader;

public class Main {
    private static ArrayList<Vector<String>> orderList = new ArrayList<Vector<String>>();
    private static FinanceSystem cashier = new FinanceSystem(1000.0);
    public static void main() {
        initMensa();
        while(1) {
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

    public static void purchaseMaterials() {
        /* 用户在循环中输入需要的材料和数量，
        系统会判断是否有足够的金额去购买这些材料，如果足够，购买，不够则报错，继续循环。
        直到用户输入指定的终止符号结束采购。*/
    }

    public static void createMaterials(String name, Double price) {
        //· 每次创建一个材料，输入材料的名称和价格
    }

    public static void createDishes() {
        // 让用户输入菜名和烹饪方法，然后打印现有的材料列表，让用户进行选择组合，最后以-1（或者特定的符号）结束选择，判断是否有足够的材料来完成这道菜。如果有调用接口创建菜品，没有则报错。
        //input dish's name
        MaterialManagement materialManagement = MaterialManagement.getInstance();
        HashMap<String,Material> materialMap = materialManagement.getMaterialMap();
        Menu menu = Menu.getInstance();
        Scanner sc = new Scanner(new Scanner(System.in));
        while(true){
            System.out.println("请输入你要添加的菜名： (输入q结束)");
            String name = (String)sc.next();
            if(name.toLowerCase().equals("q")){
                break;
            }
            //input dish's cooking method
            System.out.println("请输入该菜品所需的烹饪方法： (输入q结束)");
            String cookingMethod = (String)sc.next(); 
            if(cookingMethod.toLowerCase().equals("q")){
                break;
            }
            //print material list 
            System.out.println("现有的材料列表如下： ");
            Iterator<E> iter = materialMap.entrySet().iterator();
            Vector<String> materialList = new Vector<String>();
            Map materials = new HashMap<String,Integer>();
            Integer No = 1;
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = (String)entry.getKey();
                Object value = entry.getValue();
                materialList.add((String)key);
                System.out.println(No.toString,". ",key);
                No +=  1;
            }
            //select material 
            Double price = 0.0;
            System.out.println("请输入需要的材料序号及其用量,用空格隔开,输入-1结束）：");
            Integer matNum = 1;
            Integer size = materialList.size();
            while(sc.hasNextInt() && (matNum = sc.nextInt()) != -1){
                if(sc.hasNextInt()){
                    matAmount = sc.nextInt();
                    if(matNum > 0 && matNum <= size && matAmount > 0){
                        String selectedName = materialList.get(matNum-1);
                        Material selectedMat = materialMap.get(selectedName);
                        price += selectedMat.getPrice()*matAmount;
                        materialList.put(selectedName,matAmount);
                    }
                }else{
                    break;
                }
            }
            //check if the material is enough 
            //create the dish
            price *= 2.5;
            DishOne dishOne = new DishOne(name, price);
            ArrayList<Material> materialArrayList = new ArrayList<>();
            for (HashMap.Entry<String, Integer> entry : materials.entrySet()) {
                materialArrayList.add(getMaterial(entry.getKey(), entry.getValue()));
            }
            dishOne.setMaterials(materialArrayList);
            switch (cookingMethod) {
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
          Scanner sc = new Scanner(new Scanner(System.in));
          while(true){
            System.out.println("请输入你要添加的套餐名： (输入q结束)");
            String name = (String)sc.next();
            if(name.toLowerCase().equals("q")){
                break;
            }
            //print dish list 
            System.out.println("现有的菜品列表如下： ");
            HashMap<String,AbstractProduct> productMap = menu.getPrototype();
            Iterator<E> iter = productMap.entrySet().iterator();
            Vector<String> dishList = new Vector<String>();
            Map dishes = new HashMap<String,AbstractProduct>();
            Integer No = 1;
            while(iter.hasNext()){
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = (String)entry.getKey();
                Object value = entry.getValue();
                dishList.add((String)key);
                System.out.println(No.toString,". ",key);
                No +=  1;
            }
            //select dish 
          //   Double price = 0.0;
            System.out.println("请输入需要的菜品序号，用空格隔开,输入-1结束）：");
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
                }
            }
            //create the meal
          //   price *= 2.5;
          if(dishes.isEmpty()){
              continue;
          }
            MealOne mealOne = new MealOne(name);
            mealOne.addDishes(dishes);
            //add the dish to menu 
            menu.addProduct(mealOne);
          }
    }

}