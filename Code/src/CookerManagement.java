
import java.util.*;
/**
 * 
 */
public class CookerManagement {

    private static CookerManagement instance = new CookerManagement();

    private CookerManagement(){

    }

    public static CookerManagement getInstance(){
        return instance;
    }

    /**
     * 
     */
    private AbstractCooker cookerChain;

    public AbstractCooker getCookerChain() {
       return cookerChain;
    }

    public AbstractCooker getLastCooker(){
        AbstractCooker lastCooker;
        if(cookerChain != null){
            lastCooker = cookerChain;
            while(lastCooker.getNextCooker() != null){
                lastCooker = lastCooker.getNextCooker();
            }
            return lastCooker;
        }else{
            return null;
        }

    }

    /**
     * @param cooker 
     * @return
     */
    public boolean useCooker(AbstractCooker cooker) {
        return cooker.work();
    }

    /**
     * @param cooker 
     * @return
     */
    public boolean freeCooker(AbstractCooker cooker) {
        return cooker.free();
    }

    /**
     * @param cooker 
     * @return
     */
    public boolean addCooker(AbstractCooker cooker) {
        if (cookerChain == null){
            cookerChain = cooker;
        }
        else{
            getLastCooker().setNextCooker(cooker); 
        }
        return cooker == null;
    }

}