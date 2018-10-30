
import java.util.*;

/**
 * 
 */
public class meat extends Material {

    private String type = "meat";

    /**
     * Default constructor
     */
    public meat() {
    }

    public meat(int amount, Double price, String name){
        super(amount, price, name);
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return super.getName();
    }

    /**
     * @return
     */
    public Double getPrice() {
        // TODO implement here
        return super.getPrice();
    }

    /**
     * @return
     */
    public int getAmount() {
        // TODO implement here
        return super.getAmount();
    }


    public String getType(){
        return type;
    }
}