
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

        String builder = retract +
                "套餐名 : " + m.getName() + ", " + "套餐价格 : " + m.getPrice() + "\n" +
                retract +
                "套餐内容 : \n";
        System.out.print(builder);
        for (HashMap.Entry<String, AbstractProduct> productEntry : m.getDishes().entrySet()){
            productEntry.getValue().accept(this, retract+"  ");
        }
    }

    /**
     * @param d
     */
    public void visit(AbstractDish d, String retract) {
        System.out.println(d.toString());
    }

}