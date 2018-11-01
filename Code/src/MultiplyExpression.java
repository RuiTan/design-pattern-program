import java.util.HashMap;

public class MultiplyExpression implements IExpression {

    private IExpression left, right;
    public MultiplyExpression(IExpression left, IExpression right){
        this.left = left;
        this.right = right;
    }
    public double interpret(HashMap<String, Material> materials) {
        return left.interpret(materials) * right.interpret(materials);
    }

}
