package se.kh.iv1350.pointofsale.view;

import se.kh.iv1350.pointofsale.integration.observer.Observer;

/**
 * This is the class that writes out the total revenue to the console, (the user)
 */

public class TotalRevenueView implements Observer {
    /**
     * Prints the total revenue to the user
     * @param totalRevenue the current total revenue
     */
    @Override
    public void update(int totalRevenue) {
        System.out.println("the current total revenue is " + totalRevenue);
    }
}
