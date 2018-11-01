
import java.util.*;

/**
 * 
 */
public abstract class AbstractDish extends AbstractProduct {
    
    /*
     * start : 使用bridge模式，传入FlavorAPI生成相应的Dish
     */
     protected FlavorAPI falvorAPI;
     protected AbstractDish(FlavorAPI falvorAPI){
         this.falvorAPI = falvorAPI;
     }
     public abstract void flavor();
    /*
     * end : 使用bridge模式，传入FlavorAPI生成相应的Dish
     */

    /**
     * 制作方法
     */
    public ICookingMethod cookingMethod;

    /**
     * 状态
     */
    private static final ArrayList<IState> timeline=new ArrayList<IState> (){{
        add(new RawState());
        add(new CookingState());
        add(new FinishedState());
    }};
    public IState state=new RawState();


    /**
     * @return 返回菜的原料map
     */
    public abstract HashMap<String, Material> getMaterials();

    /**
     * @return 获取菜的制作方法
     */
    public ICookingMethod getCookingMethod() {
        return cookingMethod;
    }

    /**
     *
     * @param cookingMethod 设置菜的制作方法
     */
    public void setCookingMethod(ICookingMethod cookingMethod){
        this.cookingMethod = cookingMethod;
    }

    /**
     * @param state 设置菜的状态
     * @return
     */
    public boolean setState(IState state) {
        if(state==null && state==timeline.get(timeline.size()-1))
            return false;

        for (int i=0;i<timeline.size();i++){
            if(timeline.get(i).getClass()==this.state.getClass()){
                System.out.println(this.state.getClass().getName());
                this.state=timeline.get(i+1);
                System.out.println(this.state.getClass().getName());
                break;
            }
        }

        return true;
    }

    /**
     * @return 获取菜的状态
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
     * @param visitor 用来观察的Visitor
     * @param retract 缩进空格，排版用的
     */
    public abstract void accept(AbstractVisitor visitor, String retract);

    /**
     * @return
     */
    public abstract AbstractProduct clone();

    /**
     *
     * @return 一道菜的格式化字符串
     */
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