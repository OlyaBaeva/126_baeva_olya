import java.util.Scanner;
import java.lang.*;
public class Crossword {

     // вывод на консоль заставки
    public static void printZ()  {
        String p2, p1, p3, p4, p5,p25;
        String z1, z2, z3, z4;
        p1 = " ";
        p2 = "  ";
        p3 = "   ";
        p4 = "    ";
        p5 = "     ";
        p25=p5+p5+p5+p5+p5+p5+p5+p5;
        z1 = "" + '\u2588';
        z2 = z1 + z1;
        z3 = z2 + z1;
        z4 = z3 + z1;
        for (int i=0; i<12;i++){
            System.out.println();
        }
        System.out.println(p25+z2+p4+z2+p3+z4+z3+p3+p2+z3+z3+p3+p2+z3+z3+p3+p2+z3+z3+p3+p1+z4+z3+p3+p2+z3+z3+p4+z4+z3+p3
                +p3+z3+z3);
        System.out.println(p25 + z2 + p4 + z2 + p3 + z3 + p2 + z3 + p3 + z3 + p2 + z3 + p3 + z3 + p2 + z3 + p3 + z3 + p2
                + z3 + p3 + z3 + p2 + z3 + p3 + z3 + p2 + z3 + p3 + z3 + p2 + z3 + p4 + z3 + p2 + z2);
        System.out.println(p25 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p4
                + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2);
        System.out.println(p25 + z2 + p2 + z2 + p5 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p5 + p4 + z2 + p5 + p4
                + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2);
        System.out.println(p25 + z2 + p1 + z2 + p3 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p5 + p4 + z2 + p5
                + p4 + z3 + p2 + z2 + p4 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2);
        System.out.println(p25 + z4 + p5 + p2 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p5 + p4 + z2 + p5 + p4 + z4
                + z2 + p5 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2);
        System.out.println(p25 + z4 + p4 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p5 + p4 + z2 + p4 + p5 + z3
                + p2 + z2 + p4 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2);
        System.out.println(p25 + z2 + p1 + z2 + p3 + p3 + z2 + p3 + z2 + p4 + z2 + p4 + z2 + p3 + z2 + p4 + p5 + z2 + p4
                + p5 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p3 + z2 + p5 + z2 + p3 + z2);
        System.out.println(p25 + z2 + p2 + z2 + p5 + z3 + z3 + p5 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2
                + p3 + z2 + p4 + z2 + p3 + z2 + p4 + z2 + p3 + z3 + z3+p5+p1+z2+p3+z2);
        System.out.println(p25+z2+p3+z2+p4+z2+p4+p5+z2+p4+z2+p3+z2+p4+z2+p3+z2+p4+z2+p3+z2+p4+z2+p3+z2+p4+z2+p3+z2+p4+p4
                +z4+z4+z3);
        System.out.println(p25+z2+p4+z2+p3+z2+p4+p5+z3+p2+z3+p3+z3+p2+z3+p3+z3+p2+z3+p3+z3+p2+z3+p3+z3+p2+z3+p3+z2+p4+p4
                +z2+p5+p2+z2);
        System.out.println(p25+z2+p4+z2+p3+z2+p5+p5+z3+z3+p5+z4+z2+p5+z3+z3+p4+z3+z4+p4+p1+z4+z2+p4+z2+p4+p5+z2+p5+z2);
        for (int i=0; i<12;i++){
            System.out.println();
        }
        //Пауза
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void printCross(char[][]T,String[] strQw){
        for (int i=0;i<T.length;i++) {
            for (int j = 0; j < T[0].length; j++) System.out.print(T[i][j]);
            System.out.print(strQw[i]);
            System.out.println();
        }
    }

    public static char[][] BoxG(int b,int c,int d, int n, char T[][], char A[]) {
        //Начало рамочки
        T[2 * b][4 * c] = A[0];
        T[2 * b + 1][4 * c] = A[5];
        T[2 * b + 2][4 * c] = A[4];
        String st1 = Integer.toString(n);
        if (st1.length() > 1) T[2 * b + 1][4 * c + 2] = st1.charAt(1);
        T[2 * b + 1][4 * c + 1] = st1.charAt(0);
        //Середина рамочки
        for (int i = c; i < d + 1; i++) {
            T[2 * b][4 * i + 1] = T[2 * b][4 * i + 2] = T[2 * b][4 * i + 3] = A[1];
            T[2 * b + 2][4 * i + 1] = T[2 * b + 2][4 * i + 2] = T[2 * b + 2][4 * i + 3] = A[1];
            T[2 * b][4 * i + 4] = A[10];
            T[2 * b + 1][4 * i + 4] = A[5];
            T[2 * b + 2][4 * i + 4] = A[9];
        }
        //Конец рамочки
        T[2 * b][4 * d + 4] = A[2];
        T[2 * b + 2][4 * d + 4] = A[3];
        return (T);
    }
    public static char[][] BoxV(int b,int c, int d, int n, char T[][], char A[]) {
        //начало рамочки
        if (T[2 * c][4 * b] == ' ') T[2 * c][4 * b] = A[0];
        if (T[2 * c][4 * b] == A[3]) T[2*c][4*b]=A[6];
        T[2 * c][4 * b + 1] = T[2 * c][4 * b + 2] = T[2 * c][4 * b + 3] = A[1];
        if (T[2 * c][4 * b + 4] == ' ') T[2 * c][4 * b + 4] = A[2];
        if (T[2 * c][4 * b + 4] == A[4]) T[2*c][4*b+4]=A[6];
        String st2 = Integer.toString(n);
        if (st2.length() > 1) T[2 * c + 1][4 * b + 2] = st2.charAt(1);
        T[2 * c + 1][4 * b + 1] = st2.charAt(0);
//середина Box
        for (int i = c; i < d + 1; i++) {
            if (i<d) {
                if (T[2 * i + 2][4 * b] == ' ') T[2 * i + 2][4 * b] = A[7];
                else T[2 * i + 2][4 * b] = A[6];
                if (T[2 * i + 2][4 * b + 4] == ' ') T[2 * i + 2][4 * b + 4] = A[8];
                else T[2 * i + 2][4 * b + 4] = A[6];
            }
            T[2 * i + 1][4 * b] = T[2 * i + 1][4 * b + 4] = A[5];
            T[2 * i + 2][4 * b + 1] = T[2 * i+2][4 * b + 2] = T[2 * i + 2][4 * b + 3] = A[1];
        }
        //конец Box
        if (T[2 * d + 2][4 * b] == ' ') T[2 * d + 2][4 * b] = A[4];
        if (T[2 * d + 2][4 * b] == A[2]) T[2*d+2][4*b]=A[6];
        if (T[2 * d + 2][4 * b + 4] == ' ') T[2 * d + 2][4 * b + 4] = A[3];
        if (T[2 * d + 2][4 * b + 4] == A[0]) T[2*d+2][4*b+4]=A[6];
        return (T);
    }

    private static boolean SearchGorRes(String result, String ansG[], char T[][], int StGor[][]){
        for (int i =0;i< ansG.length; i++){
            String St1= Integer.toString(i+1)+ ansG[i];
            if (result.equalsIgnoreCase(St1)){
                //Вносим ответ в массив Т
                for (int j = 0; j< StGor.length; j++){
                    if ((i+1)==StGor[j][3]) {
                        int B = StGor[j][0];
                        int C = StGor[j][1];
                        String St2 = ansG[i].toUpperCase();
                        for (int k =0; k< St2.length(); k++)  T[2*B+1][4*C+3+k*4] = St2.charAt(k);
                        // исключение повторных ответов
                        ansG[i]="ZzXxCcVv123";
                    return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean SearchVerRes(String result, String ansV[], char T[][], int StVer[][]){
        for (int i =0;i< ansV.length; i++){
            String St1= Integer.toString(i+1)+ ansV[i];
            if (result.equalsIgnoreCase(St1)){
                //Вносим ответ в массив Т
                for (int j = 0; j< StVer.length; j++){
                    if ((i+1)==StVer[j][3]) {
                        int B = StVer[j][0];
                        int C = StVer[j][1];
                        String St2 = ansV[i].toUpperCase();
                        for (int k =0; k< St2.length(); k++)  T[2*C+1+k*2][4*B+3] = St2.charAt(k);
                        // исключение повторных ответов
                        ansV[i]="ZzXxCcVv123";
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        char T[][] =new char[41][120];
        char A[]={'\u2554','\u2550','\u2557','\u255D','\u255A','\u2551','\u256C','\u2560','\u2563','\u2569','\u2566'};
        String[] comT = new String[19];
        String[] comF = new String[5];
        comT[1] = "Глаза болят, а руки делают";
        comT[0]= "Лёд тронулся, господа присяжные заседатели!";
        comT[2] = "Маловата, понимаешь, маловата будет!";
        comT[3] = "Голова предмет тёмный и исследованию не подлежит";
        comT[4] = "Меньше знаешь - больше гуглишь";
        comT[5] = "Что один человек собрал, другой завсегда разобрать сможет";
        comT[6] ="Умное лицо - это еще не признак ума";
        comT[7] = "Неработающая программа обычно приносит меньше вреда, чем работающая плохо";
        comT[8] = "Разгадывая кроссворд, оптимист пишет ручкой, а пессимист - карандашом";
        comT[9]= "Пол пути позади и немного осталось...";
        comT[10]= "Кроссворд - эспандер для мозгов";
        comT[11] = "Разгадывая кроссворд, чувствуешь себя многоклеточным";
        comT[12] = "Жизнь - кроссворд и не у каждого получается его отгадать правильно";
        comT[13] = "Сколько всего не сделано, а сколько ещё предстоит не сделать";
        comT[14] = "Как-то одного программиста спросили, а потом горько пожалели об этом";
        comT[15] = "Правильной дорогой идёте, товарищи!";
        comT[16] = "Семь бед - один reset";
        comT[17]= "Всё пропатчить и проапдейтить!";
        comT[18]="Стабильного коннекта, быстрого пинга!";
        comF[0]="А как всё хорошо начиналось!";
        comF[1]="Риск - благородное дело!";
        comF[2]="Но сегодня, граждане, вышла у вас промашка ужасная!";
        comF[3]="Если долго мучиться, что-нибудь получится...";
        comF[4]="Но вот утихла дрожь в руках, теперь - наверх!";
        String[] ansV = new String[10];
        String[] ansG = new String[9];
        String[] strQw= new String[47];
        for (int i =0;i<41;i++)
            for (int j = 0;j<120;j++) T[i][j]=' ';
            strQw[0]="По горизонтали:";
            strQw[1]="1.Процесс проверки работоспособности программы и ";
            strQw[2]="  исправления обнаруженных при этом ошибок";
            strQw[3]="2.Последовательность инструкций, предназначенных для ";
            strQw[4]="  выполнения компьютером";
            strQw[5]="3.Имя разработчика языка программирования Pascal";
            strQw[6]="4.Способ организации обработки данных, при котором ";
            strQw[7]="  алгоритм вызывает сам себя";
            strQw[8]="5.Название алгоритма, позволяющего найти наибольший ";
            strQw[9]="  общий делитель двух натуральных чисел";
            strQw[10]="6.Процесс пошагового выполнения программы";
            strQw[11]="7.Описание последовательности действий, приводящих ";
            strQw[12]="  от исходных данных к требуемому результату";
            strQw[13]="8.Процесс создания компьютерных программ";
            strQw[14]="9.Фамилия первого в мире программиста";
            strQw[15]="По вертикали:";
            strQw[16]="1.Условия, в которых действует исполнитель";
            strQw[17]="2.Алгоритмическая конструкция, в которой предусмотрен ";
            strQw[18]="  выбор одной из возможных последовательностей действий";
            strQw[19]="3.Советский математик, основоположник теории алгоритмов";
            strQw[20]="4.Величина, значение которой не меняется в процессе ";
            strQw[21]="  выполнения программы";
            strQw[22]="5.Команда языка программирования высокого уровня";
            strQw[23]="6.Набор некоторого числа однотипных элементов, которым ";
            strQw[24]="  присвоено одно имя";
            strQw[25]="7.Алгоритм, содержащий последовательность действий,";
            strQw[26]="   выполняемых многократно";
            strQw[27]="8.Оператор, который используется для записи ";
            strQw[28]="  разветвляющихся алгоритмов";
            strQw[29]="9.Объект, способный выполнять определенный набор команд";
            strQw[30]="10.Последовательность символолов, игнорируемая ";
            strQw[31]="  компилятором";
            strQw[32]="";
            strQw[33]="Для выхода из программы наберите 'Выход'";
            strQw[34]="";
            strQw[35]="Введите ответ: номер, пробел, слово";
            strQw[36]="";
            strQw[37]="";
            strQw[38]="";
            strQw[39]="";
            strQw[40]="";
            strQw[41]="";
            ansV[0]="среда";
            ansV[1]="ветвление";
            ansV[2]="марков";
            ansV[3]="константа";
            ansV[4]="оператор";
            ansV[5]="массив";
            ansV[6]="цикл";
            ansV[7]="условный";
            ansV[8]="исполнитель";
            ansV[9]="комментарий";
            ansG[0]="отладка";
            ansG[1]="программа";
            ansG[2]="никлаус";
            ansG[3]="рекурсия";
            ansG[4]="евклида";
            ansG[5]="трассировка";
            ansG[6]="алгоритм";
            ansG[7]="программирование";
            ansG[8]="лавлейс";
            //ввод координат клеток
        int StGor[][]={
                {3,0,6,1},{3,9,17,2},{4,19,25,3},{5,10,17,4},{7,5,11,5},{7,17,27,6},{9,0,7,7},{10,7,22,8},{12,9,15,9}};
        int StVer[][]={
                {4,0,4,1},{22,0,8,2},{6,2,7,3},{19,2,10,4},{11,3,10,5},{15,3,8,6},{8,4,7,7},{24,4,11,8},{1,5,15,9},
                {13,8,18,10}};
        //вывод заставки
        printZ();
        //обработка горизонтальных строк
        for (int i=0; i<StGor.length;i++){
            BoxG(StGor[i][0], StGor[i][1], StGor[i][2],StGor[i][3], T,A);
        }
        //обработка вертикальных строк
        for (int i=0;i< StVer.length;i++){
            BoxV(StVer[i][0], StVer[i][1], StVer[i][2],StVer[i][3], T,A);
        }
        printCross(T,strQw);
//игровой цикл
        boolean GameOver = false;
        int Nbox= ansV.length+ ansG.length;
        int t = 0;
        while (!GameOver){
            System.out.println("Введите ответ");
            String result = input.nextLine();
            //обработка строки
           result = result.replaceAll(" ","");
            if (result.equalsIgnoreCase("Выход")) GameOver=true;
            if (!GameOver) {
                //поиск в ответах по горизонтальным строчкам
                boolean SearchGor = SearchGorRes(result, ansG, T, StGor);
                //поиск в ответах по вертикальным строчкам
                boolean SearchVer = false;
                if (!SearchGor) SearchVer = SearchVerRes(result, ansV, T, StVer);
                if (SearchGor | SearchVer) {
                    Nbox -= 1;
                    printCross(T, strQw);
                    System.out.println(comT[Nbox+1]);
                    if (Nbox < 1) GameOver = true;
                } else {
                    printCross(T, strQw);
                    t+=1;
                    System.out.println(comF[t%6]);
                }
                if (Nbox == 0) {
                    System.out.println("Поздравляю,кроссворд решен");
                    GameOver = true;
                }
            }

        }
input.close();
}
}