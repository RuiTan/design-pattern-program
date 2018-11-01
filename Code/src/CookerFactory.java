

public class CookerFactory{

   public AbstractCooker createCooker(Sample.CookerType type){
       AbstractCooker cooker;
       switch(type){
            case Fryer:
                cooker = new Fryer();
                break;
            case Pan:
                cooker = new Pan();
                break;
            case Steamer:
                cooker = new Steamer();
                break;
           case MicroWave:
                cooker = new Microwave();
               break;
           default:
                return null;
       }
       return cooker;
   }

}