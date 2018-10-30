
import java.util.*;

/**
 * 
 */
public class ReadyState implements IState {



    public void doAction(Order o) {
        o.setState(this);

    }

    @Override
    public String toString(){
        return "ready";
    }
}