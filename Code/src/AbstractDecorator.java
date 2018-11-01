
import java.util.*;

/**
 * 
 */
public abstract class AbstractDecorator extends AbstractDish {

    /*bridge design pattern start*/
    public void flavor(){
    }
    /*bridge design pattern end*/


    public AbstractDecorator(AbstractDish dish){
        this.setDish(dish);
        this.setCookingMethod(dish.cookingMethod);
        this.setState(dish.state);
        decorate();
    }

    /**
     * 
     */
    public abstract void decorate();

    public abstract String getDecorate();

    public abstract AbstractDish getDish();

    public abstract void setDish(AbstractDish dish);

    public void setCookingMethod(ICookingMethod method){
        this.cookingMethod = method;
    };

    public boolean setState(IState state){
        this.state = state;
        return true;
    };

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        String s = super.toString();
        s = s + ", 口味 : " + getDecorate();
        return s;
    }


    @Override
    public HashMap<String, Material> getMaterials() {
        return getDish().getMaterials();
    }

    @Override
    public String getName() {
        return getDish().getName();
    }

    @Override
    public Double getPrice() {
        return getDish().getPrice();
    }

    @Override
    public void accept(AbstractVisitor visitor, String retract) {
        visitor.visit(this, retract);
    }

}