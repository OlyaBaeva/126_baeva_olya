package Payment_system_code;

import java.util.*;

public class PaymentSystem {

    private int contractsCount;
    private PaymentSystem(){
        contractsCount = 0;
    }

    public void addContract(String name, String phone) {
        contractsCount++;
    }

    public static PaymentSystem create(){
        return new PaymentSystem();
    }

    public int getContractsCount(){
        return contractsCount;
    }
}
