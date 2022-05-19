package se.kh.iv1350.pointofsale.model;

import se.kh.iv1350.pointofsale.dto.ItemDTO;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * The receipt acts as proof of transaction and has information about the sale on it.
 */
public class Receipt{
    private LocalTime timeOfSale;


    private int totalPrice;
    private int totalQuantityOfGoods;
    private ArrayList <ItemDTO> itemDTOArrayList = new ArrayList<ItemDTO>();
    private int changeAmount;
    private int taxForEntirePurchase;
    private int totalPriceAndTaxForEntirePurchase;
    private int amountOfMeatballs;
    private int amountOfPringles;

    public Receipt(LocalTime timeOfSale)
    {
        this.timeOfSale = timeOfSale;
    }

    public int getChangeAmount() {
        return changeAmount;
    }
    public int getAmountOfMeatballs() {
        return amountOfMeatballs;
    }

    public int getAmountOfPringles() {
        return amountOfPringles;
    }
    /**
     * Getter for price
     * @return Total price of item.
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    /**
     * Getter for quantity of goods.
     * @return Quantity of goods.
     */
    public int getTotalQuantityOfGoods() {
        return totalQuantityOfGoods;
    }

    /**
     * Gets price for last item in list.
     * @return Price for last item in list.
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
     * Gets tax for entire purchase.
     * @return Tax for entire purchase.
     */
    public int getTaxForEntirePurchase() {
        return taxForEntirePurchase;
    }

    /**
     * Updates receipt with new item and information.
     * @param itemDTO Item that will be added to Receipt.
     */
    public void addNewItemToReceipt(ItemDTO itemDTO)
    {
        totalPrice += itemDTO.getPrice();
        totalQuantityOfGoods += 1;
        itemDTOArrayList.add(itemDTO);
        taxForEntirePurchase += itemDTO.getTax();
        totalPriceAndTaxForEntirePurchase += itemDTO.getPrice() + itemDTO.getTax();
    }

    /**
     * Sets the right change amount to receipt
     * @param changeAmount the amount of change
     */
    public void setChangeAmount(int changeAmount)
    {
        this.changeAmount = changeAmount;
    }

    /**
     * Adds one to the amount of meatballs sold
     */
    public void addMeatballAmount ()
    {
        amountOfMeatballs++;
    }
    /**
     * Adds one to the amount of pringles sold
     */
    public void addPringlesAmount ()
    {
        amountOfPringles++;
    }

    /**
     * Adds item to the receipt that is already added from before
     * @param itemDTO the current item that is supposed to be added to the receipt
     */
    public void addSameItemToReceipt (ItemDTO itemDTO)
    {
        totalQuantityOfGoods += 1;
        taxForEntirePurchase += itemDTO.getTax();
        totalPriceAndTaxForEntirePurchase += itemDTO.getPrice() + itemDTO.getTax();
        totalPrice += itemDTO.getPrice();

    }
}
