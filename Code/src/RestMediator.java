public class RestMediator extends Mediator{
    /*
    一人通知大家，其他人回答
     */
    void notify(Role r){
        r.talk();//通知者发言
        for(int i = 0; i < roleList.size(); i++){
            if(roleList.get(i) != r){
                roleList.get(i).talk();//除通知者之外的发言
            }
        }
        System.out.println("");
    }

    /*
    两个人对话
     */
    void chat(Role r1, Role r2){
        r1.talk();
        r2.talk();
        System.out.println("");
    }

}