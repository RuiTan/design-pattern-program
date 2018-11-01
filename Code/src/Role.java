abstract public class Role {
    Role(){
        this("Default");
    }
    Role(String x){
        name = x;
        content = new String();
    }
    protected String name;//角色名称
    protected String content;//角色说话内容

    /*
    设置说话内容
     */
    public void setContent(String x){
        content = x;
    }

    /*
    返回名字
     */
    public String getName(){
        return name;
    }

    /*
    设置名字
     */
    public void setName(String x){
        content = x;
    }

    abstract void talk();//说话
}
