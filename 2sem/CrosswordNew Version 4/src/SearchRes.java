import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Содержит методы для инициализации массива симолов рамок, внесения ответов
 */

public class SearchRes {
    public static char[] insertFrameChar() throws IOException {
        String[] array = new String[1];
        FileUtil.getStrings(array, "./inputDataFrameChar.txt", 1);

        // Парсинг строки в список чисел
        StringTokenizer st = new StringTokenizer(array[0]," ");
        List<Character> frameChar = new ArrayList<>();
        while(st.hasMoreTokens()){
            frameChar.add(Character.toChars(Integer.parseInt(st.nextToken()))[0]);
        }
        char[] myCharArray = new char[frameChar.size()];
        for(int i = 0; i < frameChar.size(); i++) {
            myCharArray[i] = frameChar.get(i);
        }
        return myCharArray;
    }

    public static void parseAndInsertIntoStGorAndStVer(String lineGor, String lineVer) throws IOException {
        insertFrameChar();
        // Парсинг строки в список чисел
        StringTokenizer st;
        st = new StringTokenizer(lineGor," ");
        List<Integer> numbers = new ArrayList<>();
        while(st.hasMoreTokens()){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Integer strGorSize = numbers.size()/4;
        CrosswordNew.StGor = new int[strGorSize][4];

        // Запись в статическую переменную StGor
        List<Integer> buffer = new ArrayList<>();
        for(int i = 0, arrayIndex = 0; i < numbers.size(); i++){
            buffer.add(numbers.get(i));
            if(buffer.size() == 4){
                CrosswordNew.StGor[arrayIndex] = buffer.stream().mapToInt(elem->elem).toArray();
                buffer.clear();
                arrayIndex++;
            }
        }

        st = new StringTokenizer(lineVer," ");
        numbers.clear();
        while(st.hasMoreTokens()){
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Integer strVerSize = numbers.size()/4;
        CrosswordNew.StVer = new int[strVerSize][4];

        for(int i = 0, arrayIndex = 0; i < numbers.size(); i++){
            buffer.add(numbers.get(i));
            if(buffer.size() == 4){
                CrosswordNew.StVer[arrayIndex] = buffer.stream().mapToInt(elem->elem).toArray();
                buffer.clear();
                arrayIndex++;
            }
        }
    }

    public static boolean SearchHorRes(String result, String[] ansG){
        for (int i =0;i< ansG.length; i++){
            String St1= Integer.toString(i+1)+ ansG[i];
            if (result.equalsIgnoreCase(St1)){
                //Вносим ответ в массив Т
                for (int j = 0; j< CrosswordNew.StGor.length; j++){
                    if ((i+1)==CrosswordNew.StGor[j][3]) {
                        int B = CrosswordNew.StGor[j][0];
                        int C = CrosswordNew.StGor[j][1];
                        String St2 = ansG[i].toUpperCase();
                        for (int k =0; k< St2.length(); k++) CrosswordNew.CrossField[2*B+1][4*C+3+k*4] = St2.charAt(k);
                        // исключение повторных ответов
                        ansG[i]="ZzXxCcVv123";
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean SearchVerRes(String result, String[] ansV){
        for (int i =0;i< ansV.length; i++){
            String St1= Integer.toString(i+1)+ ansV[i];
            if (result.equalsIgnoreCase(St1)){
                //Вносим ответ в массив Т
                for (int j = 0; j< CrosswordNew.StVer.length; j++){
                    if ((i+1)==CrosswordNew.StVer[j][3]) {
                        int B = CrosswordNew.StVer[j][0];
                        int C = CrosswordNew.StVer[j][1];
                        String St2 = ansV[i].toUpperCase();
                        for (int k =0; k< St2.length(); k++)  CrosswordNew.CrossField[2*C+1+k*2][4*B+3] = St2.charAt(k);
                        // исключение повторных ответов
                        ansV[i]="ZzXxCcVv123";
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
