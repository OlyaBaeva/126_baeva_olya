package Payment_system_code;

import java.util.*;

public class PaymentSystem {

    private int contractsCount;
    private PaymentSystem(){
        contractsCount = 0;
    }

    public void addContract(String number, String date) {
        if (number == null) {
            throw new IllegalArgumentException("Number can not be null");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date can not be null");
        }
        contractsCount++;

    }

    public static PaymentSystem create(){
        return new PaymentSystem();
    }

    public int getContractsCount(){
        return contractsCount;
    }
}
