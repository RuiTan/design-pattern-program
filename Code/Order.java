
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
     * @param product
     * @return
     */
    public boolean addProduct(AbstractProduct product) {
        // TODO implement here
        return false;
    }

    /**
     * @param product
     * @return
     */
    public boolean deleteProduct(AbstractProduct product) {
        // TODO implement here
        return false;
    }

    /**
     * @param state
     * @return
     */
    public boolean setState(IState state) {
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