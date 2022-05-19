package se.kh.iv1350.pointofsale.model;

import se.kh.iv1350.pointofsale.dto.ItemDTO;
import se.kh.iv1350.pointofsale.integration.Printer;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sale that requires payment from customer.
 */

public class Sale {
    private LocalTime timeOfSale;
    private Receipt receipt;
    private int totalPrice;
    private int totalQuantityOfGoods;
    private ArrayList <ItemDTO> itemDTOArrayList = new ArrayList<ItemDTO>();
    private int changeAmount;
    private int taxForEntirePurchase;
    private int totalPriceAndTaxForEntirePurchase;
    private int amountOfMeatballs;
    private int amountOfPringles;

    /**
     * This is the object Sales constructor
     */
    public Sale()
    {
        timeOfSale = LocalTime.now();
        receipt = new Receipt(timeOfSale);
    }

    public int getAmountOfMeatballs() {
        return amountOfMeatballs;
    }

    public int getAmountOfPringles() {
        return amountOfPringles;
    }

    /**
     * Gets total price of sale excluding tax.
     * @return Total price of sale.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets total quantity of goods.
     * @return Total quantity of goods.
     */
    public int getTotalQuantityOfGoods() {
        return totalQuantityOfGoods;
    }

    /**
     * Gets tax for entire purchase.
     * @return Total tax for entire purchase.
     */
    public int getTaxForEntirePurchase() {
        return taxForEntirePurchase;
    }

    /**
     * Gets price of last item in list.
     * @return Price of last item in list.
     */
    public int getLastItemPriceInList()
    {
        return itemDTOArrayList.get(itemDTOArrayList.size() - 1).getPrice();
    }

    /**
     * Gets name of last item in list.
     * @return Name of last item in list.
     */
    public String getLastItemNameInList()
    {
        return itemDTOArrayList.get(itemDTOArrayList.size() - 1).getName();
    }

    /**
     * Gets the total price including tax
     * @return total price including tax
     */

    public int getTotalPriceAndTaxForEntirePurchase ()
    {
        return totalPriceAndTaxForEntirePurchase;
    }

    /**
     * Makes a copy of the sales name list
     * @return copy of name list
     */

    public ArrayList <ItemDTO> getCopyOfItemDTOList()
    {
        ArrayList <ItemDTO> copyOfItemDTOList = new ArrayList<ItemDTO>(itemDTOArrayList);
        return copyOfItemDTOList;
    }

    /**
     * This method adds the current item to the sale.
     */
    public void addItemToSale(ItemDTO itemDTO)
    {
        boolean addNewItem = true;
        for (int i = 0; i < itemDTOArrayList.size(); i++)
            if (itemDTO.getName().equals(itemDTOArrayList.get(i).getName()))
                addNewItem = false;

            if (itemDTO.getName() != null && addNewItem)
        {
            addNewItemToSale(itemDTO);
        }
        else if (itemDTO.getName() != null){
            addSameItemToSale(itemDTO);
        }
    }

    /**
     * Ends sale by giving back the total amount to pay including tax
     * @return total amount to pay for sale
     */

    public int endSale()
    {
        return totalPriceAndTaxForEntirePurchase;
    }

    /**
     * This method calculates the supposed change that should be given back to the customer.
     * @param paymentAmount the amount of money given by the customer to pay for the sale
     * @return the amount of change
     */

    public int calculateChange (int paymentAmount)
    {
        int changeAmount;
        if (isPaymentNotEnoughForPurchase(paymentAmount))
        {
            totalPriceAndTaxForEntirePurchase -= paymentAmount;
            changeAmount = 0;
            return changeAmount;
        }

        changeAmount = paymentAmount - totalPriceAndTaxForEntirePurchase;
        receipt.setChangeAmount(changeAmount);


        return  changeAmount;
    }

    /**
     * Prints receipt
     * @param printer the external object printer
     */
    public void printReceipt (Printer printer, int paymentAmount)
    {
        if (isPaymentEnoughForPurchase(paymentAmount))
            printer.printReceipt(receipt);
    }

    /**
     * Checks if payment is enough for the purchase
     * @param paymentAmount the amount given by customer
     * @return true or false
     */
    private boolean isPaymentNotEnoughForPurchase(int paymentAmount)
    {
        return totalPriceAndTaxForEntirePurchase > paymentAmount;
    }

    /**
     * Checks if payment is not enough for the purchase
     * @param paymentAmount the amount given by customer
     * @return true or false
     */
    private boolean isPaymentEnoughForPurchase(int paymentAmount)
    {
        return paymentAmount >= totalPriceAndTaxForEntirePurchase;
    }

    /**
     * Adds one to the amount of sold item
     * @param itemDTO the current item that is supposed to be added to the sale
     */
    private void addOneToTheRightItem(ItemDTO itemDTO)
    {
        if (itemDTO.getName() == ("Pringles"))
            amountOfPringles++;
        else if (itemDTO.getName() == ("Meatball"))
            amountOfMeatballs++;
    }

    /**
     * Adds new item to the sale
     * @param itemDTO the current item that is supposed to be added to the sale
     */
    private void addNewItemToSale(ItemDTO itemDTO)
    {
        addOneToTheRightItem(itemDTO);
        itemDTOArrayList.add(itemDTO);
        totalPrice += itemDTO.getPrice();
        totalQuantityOfGoods += 1;
        taxForEntirePurchase += itemDTO.getTax();
        totalPriceAndTaxForEntirePurchase += itemDTO.getPrice() + itemDTO.getTax();

        receipt.addNewItemToReceipt(itemDTO);
        addOneToTheRightItemInReceipt(itemDTO);
    }

    /**
     * Adds item to the sale that is already added from before
     * @param itemDTO the current item that is supposed to be added to the sale
     */
    private void addSameItemToSale (ItemDTO itemDTO)
    {
        addOneToTheRightItem(itemDTO);

        totalQuantityOfGoods += 1;
        taxForEntirePurchase += itemDTO.getTax();
        totalPriceAndTaxForEntirePurchase += itemDTO.getPrice() + itemDTO.getTax();
        totalPrice += itemDTO.getPrice();

        addOneToTheRightItemInReceipt(itemDTO);
        receipt.addSameItemToReceipt(itemDTO);

    }

    private void addOneToTheRightItemInReceipt(ItemDTO itemDTO)
    {
        if (itemDTO.getName() == ("Pringles"))
            receipt.addPringlesAmount();
        if (itemDTO.getName() == ("Meatball"))
            receipt.addMeatballAmount();
    }
}
