package by.it.shelkovich.jd2_05;

import java.io.*;

public class Text2PropConverter {

    void convert(String filename) {
        String pathStr = System.getProperty("user.dir") + "/src/by/it/shelkovich/jd2_05/";

        File input = new File(pathStr + "txt/" + filename);
        File output = new File(pathStr + "res/"+ filename.substring(0, filename.indexOf(".")) + ".properties");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(input));
                BufferedWriter writer = new BufferedWriter(new FileWriter(output));

        ) {
            int ch;
            while ((ch = reader.read()) != -1) {
                if (ch > 127) {
                    StringBuilder sb = new StringBuilder(Integer.toHexString(ch));
                    while (sb.length() != 4) sb.insert(0, "0");
                    writer.write("\\u" + sb.toString());
                } else writer.write(ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
