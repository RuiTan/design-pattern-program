public class SweetDecorator extends AbstractDecorator {

    @Override
    public AbstractDish getDish() {
        return dish;
    }

    @Override
    public void setDish(AbstractDish dish) {
        this.dish = dish;
    }

    private AbstractDish dish;

    private String decorate = "甜";

    /**
     * Default constructor
     */
    public SweetDecorator(AbstractDish dish) {
        super(dish);
    }

    /**
     *
     */
    @Override
    public void decorate() {
        System.out.println(dish.getName() + " : 已设置为甜的口味");
    }

    @Override
    public String getDecorate() {
        return decorate;
    }

    @Override
    public void flavor() {

    }

    @Override
    public Boolean setPrice(Double newPrice) {
        return false;
    }

    @Override
    public AbstractProduct clone() {
        return new SweetDecorator(dish);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
