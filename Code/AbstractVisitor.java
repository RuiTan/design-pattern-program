
import java.util.*;

/**
 * 
 */
public abstract class AbstractVisitor {

    /**
     * Default constructor
     */
    public AbstractVisitor() {
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