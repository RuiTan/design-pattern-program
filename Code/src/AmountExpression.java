import java.util.HashMap;

public class AmountExpression implements IExpression {
    private String name;

    public AmountExpression(String name){
        this.name = name;
    }

    public double interpret(HashMap<String, Material> materials){
        return materials.get(name).getAmount();
    }

}
