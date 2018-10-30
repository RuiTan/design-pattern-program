/**
 * 继承acceptor接口，和visitor抽象类构成visitor模式
 */
public abstract class AbstractProduct implements IAcceptor {

    /**
     * Default constructor
     */
    public AbstractProduct() {
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
     * @return
     */
    public abstract AbstractProduct clone();


    /**
     * @return
     */
    public boolean addPrototype() {
        // TODO implement here
        return false;
    }

    /**
     * 
     */
    public abstract void accept(AbstractVisitor visitor, String retract);

}