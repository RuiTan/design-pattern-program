
import java.util.*;

/**
 * 
 */
public class PriceVisitor extends AbstractVisitor {

    /**
     * Default constructor
     */
    public PriceVisitor() {
    }

    /**
     * @param m
     */
    public void visit(Meal m) {
        // TODO implement here
    }

    /**
     * @param d
     */
    public void visit(Dish d) {
        // TODO implement here
    }

    /**
     * @param m
     */
    public abstract void visit(Meal m);

    /**
     * @param d
     */
    public abstract void visit(Dish d);

}