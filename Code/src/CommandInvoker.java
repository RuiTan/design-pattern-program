
import java.util.*;

/**
 * 
 */
public class CommandInvoker {

    /**
     * Default constructor
     */
    public CommandInvoker() { }
    public CommandInvoker(ICommand command) {
        this.setCommand(command);
    }

    /**
     * 
     */
    private ICommand command;


    /**调用 CookerManagement 的方法
     * @return
     */
    public boolean cookerManagementCall(AbstractCooker cooker) {
        if (command != null && cooker != null && cooker instanceof AbstractCooker){
            return command.execute(cooker);
        } else {
            return false;
        }
    }

    /**
     * @param command 
     * @return
     */
    public void setCommand(ICommand command) {
        this.command = command;
    }

}