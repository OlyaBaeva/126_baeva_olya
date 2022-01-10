package Payment_system_test;

import org.junit.*;

public class FirstTest extends Assert {
    @Test
    public void create_EmptyPaymentSystem_ContractsCountEqualsZero(){
        PaymentSystem paymentSystem = PaymentSystem.create();
        assertEquals(0, paymentSystem.getContractsCount());
    }
}
