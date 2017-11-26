package by.it.shelkovich.jd2_10.converter;

import java.io.*;

public abstract class AbstractConverter <T> {
    Class<T> clazz;
    Direction direction;
    File file;

    public AbstractConverter(Class<T> clazz, Direction direction, File file){
        this.clazz = clazz;
        this.direction = direction;
        this.file = file;
    }


    public abstract String convert(String source);

    public String convert2String(){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            int ch;
            while((ch = reader.read()) != -1){
                sb.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convert(sb.toString());
    }

    public void convert2File(){
        String source = convert2String();
        File newFile;
        if (direction.equals(Direction.JSON_2_XML)) newFile = new File(file.getPath().replace(".json", ".xml"));
        else newFile = new File(file.getPath().replace(".xml", ".json"));

        if(newFile.exists()) newFile = new File(newFile.getPath().replace(".","1."));

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile))) {
            writer.write(source);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
