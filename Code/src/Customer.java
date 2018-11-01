public class Customer extends Role{
    Customer(String x){
        super(x);
    }
    /*
    顾客讲话
     */
    void talk(){
        System.out.println("顾客"+name+"说："+content);
    }
}