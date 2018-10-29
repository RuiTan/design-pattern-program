
import java.util.*;

/**
 * 
 */
public class Order {

    /**
     * Default constructor
     */
    public Order() {
    }

    /**
     * 
     */
    private List productList;

    /**
     * 
     */
    public IState state;




    /**
     * @return
     */
    public float getPrice() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public boolean createOrder() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public List getProductList() {
        // TODO implement here
        return null;
    }

    /**
     * @param Product 
     * @return
     */
    public boolean addProduct(void Product) {
        // TODO implement here
        return false;
    }

    /**
     * @param Product 
     * @return
     */
    public boolean deleteProduct(void Product) {
        // TODO implement here
        return false;
    }

    /**
     * @param State 
     * @return
     */
    public boolean setState(void State) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public IState getState() {
        // TODO implement here
        return null;
    }

}