
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    static String[] patterns = {"Singleton", "Visitor", "Composite", "Builder", "Factory", "Decorator", "Strategy"
        , "Prototype", "Flyweight", "Iterator", "State", "Template", "Mediator", "AbstractFactory", "Observor", "Interpreter"
        , "Bridge", "Command", "Memento", "Adapter", "Facade"
    };

    static int Max = patterns.length;

    enum Pattern{
        Singleton(0), Visitor(1), Composite(2), Builder(3), Factory(4), Decorator(5), Strategy(6),
        Prototype(7), Flyweight(8), Iterator(9), State(10), Template(11), Mediator(12), AbstractFactory(13), Observor(14)
        , Interpreter(15), Bridge(16), Command(17), Memento(18), Adapter(19), Facade(20);

        private int index;

        private Pattern(int index){
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
    
    public static void main(String []args){
//        TestSample();
//        TestSample2();
        TestApplication();
    }

    public static void TestSample(){
        Sample sample = new Sample();
        sample.Initialize();

        Scanner scanner = new Scanner(System.in);
        int operate = -1;
        do {
            printTitle();
            operate = scanner.nextInt();
            if (operate > 0 && operate <= Max){
                doAction(sample, patterns[operate-1]);
            }
        }while (operate > 0 && operate <= Max);

        System.out.println("\n\n程序成功退出！\n\n");
        scanner.close();
    }

    public static void TestSample2(){
        Sample2 sample = new Sample2();
        sample.Initialize();

        Scanner scanner = new Scanner(System.in);
        int operate = -1;
        do {
            printTitle();
            operate = scanner.nextInt();
            if (operate > 0 && operate <= Max){
                doAction2(sample, patterns[operate-1]);
            }
        }while (operate > 0 && operate <= Max);

        System.out.println("\n\n程序成功退出！\n\n");
        scanner.close();
    }

    public static void TestApplication(){
        Application.main();
    }

    public static void printTitle(){
        System.out.println("\n**********************************************************************************************************************"+
                "\n**********************************************************************************************************************\n");
        System.out.print("请输入编号已运行相应设计模式demo：\n");
        int i = 1;
        for (String s : patterns){
            System.out.print(s + "(" + i++ + ");");
        }
        System.out.print("退出(0)\n");
    }

    public static int doAction(Sample sample, String operate){
        switch (Pattern.valueOf(operate)){
            case Singleton:
                sample.SingletonSample();
                break;
            case Visitor:
                sample.VisitorSample();
                break;
            case Composite:
                sample.CompositeSample();
                break;
            case Factory:
                sample.FactorySample();
                break;
            case Decorator:
                sample.DecoratorSample();
                break;
            case Strategy:
                sample.StrategySample();
                break;
            case Prototype:
                sample.PrototypeSample();
                break;
            case Flyweight:
                sample.FlyweightSample();
                break;
            case Iterator:
                sample.IteratorSample();
                break;
            case State:
                sample.StateSample();
                break;
            case Template:
                sample.TemplateMethodSample();
                break;
            case Builder:
                sample.BuilderSample();
                break;
            case Mediator:
                sample.MediatorSample();
                break;
            case Observor:
                sample.ObservorSample();
                break;
            case Interpreter:
                sample.InterpreterSample();
                break;
            case Bridge:
                sample.BridgeSample();
                break;
            case AbstractFactory:
                sample.AbstractFactorySample();
                break;
            case Command:
                sample.CommandSample();
                break;
            case Memento:
                sample.MenuMementoSample();
                break;
            case Adapter:
                sample.AdapterSample();
                break;
            case Facade:
                sample.FacadeSample();
                break;
            default:
                    return 0;
        }
        return 1;
    }



    public static int doAction2(Sample2 sample, String operate){
        switch (Pattern.valueOf(operate)){
            case Singleton:
                sample.SingletonSample();
                break;
            case Visitor:
                sample.VisitorSample();
                break;
            case Composite:
                sample.CompositeSample();
                break;
            case Factory:
                sample.FactorySample();
                break;
            case Decorator:
                sample.DecoratorSample();
                break;
            case Strategy:
                sample.StrategySample();
                break;
            case Prototype:
                sample.PrototypeSample();
                break;
            case Flyweight:
                sample.FlyweightSample();
                break;
            case Iterator:
                sample.IteratorSample();
                break;
            case State:
                sample.StateSample();
                break;
            case Template:
                sample.TemplateMethodSample();
                break;
            case Builder:
                sample.BuilderSample();
                break;
            case Mediator:
                sample.MediatorSample();
                break;
            case Observor:
                sample.ObservorSample();
                break;
            case Interpreter:
                sample.InterpreterSample();
                break;
            case Bridge:
                sample.BridgeSample();
                break;
            case AbstractFactory:
                sample.AbstractFactorySample();
                break;
            case Command:
                sample.CommandSample();
                break;
            case Memento:
                sample.MenuMementoSample();
                break;
            case Adapter:
                sample.AdapterSample();
                break;
            case Facade:
                sample.FacadeSample();
                break;
            default:
                return 0;
        }
        return 1;
    }

}
