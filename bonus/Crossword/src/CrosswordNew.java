import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

public class CrosswordNew {
        private static final char[][] CrossField =new char[41][120];
        private static final char[] FrameChar ={'\u2554','\u2550','\u2557','\u255D','\u255A','\u2551','\u256C','\u2560','\u2563','\u2569','\u2566'};
        // ввод координат клеток
        private static final int[][] StGor={
                {3,0,6,1},{3,9,17,2},{4,19,25,3},{5,10,17,4},{7,5,11,5},{7,17,27,6},{9,0,7,7},{10,7,22,8},{12,9,15,9}};
        private static final int[][] StVer={
                {4,0,4,1},{22,0,8,2},{6,2,7,3},{19,2,10,4},{11,3,10,5},{15,3,8,6},{8,4,7,7},{24,4,11,8},{1,5,15,9},
                {13,8,18,10}};
    private static final String GET_VERTICAL_URL = "./getAnsV.txt";
    private static final String GET_HORIZONTAL_URL = "./getAnsG.txt";
    private static final String GET_QUESTIONS_URL = "./getStrQw.txt";
    private static final String GET_COMMENTS_FALSE_URL = "./getComF.txt";
    private static final String GET_COMMENTS_TRUE_URL = "./getComT.txt";

        // вывод на консоль заставки
        public static void printPicture() throws IOException {
            for (int i=0; i<12;i++){
                System.out.println();
            }
            try {
                String symbolPic;
                FileInputStream focus = new FileInputStream("filename1.bin");
                DataInputStream reader = new DataInputStream(focus);
                for (int i = 0; i <12;i++ ){
                    symbolPic = reader.readUTF();
                    System.out.println(symbolPic);
                }
                reader.close();
            } catch (FileNotFoundException e){
                System.out.println("Ошибка файл не найден");
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i=0; i<2;i++){
                System.out.println();
            }
            System.out.println("                                                     Baeva International Company under the leadership of Danila Sysoev ");
            System.out.println("                                                                                 represents");
            for (int i=0; i<10;i++){
                System.out.println();
            }
            // Пауза
            try {
                Thread.sleep(3000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        public static void printCross(String[] strQw){
            for (int i = 0; i< CrossField.length; i++) {
                for (int j = 0; j < CrossField[0].length; j++) System.out.print(CrossField[i][j]);
                System.out.print(strQw[i]);
                System.out.println();
            }
        }

        public static void BoxHor(int Row, int BeginCol, int EndCol, int num) {
            // Начало рамочки
            frameGorStart(Row, BeginCol, num);
            // Середина рамочки
            frameGorMiddle(Row, BeginCol, EndCol);
            //Конец рамочки
            frameGorEnd(Row, EndCol);
        }

    private static void frameGorEnd(int Row, int EndCol ) {
        CrossField[2 * Row][4 * EndCol + 4] = FrameChar[2];
        CrossField[2 * Row + 2][4 * EndCol + 4] = FrameChar[3];
    }

    private static void frameGorMiddle(int Row, int BeginCol, int EndCol) {
        for (int i = BeginCol; i < EndCol + 1; i++) {
            CrossField[2 * Row][4 * i + 1] = CrossField[2 * Row][4 * i + 2] = CrossField[2 * Row][4 * i + 3] = FrameChar[1];
            CrossField[2 * Row + 2][4 * i + 1] = CrossField[2 * Row + 2][4 * i + 2] = CrossField[2 * Row + 2][4 * i + 3] = FrameChar[1];
            CrossField[2 * Row][4 * i + 4] = FrameChar[10];
            CrossField[2 * Row + 1][4 * i + 4] = FrameChar[5];
            CrossField[2 * Row + 2][4 * i + 4] = FrameChar[9];
        }
    }

    private static void frameGorStart(int Row, int BeginCol, int num) {
        CrossField[2 * Row][4 * BeginCol] = FrameChar[0];
        CrossField[2 * Row + 1][4 * BeginCol] = FrameChar[5];
        CrossField[2 * Row + 2][4 * BeginCol] = FrameChar[4];
        String st1 = Integer.toString(num);
        if (st1.length() > 1) CrossField[2 * Row + 1][4 * BeginCol + 2] = st1.charAt(1);
        CrossField[2 * Row + 1][4 * BeginCol + 1] = st1.charAt(0);
    }

    public static void BoxVer(int Col, int BeginRow, int EndRow, int num) {
            startVerFrame(Col, BeginRow, num);
            middleVerFrame(Col, BeginRow, EndRow);
            endVerFrame(Col, EndRow);
    }

        private static void endVerFrame(int Col, int EndRow) {
            if (CrossField[2 * EndRow + 2][4 * Col] == ' ') CrossField[2 * EndRow + 2][4 * Col] = FrameChar[4];
            if (CrossField[2 * EndRow + 2][4 * Col] == FrameChar[2]) CrossField[2* EndRow +2][4* Col]= FrameChar[6];
            if (CrossField[2 * EndRow + 2][4 * Col + 4] == ' ') CrossField[2 * EndRow + 2][4 * Col + 4] = FrameChar[3];
            if (CrossField[2 * EndRow + 2][4 * Col + 4] == FrameChar[0]) CrossField[2* EndRow +2][4* Col +4]= FrameChar[6];
        }

        private static void middleVerFrame(int Col, int BeginRow, int EndRow) {
            for (int i = BeginRow; i < EndRow + 1; i++) {
                if (i< EndRow) {
                    if (CrossField[2 * i + 2][4 * Col] == ' ') CrossField[2 * i + 2][4 * Col] = FrameChar[7];
                    else CrossField[2 * i + 2][4 * Col] = FrameChar[6];
                    if (CrossField[2 * i + 2][4 * Col + 4] == ' ') CrossField[2 * i + 2][4 * Col + 4] = FrameChar[8];
                    else CrossField[2 * i + 2][4 * Col + 4] = FrameChar[6];
                }
                CrossField[2 * i + 1][4 * Col] = CrossField[2 * i + 1][4 * Col + 4] = FrameChar[5];
                CrossField[2 * i + 2][4 * Col + 1] = CrossField[2 * i+2][4 * Col + 2] = CrossField[2 * i + 2][4 * Col + 3] = FrameChar[1];
            }
        }

        private static void startVerFrame(int Col, int BeginRow, int num) {
            if (CrossField[2 * BeginRow][4 * Col] == ' ') CrossField[2 * BeginRow][4 * Col] = FrameChar[0];
            if (CrossField[2 * BeginRow][4 * Col] == FrameChar[3]) CrossField[2* BeginRow][4* Col]= FrameChar[6];
            CrossField[2 * BeginRow][4 * Col + 1] = CrossField[2 * BeginRow][4 * Col + 2] = CrossField[2 * BeginRow][4 * Col + 3] = FrameChar[1];
            if (CrossField[2 * BeginRow][4 * Col + 4] == ' ') CrossField[2 * BeginRow][4 * Col + 4] = FrameChar[2];
            if (CrossField[2 * BeginRow][4 * Col + 4] == FrameChar[4]) CrossField[2* BeginRow][4* Col +4]= FrameChar[6];
            String st2 = Integer.toString(num);
            if (st2.length() > 1) CrossField[2 * BeginRow + 1][4 * Col + 2] = st2.charAt(1);
            CrossField[2 * BeginRow + 1][4 * Col + 1] = st2.charAt(0);
        }

        private static boolean SearchHorRes(String result, String[] ansG){
            for (int i =0;i< ansG.length; i++){
                String St1= Integer.toString(i+1)+ ansG[i];
                if (result.equalsIgnoreCase(St1)){
                    //Вносим ответ в массив Т
                    for (int j = 0; j< StGor.length; j++){
                        if ((i+1)==StGor[j][3]) {
                            int B = StGor[j][0];
                            int C = StGor[j][1];
                            String St2 = ansG[i].toUpperCase();
                            for (int k =0; k< St2.length(); k++)  CrossField[2*B+1][4*C+3+k*4] = St2.charAt(k);
                            // исключение повторных ответов
                            ansG[i]="ZzXxCcVv123";
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private static boolean SearchVerRes(String result, String[] ansV){
            for (int i =0;i< ansV.length; i++){
                String St1= Integer.toString(i+1)+ ansV[i];
                if (result.equalsIgnoreCase(St1)){
                    //Вносим ответ в массив Т
                    for (int j = 0; j< StVer.length; j++){
                        if ((i+1)==StVer[j][3]) {
                            int B = StVer[j][0];
                            int C = StVer[j][1];
                            String St2 = ansV[i].toUpperCase();
                            for (int k =0; k< St2.length(); k++)  CrossField[2*C+1+k*2][4*B+3] = St2.charAt(k);
                            // исключение повторных ответов
                            ansV[i]="ZzXxCcVv123";
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) throws IOException {
            Scanner input = new Scanner(System.in);
            String[] comT = getComT();
            String[] comF = getComF();
            String[] ansG = getAnsG();
            String[] strQw = getStrQw();
            String[] ansV = getAnsV();
            for (int i =0;i<41;i++)
                for (int j = 0;j<120;j++) CrossField[i][j]=' ';
            printPicture();
            //обработка горизонтальных строк
            for (int i=0; i<StGor.length;i++){
                BoxHor(StGor[i][0], StGor[i][1], StGor[i][2],StGor[i][3]);
            }
            //обработка вертикальных строк
            for (int i=0;i< StVer.length;i++){
                BoxVer(StVer[i][0], StVer[i][1], StVer[i][2],StVer[i][3]);
            }
            printCross(strQw);

            boolean GameOver = false;
            int NumWord= ansV.length+ ansG.length;
            int t = 0;
            while (!GameOver){
                System.out.println("Введите ответ");
                String result = input.nextLine();
                //обработка строки
                result = result.replaceAll(" ","");
                if (result.equalsIgnoreCase("Выход")) GameOver=true;
                if (!GameOver) {
                    boolean SearchGor = SearchHorRes(result, ansG);
                    boolean SearchVer = false;
                    if (!SearchGor) SearchVer = SearchVerRes(result, ansV);
                    if (SearchGor | SearchVer) {
                        NumWord -= 1;
                        printCross(strQw);
                        System.out.println(comT[NumWord]);
                        if (NumWord < 1) GameOver = true;
                    } else {
                        printCross(strQw);
                        t+=1;
                        System.out.println(comF[t%6]);
                    }
                    if (NumWord == 0) {
                        for (int i=0; i<10;i++){
                            System.out.println();
                        }
                        System.out.println("                                                                Поздравляю,кроссворд решен");
                        System.out.println("                                                      Спасибо за внимание, новых интеректуальных вершин!");
                        for (int i=0; i<10;i++){
                            System.out.println();
                        }
                        GameOver = true;
                    }
                }

            }
            input.close();
        }

    private static String[] getAnsG() throws FileNotFoundException {
        String[] ansG = new String[9];
        return getStrings(ansG, GET_HORIZONTAL_URL, 9);
    }

    private static String[] getAnsV() {
        String[] ansV = new String[10];
        return getStrings(ansV, GET_VERTICAL_URL, 10);
    }

        private static String[] getStrQw() {
            String[] strQw= new String[47];
            return getStrings(strQw, GET_QUESTIONS_URL, 47);
        }

        private static String[] getComF() {
            String[] comF = new String[5];
            return getStrings(comF, GET_COMMENTS_FALSE_URL, 5);
        }

        private static String[] getComT() {
            String[] comT = new String[19];
            return getStrings(comT, GET_COMMENTS_TRUE_URL, 19);
        }
    private static String[] getStrings(String[] str, String url, Integer arraySize) {
        try {
            File file = new File(url);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            for(int i = 0; i < arraySize && line != null; i++){
                str[i] = line;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}

