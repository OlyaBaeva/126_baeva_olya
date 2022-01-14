package Bank_system_code;

import java.util.HashSet;
import java.util.Objects;

/**
 * todo Document type Contract
 */
public class Contract {
    private String data;
    private String number;
    private HashSet<PaymentDocument> documents = new HashSet<>();

    public Contract(String data, String number) {
        this.data = data;
        this.number = number;
    }

    public Integer getFullSum(){
        Integer sum = 0;
        for(PaymentDocument paymentDocument : documents){
            sum += paymentDocument.getSum();
        }
        return sum;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public HashSet<PaymentDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(HashSet<PaymentDocument> documents) {
        this.documents = documents;
    }

    public Boolean addDocument(PaymentDocument paymentDocument){
        if(paymentDocument.getSum() == null){
            return false;
        }
        for(PaymentDocument p : documents){
            if(p.equals(paymentDocument)){
                return false;
            }
        }
        documents.add(paymentDocument);
        return true;
    }

    public Boolean deletingPayment(String data, Integer number) throws Exception {
        for (PaymentDocument pd : documents) {
            if (Objects.equals(pd.getData(), data) && Objects.equals(pd.getNumber(), number)) {
                documents.remove(pd);
                return true;
            } else {
                throw new Exception("Попытка удалить несуществующий платеж");
           }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contract contract = (Contract) o;
        return Objects.equals(data, contract.data) && Objects.equals(number, contract.number) &&
            Objects.equals(documents, contract.documents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, number, documents);
    }

    @Override
    public String toString() {
        return "Contract{" +
            "data='" + data + '\'' +
            ", number=" + number +
            ", documents=" + documents +
            '}';
    }


}
