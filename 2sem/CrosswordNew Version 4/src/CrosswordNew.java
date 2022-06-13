import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

public class CrosswordNew {
    public static final char[][] CrossField = new char[50][120];
    public static Integer QHor;
    public static Integer QVer;
    public static char[] FrameChar;
    public static int[][] StGor;
    public static int[][] StVer;
    static String CROSSWORD_TEMPLATE_FILE_NAME;
    static String GET_VERTICAL_URL;
    static String GET_HORIZONTAL_URL;
    static String GET_QUESTIONS_URL;
    static String GET_COMMENTS_FALSE_URL = "./getComF.txt";
    static String GET_COMMENTS_TRUE_URL = "./getComT.txt";

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        FrameChar = SearchRes.insertFrameChar();
        for (int i = 0; i < 50; i++)
            for (int j = 0; j < 120; j++) CrossField[i][j] = ' ';
        AppUtil.printPicture();
        System.out.println("                                                                        Выберите тему кроссворда");
        System.out.println(" ");
        System.out.println("1. Космос (простой) ");
        System.out.println("2. Космос (сложный) ");
        System.out.println("3. Информатика (простой) ");
        System.out.println("4. Информатика (сложный) ");
        System.out.println("5. Экономика (простой) ");
        System.out.println("6. Экономика (сложный) ");
        System.out.println("Введите номер выбранного кроссворда");
        String number = input.nextLine();
        //обработка строки
        number = number.replaceAll(" ", "");

        String[] array = new String[12];
        FileUtil.getStrings(array, "./inputData.txt", 12);

        switch (number) {
            case ("1"): {
                QHor=10;
                QVer=10;
                SearchRes.parseAndInsertIntoStGorAndStVer(array[0], array[1]);
                GET_VERTICAL_URL = "./getAnsV1.txt";
                GET_HORIZONTAL_URL = "./getAnsG1.txt";
                GET_QUESTIONS_URL = "./getOneQues.txt";
                CROSSWORD_TEMPLATE_FILE_NAME = "crossword1.txt";
            }
            break;
            case ("2"): {
                QHor=10;
                QVer=10;
                SearchRes.parseAndInsertIntoStGorAndStVer(array[2], array[3]);
                GET_VERTICAL_URL = "./getAnsV2.txt";
                GET_HORIZONTAL_URL = "./getAnsG2.txt";
                GET_QUESTIONS_URL = "./getTwoQues.txt";
                CROSSWORD_TEMPLATE_FILE_NAME = "crossword2.txt";
            }
            break;
            case ("3"): {
                QHor=9;
                QVer=10;
                SearchRes.parseAndInsertIntoStGorAndStVer(array[4], array[5]);
                GET_VERTICAL_URL = "./getAnsV3.txt";
                GET_HORIZONTAL_URL = "./getAnsG3.txt";
                GET_QUESTIONS_URL = "./getThreeQues.txt";
                CROSSWORD_TEMPLATE_FILE_NAME = "crossword3.txt";
            }
            break;
            case ("4"): {
                QHor=10;
                QVer=10;
                SearchRes.parseAndInsertIntoStGorAndStVer(array[6], array[7]);
                GET_VERTICAL_URL = "./getAnsV4.txt";
                GET_HORIZONTAL_URL = "./getAnsG4.txt";
                GET_QUESTIONS_URL = "./getFourQues.txt";
                CROSSWORD_TEMPLATE_FILE_NAME = "crossword4.txt";

            }
            break;
            case ("5"): {
                QHor=11;
                QVer=9;
                SearchRes.parseAndInsertIntoStGorAndStVer(array[8], array[9]);
                GET_VERTICAL_URL = "./getAnsV5.txt";
                GET_HORIZONTAL_URL = "./getAnsG5.txt";
                GET_QUESTIONS_URL = "./getFiveQues.txt";
                CROSSWORD_TEMPLATE_FILE_NAME = "crossword5.txt";
            }
            break;
            case ("6"): {
                QHor=12;
                QVer=12;
                SearchRes.parseAndInsertIntoStGorAndStVer(array[10], array[11]);
                GET_VERTICAL_URL = "./getAnsV6.txt";
                GET_HORIZONTAL_URL = "./getAnsG6.txt";
                GET_QUESTIONS_URL = "./getSixQues.txt";
                CROSSWORD_TEMPLATE_FILE_NAME = "crossword6.txt";
            }
            break;
            default: {
                System.out.println("Извините, введенный вами номер отсутствует.");
                System.exit(0);
            }
        }
        String[] comT = FileUtil.getComT();
        String[] comF = FileUtil.getComF();
        String[] ansG = FileUtil.getAnsG();
        String[] strQw = FileUtil.getStrQw();
        String[] ansV = FileUtil.getAnsV();

        FileUtil.crosswordTemplateInput(CROSSWORD_TEMPLATE_FILE_NAME);
        AppUtil.printCross(strQw);

            boolean GameOver = false;
            int NumWord = ansV.length + ansG.length;
            int t = 0;
            while (!GameOver) {
                System.out.println("Введите ответ");
                String result = input.nextLine();
                //обработка строки
                result = result.replaceAll(" ", "");
                if (result.equalsIgnoreCase("Выход")) GameOver = true;
                if (!GameOver) {
                    boolean SearchGor = SearchRes.SearchHorRes(result, ansG);
                    boolean SearchVer = false;
                    if (!SearchGor) SearchVer = SearchRes.SearchVerRes(result, ansV);
                    if (SearchGor | SearchVer) {
                        NumWord -= 1;
                        AppUtil.printCross(strQw);
                        System.out.println(comT[NumWord%19]);
                        if (NumWord < 1) GameOver = true;
                    } else {
                        AppUtil.printCross(strQw);
                        t += 1;
                        System.out.println(comF[t % 6]);
                    }
                    if (NumWord == 0) {
                        for (int i = 0; i < 15; i++) {
                            System.out.println();
                        }
                        System.out.println("                                                                     Поздравляю,кроссворд решен");
                        System.out.println("                                                          Спасибо за внимание, новых интеректуальных вершин!");
                        for (int i = 0; i < 12; i++) {
                            System.out.println();
                        }
                        GameOver = true;
                    }
                }

            }
            input.close();
        }
    }


