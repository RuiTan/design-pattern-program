
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
    public void visit(AbstractMeal m, String retract) {
        String builder =  retract + m.getName() + "(套餐) —— " + m.getPrice() + "元 : ";
        System.out.println(builder);
        for (HashMap.Entry<String, AbstractProduct> entry : m.getDishes().entrySet()){
            entry.getValue().accept(this, retract+"  ");
        }
    }

    /**
     * @param d
     */
    public void visit(AbstractDish d, String retract) {
        System.out.println(retract + d.getName() + " —— " + d.getPrice());
    }

}
