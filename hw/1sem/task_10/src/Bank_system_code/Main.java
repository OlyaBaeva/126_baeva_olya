package Bank_system_code;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * todo Document type Main
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BankSystem bankSystem = new BankSystem();

        do {
            showMenu();
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    System.out.println("Введите номер договора");
                    scanner.nextLine();
                    String contractNumber = scanner.nextLine();
                    System.out.println("Введите дату договора, строка формата 'YYYYMMDD', где Y - год, M - месяц, D - день");
                    String contractData = scanner.nextLine();
                try {
                    Contract c = new Contract(contractData, contractNumber);
                    Boolean isAdded = bankSystem.addContract(c);
                    System.out.println(Boolean.TRUE.equals(isAdded) ? "Договор добавлен" : "Ошибка добавления");
                } catch (Exception e) {System.out.println("Формат введенных данных не верен");}
                    break;
                case 2:
                    System.out.println("Введите номер договора");
                    scanner.nextLine();
                    contractNumber = scanner.nextLine();
                    Contract contract = bankSystem.findContractByNumber(contractNumber);
                    if(contract != null) {
                        System.out.println("Введите дату платежа, строка формата 'YYYYMMDD', где Y - год, M - месяц, D - день");
                        String paymentData = scanner.nextLine();
                        System.out.println("Задайте номер платежа");
                        Integer documentNumber = scanner.nextInt();
                        try {
                            Boolean isDeletingPayment = contract.deletingPayment(paymentData, documentNumber);
                            System.out.println(isDeletingPayment ? "Платежный документ успешно удален" : "Попытка удалить несуществующий платеж");
                        } catch (Exception e) {
                            System.out.println("Попытка удалить несуществующий платеж");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Введите номер договора");
                    scanner.nextLine();
                    contractNumber = scanner.nextLine();
                    Contract contractByNumber = bankSystem.findContractByNumber(contractNumber);
                    if(contractByNumber != null){
                        System.out.println("Введите дату платежа, строка формата 'YYYYMMDD', где Y - год, M - месяц, D - день");
                        String paymentData = scanner.nextLine();
                        System.out.println("Введите сумму платежа");
                        Integer paymentSum = scanner.nextInt();
                        System.out.println("Задайте номер платежа");
                        Integer documentNumber = scanner.nextInt();
                        System.out.println("Выберите тип платежного документа:");
                        System.out.println("1. Банковский ордер");
                        System.out.println("2. Платежной ордер");
                        Integer documentTypeNumber = scanner.nextInt();
                        DocumentType documentType = null;
                        switch (documentTypeNumber) {
                            case 1: documentType = DocumentType.BANK_ORDER; break;
                            case 2: documentType = DocumentType.PAYMENT_ORDER; break;
                            default:
                                System.out.println("Некорректный номер"); break;
                        }
                        PaymentDocument paymentDocument = new PaymentDocument(paymentData, paymentSum, contractNumber ,  documentType, documentNumber);
                        Boolean isAddedContract = contractByNumber.addDocument(paymentDocument);
                        System.out.println(Boolean.TRUE.equals(isAddedContract) ? "Документ успешно создан" : "Ошибка создания документа");
                    }
                    else {
                        System.out.println("Ошибка. Нет такого номера договора");
                    }
                    break;
                case 4:
                    List<PaymentDocument> listAllPayments = bankSystem.getListAllPayments();
                    for(PaymentDocument pd : listAllPayments){
                        System.out.println("********** PaymentDocument ******");
                        System.out.println("Number: " + pd.getNumber());
                        System.out.println("Data: " + pd.getData());
                        System.out.println("Sum: " + pd.getSum());
                        System.out.println("Document Type: " + pd.getDocumentType());
                        System.out.println("*********************************");
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Введите номер договора");
                    scanner.nextLine();
                    contractNumber = scanner.nextLine();
                    Contract con = bankSystem.findContractByNumber(contractNumber);
                    if(con != null){
                        Integer fullSum = con.getFullSum();
                        System.out.println("Сумма всех платежных документов по договору№" + contractNumber + " равна " + fullSum);
                    }
                    else {
                        System.out.println("Ошибка. Нет такого номера договора");
                    }
                    break;
                case 6:
                    HashSet<Contract> contracts = bankSystem.getContracts();
                    for(Contract ct : contracts){
                        System.out.println("**********    Contract    *******");
                        System.out.println("Number: " + ct.getNumber());
                        System.out.println("Data: " + ct.getData());
                        System.out.println("*********************************");
                        System.out.println();
                    }
                    break;
                case 7:
                    HashSet<Contract> contractHashSet = bankSystem.getContracts();
                    for(Contract ct : contractHashSet){
                        System.out.println("********** PaymentDocument ******");
                        System.out.println("Number: " + ct.getNumber());
                        System.out.println("Data: " + ct.getData());
                        System.out.println("Sum: " + ct.getFullSum());
                        System.out.println("*********************************");
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Not found action");
                    break;
            }
        } while (true);
    }

    public static void showMenu(){
        System.out.println("Bank System. Введите номер действия: ");
        System.out.println("1. Добавление договора");
        System.out.println("2. Удаление платежного документа по номеру договора");
        System.out.println("3. Добавление платежного документа с указанной суммой, номером, типом документа, номером договора и датой платежа ");
        System.out.println("4. Получение списка всех платежей");
        System.out.println("5. Посчитать сумму по договору");
        System.out.println("6. Вывести договоры");
        System.out.println("7. Вывести договоры c суммой");
    }
}
