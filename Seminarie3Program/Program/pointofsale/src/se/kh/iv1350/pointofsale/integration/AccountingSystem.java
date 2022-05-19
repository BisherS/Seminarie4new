package se.kh.iv1350.pointofsale.integration;
import se.kh.iv1350.pointofsale.integration.observer.Observer;
import se.kh.iv1350.pointofsale.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that makes call to an external accounting system,
 * for this application subsequent information will be hardcoded.
 */
public class AccountingSystem {
    private int amountOfMoneyInSystem;

    private List<Observer> observers = new ArrayList<Observer>();

    /**
     * Attaches a new observer to the list of observers
     * @param observer the observer that should be attached to the list
     */

    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * Updates all the observers
     */
    private void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(amountOfMoneyInSystem);
        }
    }

    /**
     * Gets amount of money in the system
     * @return amount of money
     */

    public int getAmountOfMoneyInSystem() {
        return amountOfMoneyInSystem;
    }
    /**
     * Updates our made-up accounting system
     * @param sale the current sale
     */
    public void updateAccountingSystem(Sale sale, int paymentAmount){
        if (paymentAmount >= sale.getTotalPriceAndTaxForEntirePurchase())
        {
            amountOfMoneyInSystem += sale.getTotalPrice() + sale.getTaxForEntirePurchase();
            notifyAllObservers();
        }


    }
}
