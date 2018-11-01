
import java.util.*;

/**
 * 
 */
public class Vegetable extends Material {


    private String type = "Vegetable";
    /**
     * Default constructor
     */
    public Vegetable() {
    }

    public Vegetable(int amount, Double price, String name) {
        super(amount, price, name);
    }

    /**
     * @return
     */
    public String getName() {
        return super.getName();
    }

    /**
     * @return
     */
    public Double getPrice() {
        
        return super.getPrice();
    }

    /**
     * @return
     */
    public int getAmount() {
        
        return super.getAmount();
    }

    public String getType() {
        return type;
    }
}