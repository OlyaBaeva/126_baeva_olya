package Payment_system_test;

import Bank_system_code.*;
import org.junit.*;

import java.util.HashSet;

public class FirstTest extends Assert {

    @Test
    public void create_EmptyPaymentSystem_ContractsCountEqualsZero() {
        BankSystem paymentSystem = BankSystem.create();
        assertEquals(0, paymentSystem.getContractsCount());
    }

    @Test
    public void CheckContract_CheckContractWithNumberAndDate_ContractsCountEqualsOne() {
        BankSystem paymentSystem = BankSystem.create();
        paymentSystem.CheckContract("number", "date");
        assertEquals(1, paymentSystem.getContractsCount());
    }

    @Test
    public void CheckContract_CheckContractWithNullNumber_ThrowsException() {
        BankSystem bankSystem = BankSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> bankSystem.CheckContract(null, "data"));
        assertTrue(exc.getMessage().toLowerCase().contains("number can not be null"));
    }

    @Test
    public void CheckContract_CheckContractWithNullDate_ThrowsException() {
        BankSystem bankSystem = BankSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> bankSystem.CheckContract("number", null));
        assertTrue(exc.getMessage().toLowerCase().contains("date can not be null"));

    }

    @Test
    public void CheckContract_CheckContractWithNullDateAndNumber_ThrowsException() {
        BankSystem bankSystem = BankSystem.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> bankSystem.CheckContract(null, null));
        assertTrue(exc.getMessage().toLowerCase().contains("date can not be null") &&
                exc.getMessage().toLowerCase().contains("number can not be null"));

    }

    @Test
    public void addContract_addContractToContract_SizeOfContracts() throws Exception {
        BankSystem contracts = BankSystem.create();
        Contract c = new Contract("20220111", "1");
        contracts.addContract(c);
        assertEquals(1, contracts.getContracts().size());
        c = new Contract("20220212", "2");
        contracts.addContract(c);
        assertEquals(2, contracts.getContracts().size());
    }

    @Test
    public void deletingPayment_deletePayment_EqualsZero() throws Exception {
        BankSystem bankSystem = BankSystem.create();
        HashSet<Contract> contracts = new HashSet<>();
        Contract c = new Contract("20220111","1");
        bankSystem.addContract(c);
        HashSet <PaymentDocument> documents = new HashSet<>();
        PaymentDocument paymentDocument = new PaymentDocument("20200210", 1000, "1" ,  DocumentType.BANK_ORDER, 333);
        documents.add(paymentDocument);
        paymentDocument = new PaymentDocument("20200212", 300, "1", DocumentType.BANK_ORDER,  101);
        documents.add(paymentDocument);
        paymentDocument = new PaymentDocument("20200331", 302, "1", DocumentType.BANK_ORDER, 102);
        documents.add(paymentDocument);
        paymentDocument = new PaymentDocument("20220410", 303, "1", DocumentType.BANK_ORDER, 103);
        documents.add(paymentDocument);
        documents.clear();
        assertEquals(0,  documents.size());
    }
}
