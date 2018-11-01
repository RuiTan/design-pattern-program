public class DoNothingMethod implements ICookingMethod {

    private String operate = "无特殊制作方法";

    @Override
    public String operate() {
        return operate;
    }
}
