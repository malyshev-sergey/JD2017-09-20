package by.it.mustaphin.jd02_09.JAXB;

public class Runner {
    public static void main(String[] args) {
        JaxBToClass jbtc = new JaxBToClass();
        jbtc.convert();

        JaxBToXML jbtx = new JaxBToXML();
        jbtx.convert();
    }
}
