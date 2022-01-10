package Payment_system_test;

import Payment_system_code.*;
import org.junit.*;

public class FirstTest extends Assert {

    @Test
    public void create_EmptyPaymentSystem_ContractsCountEqualsZero(){
        PaymentSystem paymentSystem = PaymentSystem.create();
        assertEquals(0, paymentSystem.getContractsCount());
    }

    @Test
    public void addContract_addContractWithNumberAndDate_ContractsCountEqualsOne(){
        PaymentSystem paymentSystem = PaymentSystem.create();
        paymentSystem.addContract("number", "date");
        assertEquals(1, paymentSystem.getContractsCount());
    }

    @Test
    public void addContract_AddContractWithNullNumber_ThrowsException() {
        PaymentSystem paymentSystem = PaymentSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> paymentSystem.addContract(null, "data"));
        assertTrue(exc.getMessage().toLowerCase().contains("name can not be null"));
    }
}
