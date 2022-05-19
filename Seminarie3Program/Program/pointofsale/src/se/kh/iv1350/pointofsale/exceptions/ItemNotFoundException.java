package se.kh.iv1350.pointofsale.exceptions;

/**
 * An exception for when an item is not found with a specified itemID
 */
public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
