import java.util.ArrayList;

abstract public class Mediator {
    Mediator(){
        roleList = new ArrayList<Role>();
    }
    protected ArrayList<Role> roleList;

    public void addRole(Role r){
        roleList.add(r);
    }
    abstract void notify(Role r);//某人通知大家
    abstract void chat(Role r1, Role r2);//两个人聊天
}