
import java.util.*;

/**
 * 
 */
public class SpicyDecorator extends AbstractDecorator {

    @Override
    public AbstractDish getDish() {
        return dish;
    }

    @Override
    public void setDish(AbstractDish dish) {
        this.dish = dish;
    }

    private AbstractDish dish;

    private String decorate = "辣";

    /**
     * Default constructor
     */
    public SpicyDecorator(AbstractDish dish) {
        super(dish);
    }

    /**
     * 
     */
    @Override
    public void decorate() {
        System.out.println(dish.getName() + " : 已设置为辣的口味");
    }

    @Override
    public String getDecorate() {
        return decorate;
    }

    @Override
    public void flavor() {

    }

    @Override
    public Boolean setPrice(Double newPrice) {
        return false;
    }

    @Override
    public AbstractProduct clone() {
        return new SpicyDecorator(dish);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}