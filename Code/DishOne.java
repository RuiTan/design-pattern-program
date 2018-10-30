import java.util.ArrayList;
import java.util.HashMap;

public class DishOne extends AbstractDish {

    /**
     * 此菜系的基本信息
     */
    private String name;
    private Double price;
    /**
     * 菜需要的原料
     */
    private HashMap<String, Material> materialList;

    /**
     *  构造函数
     * @param name
     * @param price
     */
    public DishOne(String name, Double price) {
        this.name = name;
        this.price = price;
        this.materialList = new HashMap<>();
    }

    /**
     *
     * @return 原料
     */
    @Override
    public HashMap<String, Material> getMaterials() {
        return materialList;
    }

    /**
     *
     * @param materials 添加菜需要的原料
     */
    public void setMaterials(ArrayList<Material> materials){
        for (Material material : materials){
            materialList.put(material.getName(), material);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }


    @Override
    public AbstractProduct clone() {
        return null;
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

}
