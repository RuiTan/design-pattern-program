import java.util.ArrayList;
import java.util.HashMap;

public class DishOne extends AbstractDish {

    /**
     * 此菜系的基本信息
     */
    private String name;
    private Double price;
    private int count = 1;
    /**
     * 菜需要的原料
     */
    private HashMap<String, Material> materialList;

    public DishOne(){

    }

    public void addCount() {
        count++;
    }

    public int getCount(){
        return count;
    }

    /**
     *  构造函数
     * @param name
     * @param price
     */
    public DishOne(String name, Double price) {
        AbstractProduct product = Menu.getInstance().findAndClone(name);
        if (product instanceof DishOne){
            this.name = product.getName();
            this.price = price;
            this.materialList = ((DishOne) product).getMaterials();
        }
        else {
            this.name = name;
            this.price = price;
            this.materialList = new HashMap<>();
            Menu.getInstance().addProduct(this);
        }
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
