import java.io.*;

/**
 * Содержит методы для чтения из файла
 */

public class FileUtil {
    public static String[] getStrings(String[] str, String url, Integer arraySize) {
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

    public static void crosswordTemplateInput(String fileName) {
        // Заполнение CrossField из файла
        String[] arrayTemp = new String[50];
        FileUtil.getStrings(arrayTemp, fileName, 50);
        for (int i = 0; i< 50; i++) {
            String temp = arrayTemp[i];
            for(int j = 0; j < 120; j++){
                CrosswordNew.CrossField[i][j] = temp.charAt(j);
            }
        }
    }


    public static String[] getAnsG() throws FileNotFoundException {
        String[] ansG = new String[CrosswordNew.QHor];
        return FileUtil.getStrings(ansG, CrosswordNew.GET_HORIZONTAL_URL, CrosswordNew.QHor);
    }

    public static String[] getAnsV() {
        String[] ansV = new String[CrosswordNew.QVer];
        return FileUtil.getStrings(ansV, CrosswordNew.GET_VERTICAL_URL, CrosswordNew.QVer);
    }

    public static String[] getStrQw() {
        String[] strQw= new String[50];
        return FileUtil.getStrings(strQw, CrosswordNew.GET_QUESTIONS_URL, 50);
    }

    public static String[] getComF() {
        String[] comF = new String[5];
        return FileUtil.getStrings(comF, CrosswordNew.GET_COMMENTS_FALSE_URL, 5);
    }

    public static String[] getComT() {
        String[] comT = new String[19];
        return FileUtil.getStrings(comT, CrosswordNew.GET_COMMENTS_TRUE_URL, 19);
    }
}
