/**
 * 
 */
public class PreparingState implements IState {

    /**
     * 
     */
    @Override
    public void doAction(Order o) {
       o.setState(this);
    }
    @Override
    public void doAction(AbstractDish a) { }
    @Override
    public String toString(){
        return "preparing";
    }

}