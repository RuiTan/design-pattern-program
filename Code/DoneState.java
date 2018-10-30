
import java.util.*;

/**
 * 
 */
public class DoneState implements IState {



    public void doAction(Order o) {
        o.setState(this);
    }

    @Override
    public String toString(){
        return "done";
    }

}