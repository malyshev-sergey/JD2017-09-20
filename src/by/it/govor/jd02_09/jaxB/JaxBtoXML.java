package by.it.govor.jd02_09.jaxB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JaxBtoXML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Marshaller m = context.createMarshaller();
            Users st = new Users() {
                {

                    User.Address addr = new User.Address("BLR", "Minsk");
                    User us1 = new User("name1", "nick1", "phone1", addr);
                    this.add(us1);

                    User.Address addr2 = new User.Address("BLR", "Bobruisk");
                    User us2 = new User("name2", "nick2", "phone2", addr2);
                    this.add(us2);
                }
            };
            m.marshal(st, new FileOutputStream("src/by/it/govor/jd02_09/jaxB/XML1.xml"));
            System.out.println("XML-файл создан");
            m.marshal(st, System.out);
        } catch (FileNotFoundException e) {System.out.println("XML-файл не может быть создан: " + e);}
          catch (JAXBException e) {        System.out.println("JAXB-контекст ошибочен " + e);        }
    }
}