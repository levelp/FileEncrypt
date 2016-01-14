import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Шифрование файла
 */
public class Encoder {
    /**
     * @param srcFileName Исходный файл
     * @param dstFileName Файл, в который записываем
     * @param password    Символы пароля
     */
    public Encoder(String srcFileName,
                   String dstFileName,
                   char[] password) throws IOException {
        FileReader in = new FileReader(srcFileName);
        FileWriter out = new FileWriter(dstFileName);
        // "Исходный текст" <-- Текст из файла
        //  1231231231231  <-- Пароль
        //  0123456789...  <-- Индексы в файле
        //  0120120120120  <-- Индексы в пароле
        // Индекс символа в файле
        int i = 0;
        int c; // Символ из файла
        while ((c = in.read()) != -1) {
            // % - остаток от деления
            int passwordSymbol = password[i % password.length];
            int encoded = c ^ passwordSymbol; // "^" XOR
            out.write(encoded);
            i++; // Двигаемся по файлу
        }
        in.close();
        out.close();
    }
}
