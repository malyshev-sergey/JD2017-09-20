package by.it.malyshev.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

class StAXparser {


    void parse(String fileName) {

        try {

            FileInputStream input = new FileInputStream(fileName);
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);

            StringBuilder el = new StringBuilder();
            StringBuilder tab = new StringBuilder();

            if (reader.getEventType() == XMLStreamConstants.START_DOCUMENT)
                System.out.println("startDocument");
            el.append("<?xml version=\"").append(reader.getVersion());
            el.append("\" encoding=\"").append(reader.getEncoding()).append("\"?>\r\n");
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {

                        el.append(tab).append("<").append(reader.getLocalName());
                        tab.append("\t");
                        int countNamespaces = reader.getNamespaceCount();
                        for (int i = 0; i < countNamespaces; i++) {
                            el.append(" ").append("xmlns");
                            if (reader.getNamespacePrefix(i) != null)
                                el.append(":").append(reader.getNamespacePrefix(i));
                            el.append("=\"").append(reader.getNamespaceURI(i)).append("\"");
                        }
                        int countAttr = reader.getAttributeCount();
                        for (int i = 0; i < countAttr; i++) {
                            el.append(" ");
                            if (reader.getAttributeLocalName(i).equals("schemaLocation"))
                                el.append(reader.getNamespacePrefix(i)).append(":");
                            el.append(reader.getAttributeLocalName(i)).append("=");
                            el.append("\"").append(reader.getAttributeValue(i)).append("\"");
                        }
                        el.append(">");
                        System.out.println(el.toString());
                        el.setLength(0);
                        break;
                    }

                    case XMLStreamConstants.CHARACTERS: {

                        el.append(reader.getText().trim());
                        break;
                    }

                    case XMLStreamConstants.END_ELEMENT: {

                        if (!el.toString().isEmpty()) {
                            el.insert(0, tab);
                            System.out.println(el);
                        }
                        tab.delete(0, 1);
                        el.setLength(0);
                        el.append(tab).append("</").append(reader.getLocalName()).append(">");
                        System.out.println(el.toString());
                        el.setLength(0);
                        break;
                    }
                    case XMLStreamConstants.END_DOCUMENT: {
                        System.out.println("endDocument");
                    }
                }
            }


        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }


}
