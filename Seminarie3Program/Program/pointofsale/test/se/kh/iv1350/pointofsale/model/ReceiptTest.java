package se.kh.iv1350.pointofsale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kh.iv1350.pointofsale.dto.ItemDTO;

import java.time.LocalTime;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
    private Receipt receipt;
    private LocalTime timeOfSale;

    @BeforeEach
    void setUp() {
        timeOfSale = LocalTime.now();
        receipt = new Receipt(timeOfSale);
    }

    @AfterEach
    void tearDown() {
        receipt = null;
    }

    @Test
    void addMeatballToReceiptTest() {
        String name = "Meatball";
        int id = 1;
        String description = "Food";
        int price = 50;
        int tax = 5;
        ItemDTO itemDTO = new ItemDTO(name,id,description, price, tax);
        receipt.addNewItemToReceipt(itemDTO);
        String expectedNameOfItemToAdd = "Meatball";
        assertEquals(expectedNameOfItemToAdd, receipt.getLastItemNameInList(), "Wrong name");
    }

    @Test
    void addPringlesToReceiptTest()
    {
        String name = "Pringles";
        int id = 2;
        String description = "Snacks";
        int price = 20;
        int tax = 2;
        ItemDTO itemDTO = new ItemDTO(name, id, description, price, tax);
        receipt.addNewItemToReceipt(itemDTO);
        String expectedNameOfItemToAdd = "Pringles";
        assertEquals(expectedNameOfItemToAdd, receipt.getLastItemNameInList(), "Wrong name");
    }

    @Test
    void addMeatballAmountTest()
    {
        receipt.addMeatballAmount();
        int expectedMeatballAmount = 1;
        assertEquals(expectedMeatballAmount,receipt.getAmountOfMeatballs());
    }
    @Test
    void addPringlesAmountTest()
    {
        receipt.addPringlesAmount();
        int expectedPringlesAmount = 1;
        assertEquals(expectedPringlesAmount,receipt.getAmountOfPringles());
    }
}