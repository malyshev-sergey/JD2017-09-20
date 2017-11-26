package by.it.malyshev.jd02_09;


import by.it.malyshev.jd02_09.manual.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class TaskB_GendataUnmarshalAndMarshal {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Gendata.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/malyshev/jd02_09/Gendata.xml");
            System.out.println("XML-файл прочитан:");
            Gendata gendata = (Gendata) u.unmarshal(reader);
            System.out.println(gendata);

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Gendata.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            Gendata gene = new Gendata() {
                {
                    Geocoord g=new Geocoord(46.9983, 7.4513);
                    STRmarkers strs=new STRmarkers(12,24,14,12,12,15,12,12,13,14,13,30);
                    Haplotype h=new Haplotype(strs, "L51-, Z2103+");
                    Person p=new Person("Archibald Volf", "Adam Volf", "Switzerland", g, h,"N22223");
                    this.add(p);

                    g=new Geocoord(53.8423, 11.4642);
                    strs=new STRmarkers(13,23,14,13,11,16,13,14,15,11,14,31);
                    h=new Haplotype(strs, "L23+, L51+, Z2103-");
                    p=new Person("Andreas Knopf", "Martin Knopf", "Germany", g, h,"322223");
                    this.add(p);
                }
            };
            m.marshal(gene, new FileOutputStream("src/by/it/malyshev/jd02_09/Gendata_taskB.xml"));
            System.out.println("\n\nXML-файл создан");
            m.marshal(gene, System.out);

        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        }
        catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }



    }
}
