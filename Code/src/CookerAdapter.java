public class CookerAdapter {
    private AdvancedCooker cooker;

    public CookerAdapter(String operation){
        if(operation.trim().equals("蒸")){
            cooker=new Steamer();
        }
        if(operation.trim().equals("炸")) {
            cooker=new Fryer();
        }
    }

    public boolean cook() {
        return cooker.work();
    }

}
