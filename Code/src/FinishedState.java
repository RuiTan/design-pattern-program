/**
 * 
 */
public class FinishedState implements IState {

    public void doAction(Order o){}

    @Override
    public void doAction(AbstractDish a) {
        a.setState(this);
    }

}