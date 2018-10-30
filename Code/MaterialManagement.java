
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
     * 
     */
    private static HashMap<String, Material> materialMap;

    public HashMap<String, Material> getMaterialMap() {
        return materialMap;
    }

    /**
     * 
     */
    private static MaterialManagement instance;

    /**
     * @return
     */
    public static MaterialManagement getInstance() {
        if (instance == null){
            instance = new MaterialManagement();
            materialMap = new HashMap<>();
        }
        return instance;
    }

    /**
     * @param name
     */
    public Material getMaterial(String name, int amount) {
        // TODO implement here
        if (materialMap.containsKey(name)){
            Material material = materialMap.get(name);
            if (material.getAmount() >= amount){
                material.setAmount(material.getAmount()-amount);
                System.out.println("原料'" + material.getName() + "'使用了" + amount + ",还剩" + material.getAmount());
            }else {
                System.out.println("原料'" + material.getName() + "'需要" + amount + ",仓库仅剩" + material.getAmount() + ",需要购入原料");
            }
            return material;
        }
        return null;
    }

    /**
     * @param materialName
     * @return
     */
    public int getMaterialAmount(String materialName) {
        // TODO implement here
        if (materialMap.containsKey(materialName)){
            return materialMap.get(materialName).getAmount();
        }
        else return -1;
    }

    /**
     * @param material
     */
    public void addMaterial(Material material) {
        // TODO implement here
        materialMap.put(material.getName(), material);
        System.out.println("新购入了原料'" + material.getName() + "',价格'RMB" + material.getPrice() + "',数量'" + material.getAmount() + "'");
    }

    /**
     * @param materialName
     */
    public void deleteMaterial(String materialName) {
        // TODO implement here
        materialMap.remove(materialName);
    }

    /**
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
     * @param materialName
     * @param amount
     */
    public void purchaseMaterial(String materialName, int amount) {
        // TODO implement here
        reduceMaterial(materialName, -amount);
    }

}