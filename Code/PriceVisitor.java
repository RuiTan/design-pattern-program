
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
    public void visit(AbstractMeal m) {
        // TODO implement here
    }

    /**
     * @param d
     */
    public void visit(AbstractDish d) {
        // TODO implement here
    }

    /**
     * @param m
     */
    public abstract void visit(AbstractMeal m);

    /**
     * @param d
     */
    public abstract void visit(AbstractDish d);

}