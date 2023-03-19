package org.example;

import java.io.*;

public class IOStream {

        public static void output(String ClientsJson) {

            try (FileOutputStream fos = new FileOutputStream("ClientsBase.json")) {
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

        String arrayJson = null;
        try (FileInputStream fin = new FileInputStream("ClientsBase.json")) {
            int i;
            arrayJson = "";
            while ((i = fin.read()) != -1) {

                arrayJson = String.valueOf(new StringBuilder().append(arrayJson).append((char) i));
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return arrayJson;
    }
}
