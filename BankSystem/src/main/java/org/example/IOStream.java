package org.example;

import java.io.*;

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

    public static String input() {

        String arrayJsonTxt = null;
        try (FileInputStream fin = new FileInputStream("ClientsBase.txt")) {
            int i;
            arrayJsonTxt = "";
            while ((i = fin.read()) != -1) {

                System.out.print((char) i);
                arrayJsonTxt = new StringBuilder().append(arrayJsonTxt).append((char) i).toString();
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return arrayJsonTxt;
    }
}
