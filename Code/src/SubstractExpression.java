public class SubstractExpression implements IExpression {

    private IExpression left, right;
    public SubstractExpression(IExpression left, IExpression right){
        this.left = left;
        this.right = right;
    }
    public double interpret(Material material) {
        return left.interpret(material) - right.interpret(material);
    }

}
