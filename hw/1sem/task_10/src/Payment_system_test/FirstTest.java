package Payment_system_test;

import Bank_system_code.*;
import org.junit.*;

public class FirstTest extends Assert {

    @Test
    public void create_EmptyPaymentSystem_ContractsCountEqualsZero(){
        BankSystem paymentSystem = BankSystem.create();
        assertEquals(0, paymentSystem.getContractsCount());
    }

    @Test
    public void CheckContract_addContractWithNumberAndDate_ContractsCountEqualsOne(){
        BankSystem paymentSystem = BankSystem.create();
        paymentSystem.CheckContract("number", "date");
        assertEquals(1, paymentSystem.getContractsCount());
    }

    @Test
    public void addContract_AddContractWithNullNumber_ThrowsException() {
        BankSystem bankSystem = BankSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> bankSystem.CheckContract(null, "data"));
        assertTrue(exc.getMessage().toLowerCase().contains("number can not be null"));
    }
    @Test
    public void addContract_AddContractWithNullDate_ThrowsException() {
        BankSystem bankSystem = BankSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> bankSystem.CheckContract("number" , null));
        assertTrue(exc.getMessage().toLowerCase().contains("date can not be null"));

    }

    @Test
    public void addContract_AddContractWithNullDateAndNumber_ThrowsException() {
        BankSystem bankSystem = BankSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> bankSystem.CheckContract(null , null));
        assertTrue(exc.getMessage().toLowerCase().contains("date can not be null")&&
                exc.getMessage().toLowerCase().contains("number can not be null"));

    }
}
