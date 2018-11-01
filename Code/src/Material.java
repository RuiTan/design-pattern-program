
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
     * 原料数量
     */
    private int amount;

    /**
     * 原料价格
     */
    private Double price;

    /**
     * 原料名称
     */
    private String name;

    /**
     *
     * @param amount
     * @param price
     * @param name
     */
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
    public String getName() { return name; }

    /**
     * @return
     */
    public Double getPrice() { return price; }

    /**
     * @param price
     * @return
     */
    public boolean setPrice(Double price) { this.price = price; return true; }

    /**
     * @return
     */
    public int getAmount() { return amount; }

    /**
     * @param amount
     * @return
     */
    public boolean increaseAmount(int amount) {
        this.amount += amount;
        return true;
    }

    /**
     * @param amount
     * @return
     */
    public boolean decreaseAmount(int amount) {
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