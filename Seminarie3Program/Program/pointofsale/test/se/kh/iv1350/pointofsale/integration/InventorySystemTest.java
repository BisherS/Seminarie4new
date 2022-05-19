package se.kh.iv1350.pointofsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kh.iv1350.pointofsale.exceptions.ServerConnectionFailException;
import se.kh.iv1350.pointofsale.exceptions.ItemNotFoundException;
import se.kh.iv1350.pointofsale.dto.ItemDTO;
import se.kh.iv1350.pointofsale.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {

    private InventorySystem inventorySystem;
    private Sale sale;

    @BeforeEach
    void setUp() {
        inventorySystem = InventorySystem.getInstance();
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        inventorySystem = null;
        sale = null;
    }

    @Test
    void retrieveMeatballDTOInformationTest() {
        ItemDTO itemDTO = null;
        try {
            itemDTO = inventorySystem.retrieveItemInformation(1);
        } catch (ItemNotFoundException | ServerConnectionFailException e) {
            fail(e.getMessage());
        }
        String expectedName = "Meatball";
        assertEquals(expectedName,itemDTO.getName(), "Wrong ItemDTO name");
    }
    @Test
    void retrievePringlesDTOInformationTest()
    {
        ItemDTO itemDTO = null;
        try {
            itemDTO = inventorySystem.retrieveItemInformation(2);
        } catch (ItemNotFoundException | ServerConnectionFailException e) {
            fail(e.getMessage());
        }
        String expectedName = "Pringles";
        assertEquals(expectedName,itemDTO.getName(), "Wrong ItemDTO name");
    }

    @Test
    void retrieveItemInformationThrowItemNotFoundExceptionTest()
    {
        ItemDTO itemDTO = null;
        try {
            itemDTO = inventorySystem.retrieveItemInformation(0);
            fail("ItemWasNotFoundException should have been thrown, Item was found");
        } catch (ItemNotFoundException e) {

        }
        catch (ServerConnectionFailException p) {
            fail("ItemWasNotFoundException should have been thrown, Data base is down");
        }

    }

    @Test
    void retrieveItemInformationThrowServerConnectionFailExceptionTest(){
        ItemDTO itemDTO = null;
        try {
            itemDTO = inventorySystem.retrieveItemInformation(3);
            fail("DatabaseServerNotRunningException should have been thrown, Item was found");
        } catch (ItemNotFoundException e) {
            fail("DatabaseServerNotRunningException should have been thrown, Item was not found");
        }
        catch (ServerConnectionFailException p) {
        }
    }


    @Test
    void updateInventorySystemWhenBuyMeatballTest()
    {
        addMeatballToSale();
        inventorySystem.updateInventorySystem(sale, 120);
        int expectedAmountOfMeatballsLeft = 99;
        assertEquals(expectedAmountOfMeatballsLeft, inventorySystem.getMeatballsLeft(),
                "Wrong amount of meatballs left");
    }

    @Test
    void updateInventorySystemWhenNothingToBuy()
    {
        inventorySystem.updateInventorySystem(sale, 0);
        int expectedAmountOfMeatballsLeft = 100;
        assertEquals(expectedAmountOfMeatballsLeft, inventorySystem.getMeatballsLeft(),
                "Wrong amount of meatballs left");
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

}