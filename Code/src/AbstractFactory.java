
public class AbstractFactory{

    public static CookerFactory getCookerFactory(){
        return new CookerFactory();
    }

    public static MaterialFactory getMaterialFactory(){
        return new MaterialFactory();
    }

}