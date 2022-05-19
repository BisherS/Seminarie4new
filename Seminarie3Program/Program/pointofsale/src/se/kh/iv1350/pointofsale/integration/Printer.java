package se.kh.iv1350.pointofsale.integration;

import se.kh.iv1350.pointofsale.model.Receipt;

/**
 * This is the sales printer which is an external device. It prints out the receipt
 */
public class Printer {
    /**
     * Tells the external device to print a copy of the receipt
     * @param receipt the current receipt to the current sale
     */
    public void printReceipt(Receipt receipt)
    {
        System.out.println("Meatballs: " +  receipt.getAmountOfMeatballs());
        System.out.println("Pringles: " + receipt.getAmountOfPringles());
        System.out.println("Total price excluding tax is: " + receipt.getTotalPrice());
        System.out.println("Total price including tax is: " + (receipt.getTotalPrice() + receipt.getTaxForEntirePurchase()));
        System.out.println("Your change was: " + receipt.getChangeAmount());
    }
}