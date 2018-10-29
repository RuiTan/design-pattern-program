
import java.util.*;

/**
 * 
 */
public class MaterialManagement {

    /**
     * Default constructor
     */
    public MaterialManagement() {
    }

    /**
     * 
     */
    private static HashMap<String, Material> materialmap;

    /**
     * 
     */
    private static MaterialManagement instance;




    /**
     * @return
     */
    public static MaterialManagement getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    private void MaterialManagement() {
        // TODO implement here
    }

    /**
     * @param name
     */
    public void getMaterial(String name) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Map<String, Material> getMaterialsMap() {
        // TODO implement here
        return null;
    }

    /**
     * @param materialName
     * @return
     */
    public int getMaterialAmount(String materialName) {
        // TODO implement here
        return 0;
    }

    /**
     * @param material
     */
    public void addMeterial(Material material) {
        // TODO implement here
    }

    /**
     * @param materialName
     */
    public void deleteMaterial(String materialName) {
        // TODO implement here
    }

    /**
     * @param materialName
     * @param amount
     */
    public void reduceMaterial(String materialName, int amount) {
        // TODO implement here
    }

    /**
     * @param materialName
     * @param amount
     */
    public void purchaseMaterial(String materialName, int amount) {
        // TODO implement here
    }

}