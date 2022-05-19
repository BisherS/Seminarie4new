package se.kh.iv1350.pointofsale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kh.iv1350.pointofsale.dto.ItemDTO;
import se.kh.iv1350.pointofsale.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class AccountingSystemTest {
    private AccountingSystem accountingSystem;
    private Sale sale;

    @BeforeEach
    void setUp() {
        accountingSystem = new AccountingSystem();
        sale = new Sale();
    }

    @AfterEach
    void tearDown() {
        accountingSystem = null;
        sale = null;
    }

    @Test
    void updateAccountingSystem() {
        addMeatballToSale();
        int amountPaidByCustomer = 70;
        accountingSystem.updateAccountingSystem(sale,amountPaidByCustomer);
        int expectedAmountOfMoneyInSystem = 55;
        assertEquals(expectedAmountOfMoneyInSystem, accountingSystem.getAmountOfMoneyInSystem(),
                "Wrong amount in the accounting system");
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