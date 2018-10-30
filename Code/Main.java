
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String []args){
        AbstractMeal meal1 = getMeal("MEALONE");
        AbstractMeal meal2 = getMeal("MEALTWO");
        createMaterial(MaterialType.meat, 100,  10.0, "牛肉");
        createMaterial(MaterialType.meat, 800,  20.0, "羊肉");
        createMaterial(MaterialType.meat, 500,  8.0, "猪肉");
        createMaterial(MaterialType.vegetable, 50,  1.0, "小青菜");
        createMaterial(MaterialType.vegetable, 20,  2.0, "大白菜");

        showMaterials();

        /**
         * 创建一盘牛肉炒青菜
         */
        HashMap<String, Integer> materials = new HashMap<>();
        materials.put("牛肉", 50);
        materials.put("小青菜", 5);
        DishOne dishOne = createDish("牛肉炒青菜", 50.0, materials, CookingMethod.fried);

        /**
         * 加到套餐1中去
         */
        new MealOneBuilder().addDish(dishOne);

        /**
         * 查看套餐1详情
         */
        new PriceVisitor().visit(meal1, "");

        /**
         * 创建一盘猪肉炒青菜
         */
        HashMap<String, Integer> materials2 = new HashMap<>();
        materials2.put("猪肉", 20);
        materials2.put("小青菜", 3);
        DishOne dishOne2 = createDish("猪肉炒青菜", 30.0, materials2, CookingMethod.steam);

        /**
         * 加到套餐2中
         */
        new MealTwoBuilder().addDish(meal1);
        new MealOneBuilder().addDish(dishOne2);

        /**
         * 查看套餐2详情
         */
        new PriceVisitor().visit(meal2, "");

        showMaterials();
    }

    /**
     * 原料类型
     */
    private static enum MaterialType {
        meat, vegetable
    }

    /**
     * 制作方法
     */
    private static enum CookingMethod{
        steam, fried
    }

    /**
     * 创建一种套餐
     * @param mealName
     * @return
     */
    private static AbstractMeal getMeal(String mealName){
        return AbstractMeal.findAndClone(mealName);
    }

    /**
     * 添加原料，仅当仓库无该原料时添加
     * @param t
     * @param amount
     * @param price
     * @param name
     * @return
     */
    private static void createMaterial(MaterialType t, int amount, Double price, String name){
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
    private static Material getMaterial(String name, int amount){
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
    private static DishOne createDish(String name, Double price, HashMap<String, Integer> materials, CookingMethod method){
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
    private static void showMaterials(){
        MaterialManagement instance = MaterialManagement.getInstance();
        HashMap<String, Material> materialMap = instance.getMaterialMap();
        for (HashMap.Entry material : materialMap.entrySet()){
            System.out.println(material.getValue().toString());
        }
    }



}
