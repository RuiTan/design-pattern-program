
import java.util.*;

/**
 * 
 */
public class MaterialFactory {

    /**
     * Default constructor
     */
    public MaterialFactory() {

    }

    /**
     * 添加原料，仅当仓库无该原料时添加
     * @param t
     * @param amount
     * @param price
     * @param name
     * @return
     */
    public Material createMaterial(Sample.MaterialType t, int amount, Double price, String name){
        MaterialManagement instance =  MaterialManagement.getInstance();
        Material material;
        switch (t){
            case meat:{
                material = new meat(amount, price, name);
                instance.addMaterial(material);
                break;
            }
            case vegetable:{
                material = new Vegetable(amount, price, name);
                instance.addMaterial(material);
                break;
            }
            default:{
                material = new Material(amount, price, name);
                instance.addMaterial(material);
                break;
            }
        }
        return material;
    }

}