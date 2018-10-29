
import java.util.*;

/**
 * 
 */
public abstract class AbstractDecorator extends AbstractDish {

    /**
     * Default constructor
     */
    public AbstractDecorator() {
    }

    /**
     * 
     */
    private AbstractDish dish;

    /**
     * 
     */
    public void decorate() {
        // TODO implement here
    }

    /**
     * @return
     */
    public abstract List getMaterials();

}