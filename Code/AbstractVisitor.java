
import java.util.*;

/**
 * 
 */
public abstract class AbstractVisitor {

    /**
     * @param m
     */
    public abstract void visit(AbstractMeal m, String retract);

    /**
     * @param d
     */
    public abstract void visit(AbstractDish d, String retract);

}