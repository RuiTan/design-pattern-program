public class Waiter extends Role {
    Waiter(String x){
        super(x);
    }
    /*
    服务员讲话
     */
    void talk(){
        System.out.println("服务员"+name+"说："+content);
    }
}