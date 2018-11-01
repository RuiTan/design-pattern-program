/**
 * 
 */
public class CookingState implements IState {


    public void doAction(Order o){}

    @Override
    public void doAction(AbstractDish a) {
        a.setState(this);
    }

}