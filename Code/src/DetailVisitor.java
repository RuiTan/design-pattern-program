import java.util.HashMap;

public class DetailVisitor extends AbstractVisitor {

    @Override
    public void visit(AbstractMeal m, String retract) {

        String builder = retract +
                "套餐名 : " + m.getName() + ", " + "套餐价格 : " + m.getPrice() + "\n" +
                retract +
                "套餐内容 : \n";
        System.out.print(builder);
        for (HashMap.Entry<String, AbstractProduct> productEntry : m.getDishes().entrySet()){
            productEntry.getValue().accept(this, retract+"  ");
        }
    }

    @Override
    public void visit(AbstractDish d, String retract) {
        System.out.println(retract + d.toString());
    }
}
