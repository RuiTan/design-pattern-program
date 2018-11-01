public class Steamer extends AbstractCooker {
    public Steamer(){
        super("蒸锅",100.0);
        CookerManagement.getInstance().addCooker(this);
    }

    @Override
    public boolean work(){
        boolean work = super.work();
        if  (work){
            System.out.println("你可以使用它，蒸锅现在被你使用了....");
        }else{
            System.out.println("蒸锅正在被其他人使用....");
        }
        return work;
    };
}
