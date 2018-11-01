
class AbstractCooker implements AdvancedCooker{

    private String name;
    private Double price;
    private int available;
    private AbstractCooker nextCooker;

    public AbstractCooker(String Name, Double Price){
        name = Name;
        price = Price;
        available = 0;
        nextCooker = null;
    }

    public AbstractCooker(){

    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public AbstractCooker getNextCooker(){
        return nextCooker;
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
    public boolean getWork() {
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
    public boolean work() {
        if(available != 0){
            return false;
        }
        else{
            available = 1;
            return true;
        }
    }

    /**
     * 使该厨具空闲
     */
    public boolean free(){
        if (available == 1){
            available = 0;
            return true;
        }
        return false;
    }

}