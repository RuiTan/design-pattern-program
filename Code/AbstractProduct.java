
import java.util.*;

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
    public abstract void getName();

    /**
     * 
     */
    public abstract void getPrice();

    /**
     * 
     */
    public abstract void accept();

    /**
     * @return
     */
    public abstract Product clone();

    /**
     * @param string 
     * @return
     */
    public Product findAndClone(void string) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public bool addPrototype() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public abstract void accept();

}