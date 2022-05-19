package se.kh.iv1350.pointofsale.dto;

/**
 * DTO created to make parameterlists shorter.
 */
public class ItemDTO {
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getTax() {
        return tax;
    }

    private int id;
    private String description;
    private int price;
    private int tax;

    /**
     *DTO method, sets the given values to the object.
     * @param name Name of item.
     * @param id identification number of number/barcode.
     * @param description Description of item.
     * @param price Price of item excluding tax.
     * @param tax Tax for item. 
     */
    public ItemDTO(String name, int id, String description, int price, int tax)
    {
        this.name = name;
        this.id = id;
        this.description = description;
        this.price = price;
        this.tax = tax;
    }
}
