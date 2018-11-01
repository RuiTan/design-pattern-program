public class Fryer extends AbstractCooker{

    public Fryer(){
        super("炸锅",100.0);
        CookerManagement.getInstance().addCooker(this);
    }

    @Override
    public boolean work(){
        boolean work = super.work();
        if  (work){
            System.out.println("你可以使用它，炸锅现在被你使用了....");
        }else{
            System.out.println("炸锅正在被其他人使用....");
        }
        return work;
    };

}