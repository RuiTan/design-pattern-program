
import java.util.*;

/**
 * 
 */
public class PreparingState implements IState {

    /**
     * 
     */
    public void doAction(Order o) {
       o.setState(this);
    }

    @Override
    public String toString(){
        return "preparing";
    }

}