public class Fryer extends AbstractCooker{

    public Fryer(){
        super("炸锅",100);
    }

    @Override
    public void work(){
        System.out.println("正在炸物....");
    };

}