package Bank_system_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BankSystem {

    private int contractsCount;
    public BankSystem(){
        contractsCount = 0;
    }
    private HashSet<Contract> contracts = new HashSet<>();

    public List<PaymentDocument> getListAllPayments(){
        ArrayList<PaymentDocument> paymentDocuments = new ArrayList<>();
        for(Contract c : contracts){
            paymentDocuments.addAll(c.getDocuments());
        }
        return paymentDocuments;
    }

    public void CheckContract(String number, String date) {
        if (number == null && date == null) {
            throw new IllegalArgumentException("Number can not be null, date can not be null");
        }
        if (number == null) {
            throw new IllegalArgumentException("Number can not be null");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date can not be null");
        }
        contractsCount++;
    }
        public Boolean addContract(Contract contract) throws Exception {
            boolean f = true;
            if (((Objects.equals(contract.getNumber(),null))|(Objects.equals(contract.getNumber(), "")))|(Objects.equals(contract.getData(),null))) {
                f = false;
                throw new Exception("Попытка добавить договор с пустым номером");
            } else {
                for (Contract c : contracts) {
                    if (Objects.equals(c.getNumber(), contract.getNumber())) {
                        f = false;
                        throw new Exception("Попытка добавить договор с уже существующим номером ");
                    }
                }
            }
            if (Boolean.TRUE.equals(f)) {
                contracts.add(contract);
                return true;
            } else {
                return false;
            }
        }
    public HashSet<Contract> getContracts() {
        return contracts;
    }

    public static BankSystem create(){
        return new BankSystem();
    }

    public int getContractsCount(){
        return contractsCount;
    }
}
