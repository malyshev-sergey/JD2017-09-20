package by.it.akhmelev.jd02_10.converter;

import by.it.akhmelev.jd02_09.generate.Students;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File file;
        String src=System.getProperty("user.dir")+"/src/by/it/akhmelev/";
        ConverterFactory<Students> converterFactory=new ConverterFactory<>();

        //из XML-файла в JSON-текст
        System.out.println("\n--- из XML-файла в JSON-текст\n");
        AbstractConverter<Students> converter =
                converterFactory.createConverterBuilder("xml_to_json",Students.class);
        file=new File(src+"jd02_09/generate/xml_data.xml");
        converter.fromText(file);
        String json=converter.toText();
        System.out.println(json);

        //из XML-файла в JSON-файл
        System.out.println("\n--- из XML-файла в JSON-файл\n");
        file=new File(src+"jd02_09/generate/json_data.json");
        converter.saveConverterResultToFile(file);
        System.out.println("\nok\n");

        //из JSON-файла в XML-текст
        System.out.println("\n--- из JSON-файла в XML-текст\n");
        converter = converterFactory.createConverterBuilder("json_to_xml",Students.class);
        file=new File(src+"jd02_09/generate/json_data.json");
        converter.fromText(file);
        String xml=converter.toText();
        System.out.println(xml);

        //из JSON-текста в XML-текст
        System.out.println("\n--- из JSON-текста в XML-текст\n");
        converter = converterFactory.createConverterBuilder("json_to_xml",Students.class);
        converter.fromText(json); //берем из предыдущего вызова конвертера
        xml=converter.toText();
        System.out.println(xml);

    }
}
