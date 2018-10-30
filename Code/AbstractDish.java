
import java.util.*;

/**
 * 
 */
public abstract class AbstractDish extends AbstractProduct {

    /**
     * 
     */
    public ICookingMethod cookingMethod;

    /**
     * 
     */
    public IState state;


    /**
     * @return
     */
    public abstract HashMap<String, Material> getMaterials();

    /**
     * @return
     */
    public ICookingMethod getCookingMethod() {
        return cookingMethod;
    }

    /**
     *
     * @param cookingMethod
     */
    public void setCookingMethod(ICookingMethod cookingMethod){
        this.cookingMethod = cookingMethod;
    }

    /**
     * @param state
     * @return
     */
    public boolean setState(IState state) {
        this.state = state;
        return true;
    }

    /**
     * @return
     */
    public IState getState() {
        return state;
    }

    /**
     * 
     */
    public abstract String getName();

    /**
     * 
     */
    public abstract Double getPrice();

    /**
     * 
     */
    public abstract void accept(AbstractVisitor visitor, String retract);

    /**
     * @return
     */
    public abstract AbstractProduct clone();

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("菜名 : ").append(getName()).append(", 菜价格 : ").append(getPrice()).append(", 菜系原料 : 【");
        for (HashMap.Entry<String, Material> material : getMaterials().entrySet()){
            s.append(material.toString());
        }
        s.append("】");
        if (getCookingMethod() != null){
            s.append(", 烹饪方法 : ").append(getCookingMethod().operate());
        }
        return s.toString();
    }
}