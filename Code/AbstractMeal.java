
import java.util.*;

/**
 * 
 */
public abstract class AbstractMeal extends AbstractProduct {

    private String name;
    private Double price;

    /**
     * Default constructor
     */
    public AbstractMeal() {
    }

    /**
     * 
     */
    private List dishList;


    /**
     * 
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 
     */
    public void accept() {
        // TODO implement here
    }
    /**
     * @return
     */
    public abstract AbstractProduct clone();

}