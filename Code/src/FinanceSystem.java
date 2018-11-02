//package designPattern;

import java.util.*;

/**
 * 
 */
public class FinanceSystem {

    /**
     * Default constructor
     */
    public FinanceSystem(Double startAmount) {
        finance = startAmount;
    }

    /**
     * 
     */
    private Double finance;

    /**
     * @param amount
     */
    public void earn(Double amount) throws Exception {
        // TODO implement here
        if (amount < 0) {
            throw new Exception("The amount can't be negative!");
        }
        finance += amount;     // Add the money we earn to the acount
    }

    /**
     * @param amount
     * @return
     */
    public boolean expense(Double amount) throws Exception{
        if (amount < 0) {
            throw new Exception("The amount can't be negative!");
        } else if (finance < amount) {
            throw new Exception("The account do not have enough credit to pay");
        }
        finance -= amount;

        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Double getFinance() {
        // TODO implement here
        return finance;
    }

}