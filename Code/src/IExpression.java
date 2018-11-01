import java.util.HashMap;

public interface IExpression {

    double interpret(HashMap<String, Material> materials);

}
