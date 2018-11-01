
import java.util.*;

/**
 * 
 */
public class NonCookNeededDish extends AbstractDish {

    protected NonCookNeededDish(FlavorAPI flavorAPI) {
        super(flavorAPI);
    }

    @Override
    public void flavor() {

    }

    /**
     * @return
     */
    public HashMap<String, Material> getMaterials() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Double getPrice() {
        return null;
    }

    @Override
    public Boolean setPrice(Double newPrice) {
        return null;
    }

    @Override
    public AbstractProduct clone() {
        return null;
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {

    }

}