package by.it.malyshev.jd02_10;

import by.it.malyshev.jd02_09.manual.*;
import by.it.malyshev.jd02_10.converter.*;

import java.io.File;

public class TaskC_Runner {
    public static void main(String[] args) {
        File file;
        String src = System.getProperty("user.dir") + "/src/by/it/malyshev/";
        ConverterFactory<Gendata> converterFactory = new ConverterFactory<>();
        AbstractConverter<Gendata> converter;

        //из XML-файла в JSON-текст
        System.out.println("\n--- из XML-файла в JSON-текст\n");
        converter = converterFactory.getConverter("xml_to_json", Gendata.class);
        file = new File(src + "jd02_09/Gendata.xml");
        converter.fromText(file);
        String json = converter.toText();
        System.out.println(json);

        //из XML-файла в JSON-файл
        System.out.println("\n--- из XML-файла в JSON-файл\n");
        file = new File(src + "jd02_10/Gendata_taskC.json");
        converter.saveConverterResultToFile(file);
        System.out.println("\nok\n");

        //из JSON-файла в XML-текст
        System.out.println("\n--- из JSON-файла в XML-текст\n");
        converter = converterFactory.getConverter("json_to_xml", Gendata.class);
        file = new File(src + "jd02_10/Gendata_taskC.json");
        converter.fromText(file);
        String xml = converter.toText();
        System.out.println(xml);

        //из JSON-текста в XML-текст
        System.out.println("\n--- из JSON-текста в XML-текст\n");
        converter.fromText(json); //берем из предыдущего вызова конвертера
        xml = converter.toText();
        System.out.println(xml);

        //из JSON-файла в XML-файл
        System.out.println("\n--- из JSON-файла в XML-файл\n");
        file = new File(src + "jd02_10/Gendata_taskC.xml");
        converter.saveConverterResultToFile(file);
        System.out.println("\nok\n");






    }
}
