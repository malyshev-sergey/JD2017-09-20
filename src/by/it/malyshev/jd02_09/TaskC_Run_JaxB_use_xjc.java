package by.it.malyshev.jd02_09;
//тут нужно указать путь к сгенерированным классам

import by.it.malyshev.jd02_09.generate.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TaskC_Run_JaxB_use_xjc {

        public static void main(String[ ] args) {
            try {

                JAXBContext jc = JAXBContext.newInstance(Gendata.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader("src/by/it/malyshev/jd02_09/GendataXsd.xml");
                System.out.println("XML-файл прочитан:");
                Gendata gene = (Gendata) u.unmarshal(reader);
                System.out.println(gene);

            } catch (JAXBException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }