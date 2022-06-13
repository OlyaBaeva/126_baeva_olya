import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Файл содержащий все методы для вывода на консоль: вывод кроссворда, двух.мерн. массива, заставки
 */

public class AppUtil {
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
        for (int i = 0; i< CrosswordNew.CrossField.length; i++) {
            for (int j = 0; j < CrosswordNew.CrossField[0].length; j++) System.out.print(CrosswordNew.CrossField[i][j]);
            System.out.print(strQw[i]);
            System.out.println();
        }
    }
}
