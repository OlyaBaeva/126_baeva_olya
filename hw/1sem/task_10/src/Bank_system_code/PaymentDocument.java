package Bank_system_code;

import java.util.Objects;

/**
 * todo Document type PaymentDocument
 */
public class PaymentDocument {
    private String data;
    private Integer sum;
    private String number;
    private DocumentType documentType;
    private Integer numberContract;

    public PaymentDocument(String data, Integer sum, String number, DocumentType documentType, Integer numberContract) {
        this.data = data;
        this.sum = sum;
        this.number = number;
        this.documentType = documentType;
        this.numberContract = numberContract;
    }

    public Integer getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(Integer numberContract) {
        this.numberContract = numberContract;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    @Override
    public String toString() {
        return "PaymentDocument{" +
            "data='" + data + '\'' +
            ", sum=" + sum +
            ", number=" + number +
            ", documentType=" + documentType +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentDocument that = (PaymentDocument) o;
        return Objects.equals(data, that.data) && Objects.equals(sum, that.sum) && Objects.equals(number, that.number) &&
            documentType == that.documentType && Objects.equals(numberContract, that.numberContract);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, sum, number, documentType, numberContract);
    }
}
