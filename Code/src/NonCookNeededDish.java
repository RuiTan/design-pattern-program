
import java.util.*;

/**
 * 
 */
public class NonCookNeededDish extends AbstractDish {
    
    /*bridge design pattern start*/
    public void flavor(){
    }
    /*bridge design pattern end*/


    /**
     * Default constructor
     */
    public NonCookNeededDish() {
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
    public AbstractProduct clone() {
        return null;
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {

    }

}