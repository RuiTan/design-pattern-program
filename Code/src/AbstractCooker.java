

import java.util.*;

abstract class AbstractCooker {
    public String name;
    public float price;
    public int available;
    public AbstractCooker nextCooker;
    AbstractCooker(){

    }
    AbstractCooker(String Name, float Price){
        name = Name;
        price = Price;
        available= 0;
        nextCooker = null;
    }

    /**
     * 设置下一个厨具
     */
    public boolean setNextCooker(AbstractCooker nextCooker) {
        this.nextCooker = nextCooker;
        return nextCooker == null;
    }
    /**
     * 判断是否在工作
     */
    public boolean getWork(AbstractCooker cooker) {
        if(available == 0) {
            return false;
        }
        else{
            return true;
        }
    }

    /**
     * 使该厨具工作
     */
    public boolean work(AbstractCooker cooker) {
        if(available != 0){
            return false;
        }
        else{
            available = 1;
            return true;
        }
    }

}