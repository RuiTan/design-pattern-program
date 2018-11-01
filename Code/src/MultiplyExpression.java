public class MultiplyExpression implements IExpression {

    private IExpression left, right;
    public MultiplyExpression(IExpression left, IExpression right){
        this.left = left;
        this.right = right;
    }
    public double interpret(Material material) {
        return left.interpret(material) * right.interpret(material);
    }

}
