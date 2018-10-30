
import java.util.*;

/**
 * 
 */
public class MaterialManagement {

    /**
     * Default constructor
     */
    private MaterialManagement() {
    }

    /**
     * 原料的Map
     */
    private static HashMap<String, Material> materialMap;

    /**
     *
     * @return 返回原料的Map
     */
    public HashMap<String, Material> getMaterialMap() {
        return materialMap;
    }

    /**
     * MaterialManagement的单例
     */
    private static MaterialManagement instance;

    /**
     * @return 获取单例
     */
    public static MaterialManagement getInstance() {
        if (instance == null){
            instance = new MaterialManagement();
            materialMap = new HashMap<>();
        }
        return instance;
    }

    /**
     * 获取一定数量的某原料，会在仓库中减去相应量
     * @param name
     * @param amount
     */
    public Material getMaterial(String name, int amount) {
        // TODO implement here
        if (materialMap.containsKey(name)){
            Material material = materialMap.get(name);
            if (material.getAmount() >= amount){
                reduceMaterial(name, amount);
                System.out.println("原料'" + material.getName() + "'使用了" + amount + ",还剩" + material.getAmount());
            }else {
                System.out.println("原料'" + material.getName() + "'需要" + amount + ",仓库仅剩" + material.getAmount() + ",需要购入原料");
                return null;
            }
            return material;
        }
        return null;
    }

    /**
     * 获取某原料的数量
     * @param materialName 原料名
     * @return 当原料不存在时返回-1
     */
    public int getMaterialAmount(String materialName) {
        // TODO implement here
        if (materialMap.containsKey(materialName)){
            return materialMap.get(materialName).getAmount();
        }
        else return -1;
    }

    /**
     * 新购入某种原料
     * @param material
     */
    public void addMaterial(Material material) {
        // TODO implement here
        materialMap.put(material.getName(), material);
        System.out.println("新购入了原料'" + material.getName() + "',价格'RMB" + material.getPrice() + "',数量'" + material.getAmount() + "'");
    }

    /**
     * 删除某原料
     * @param materialName
     */
    public void deleteMaterial(String materialName) {
        // TODO implement here
        materialMap.remove(materialName);
    }

    /**
     * 减少原料的数量
     * @param materialName
     * @param amount
     */
    public void reduceMaterial(String materialName, int amount) {
        // TODO implement here
        if (materialMap.containsKey(materialName)){
            materialMap.get(materialName).setAmount(materialMap.get(materialName).getAmount() - amount);
        }
    }

    /**
     * 增加原料的数量
     * @param materialName
     * @param amount
     */
    public void purchaseMaterial(String materialName, int amount) {
        // TODO implement here
        reduceMaterial(materialName, -amount);
    }

}