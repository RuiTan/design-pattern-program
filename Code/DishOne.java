import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DishOne extends AbstractDish {

    private String name;
    private Double price;

    public DishOne(String name, Double price) {
        this.name = name;
        this.price = price;
        this.materialList = new HashMap<>();
    }

    /**
     *
     */
    private HashMap<String, Material> materialList;

    @Override
    public HashMap<String, Material> getMaterials() {
        return materialList;
    }

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
