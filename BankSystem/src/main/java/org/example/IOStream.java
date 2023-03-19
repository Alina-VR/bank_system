package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOStream {

        public static void output(String ClientsJson) {

            try (FileOutputStream fos = new FileOutputStream("ClientsBase.txt")) {
                // перевод строки в байты
                byte[] buffer = ClientsJson.getBytes();

                fos.write(buffer, 0, buffer.length);
                System.out.println("The file has been written");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
        }

    static String arrayJsonTxt = "";
    public static String input() {

        String arrayJson = null;
        try (FileInputStream fin = new FileInputStream("ClientsBase.json")) {
            int i;
            arrayJson = "";
            while ((i = fin.read()) != -1) {

                System.out.print((char) i);
                arrayJsonTxt = arrayJsonTxt + (char) i;
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        arrayJsonTxt = arrayJson;
        return arrayJsonTxt;
    }
}
