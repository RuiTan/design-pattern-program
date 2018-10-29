
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
    public abstract void visit(Meal m);

    /**
     * @param d
     */
    public abstract void visit(Dish d);

}