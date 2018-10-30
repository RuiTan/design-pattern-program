
import java.util.*;

/**
 * 
 */
public class SpicyDecorator extends AbstractDecorator {

    private AbstractDish dish;

    /**
     * Default constructor
     */
    public SpicyDecorator() {
    }

    /**
     * 
     */
    public void decorate() {
        // TODO implement here
    }

    @Override
    public HashMap getMaterials() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Double getPrice() {
        return null;
    }


    @Override
    public AbstractProduct clone() {
        return null;
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

}