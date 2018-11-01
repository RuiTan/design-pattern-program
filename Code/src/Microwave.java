
import java.util.*;

/**
 * 
 */
public class Microwave extends AbstractCooker {

    /**
     * Default constructor
     */
    public Microwave() {
        super("微波炉", 500.0);
    }

    @Override
    public boolean work(){
        boolean work = super.work();
        if  (work){
            System.out.println("你可以使用它，微波炉现在被你使用了....");
        }else{
            System.out.println("微波炉正在被其他人使用....");
        }
        return work;
    }

}