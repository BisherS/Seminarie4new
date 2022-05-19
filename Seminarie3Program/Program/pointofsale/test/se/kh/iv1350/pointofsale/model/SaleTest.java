package se.kh.iv1350.pointofsale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kh.iv1350.pointofsale.dto.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    private Sale sale;

    @BeforeEach
    void setUp() {
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        sale = null;
    }

    @Test
    void addMeatballToSaleTest() {
        addMeatballToSale();
        String expectedNameOfItemToAdd = "Meatball";
        assertEquals(expectedNameOfItemToAdd, sale.getLastItemNameInList(), "Wrong name");
    }

    @Test
    void addPringlesToSaleTest()
    {
        addPringlesToSale();
        String expectedNameOfItemToAdd = "Pringles";
        assertEquals(expectedNameOfItemToAdd, sale.getLastItemNameInList(), "Wrong name");
    }

    @Test
    void addNullToSaleTest()
    {
        addNullItemDTO();
        int expectedTotalAmountOfGoods = 0;
        assertEquals(expectedTotalAmountOfGoods, sale.getTotalQuantityOfGoods(), "Wrong total amount of goods");
    }

    @Test
    void endSaleWithNoItemsTest()
    {
        int expectedInitialTotalPriceWithTax = 0;
        assertEquals(expectedInitialTotalPriceWithTax, sale.getTotalPriceAndTaxForEntirePurchase(),
                "Wrong initial total price with tax");
    }
    @Test
    void endSaleWithMeatballTest()
    {
        addMeatballToSale();
        int expectedTotalPriceWithTax = 55;
        assertEquals(expectedTotalPriceWithTax, sale.getTotalPriceAndTaxForEntirePurchase(),
                "Wrong total price with tax after adding meatball");
    }
    @Test
    void endSaleWithPringlesTest()
    {
        addPringlesToSale();
        int expectedTotalPriceWithTax = 22;
        assertEquals(expectedTotalPriceWithTax, sale.getTotalPriceAndTaxForEntirePurchase(),
                "Wrong total price with tax after adding pringles");
    }
    @Test
    void endSaleWithNullTest()
    {
        addNullItemDTO();
        int expectedTotalPriceWithTax = 0;
        assertEquals(expectedTotalPriceWithTax, sale.getTotalPriceAndTaxForEntirePurchase(),
                "Wrong total price with tax after adding the NULL itemDTO");
    }

    @Test
    void calculateChangeAfterBuyingMeatballTest()
    {
        addMeatballToSale();
        int expectedChangeAmount = 15;
        int paymentAmount = 70;
        assertEquals(expectedChangeAmount, sale.calculateChange(paymentAmount),"Wrong calculated change");
    }

    @Test
    void calculateChangeAfterBuyingPringlesTest()
    {
        addPringlesToSale();
        int expectedChangeAmount = 48;
        int paymentAmount = 70;
        assertEquals(expectedChangeAmount, sale.calculateChange(paymentAmount),"Wrong calculated change");
    }

    @Test
    void calculateChangeWithNotEnoughPaymentTest()
    {
        addMeatballToSale();
        int expectedChangeAmount = 0;
        int paymentAmount = 50;
        assertEquals(expectedChangeAmount, sale.calculateChange(paymentAmount), "Wrong calculated change");
    }

    void addMeatballToSale()
    {
        String name = "Meatball";
        int id = 1;
        String description = "Food";
        int price = 50;
        int tax = 5;
        ItemDTO itemDTO = new ItemDTO(name,id,description, price, tax);
        sale.addItemToSale(itemDTO);
    }

    void addPringlesToSale()
    {
        String name = "Pringles";
        int id = 2;
        String description = "Snacks";
        int price = 20;
        int tax = 2;
        ItemDTO itemDTO = new ItemDTO(name, id, description, price, tax);
        sale.addItemToSale(itemDTO);
    }

    void addNullItemDTO()
    {
        String name = null;
        int id = 0;
        String description = null;
        int price = 0;
        int tax = 0;
        ItemDTO itemDTO = new ItemDTO(name, id, description, price, tax);
        sale.addItemToSale(itemDTO);
    }
}