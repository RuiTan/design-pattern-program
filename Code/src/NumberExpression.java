import java.util.HashMap;

public class NumberExpression implements IExpression {
    private String name;

    public NumberExpression(String name){
        this.name = name;
    }

    public double interpret(HashMap<String, Material> materials){
        return materials.get(name).getPrice();
    }

}
