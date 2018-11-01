public class Steamer extends AbstractCooker {
    public Steamer(){
        super("蒸锅",100);
    }

    @Override
    public void work(){
        System.out.println("正在蒸菜....");
    };
}
