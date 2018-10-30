
import java.util.*;

/**
 * 
 */
public class Material {

    /**
     * Default constructor
     */
    public Material() {
    }

    /**
     * 
     */
    private int amount;

    /**
     * 
     */
    private Double price;

    /**
     * 
     */
    private String name;


    public Material(int amount, Double price, String name) {
        this.amount = amount;
        this.price = price;
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return name;
    }

    /**
     * @return
     */
    public Double getPrice() {
        // TODO implement here
        return price;
    }

    /**
     * @param price
     * @return
     */
    public boolean setPrice(Double price) {
        // TODO implement here
        this.price = price;
        return true;
    }

    /**
     * @return
     */
    public int getAmount() {
        // TODO implement here
        return amount;
    }

    /**
     * @param amount
     * @return
     */
    public boolean increaseAmount(int amount) {
        // TODO implement here
        this.amount += amount;
        return true;
    }

    /**
     * @param amount
     * @return
     */
    public boolean decreaseAmount(int amount) {
        // TODO implement here
        if (amount > this.amount){
            return false;
        }
        this.amount -= amount;
        return true;
    }

    @Override
    public String toString(){
        return "[" + amount + "," + price + "," + name + "]";
    }

}