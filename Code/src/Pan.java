
import java.util.*;

/**
 * 
 */
public class Pan extends AbstractCooker {

    public Pan(){
        super("煎锅",100.0);
        CookerManagement.getInstance().addCooker(this);
    }

    @Override
    public boolean work(){
        boolean work = super.work();
        if  (work){
            System.out.println("你可以使用它，煎锅现在被你使用了....");
        }else{
            System.out.println("煎锅正在被其他人使用....");
        }
        return work;
    };
}