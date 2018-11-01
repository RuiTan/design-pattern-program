import java.util.HashMap;

public class PriceExpression implements IExpression {
    private String name;
    private int amount;

    public PriceExpression(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public double interpret(HashMap<String, Material> materials){
        return materials.get(name).getPrice() * this.amount;
    }

}
