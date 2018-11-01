public class NumberExpression implements IExpression {

    public double interpret(Material material){
        return material.getPrice();
    }

}
