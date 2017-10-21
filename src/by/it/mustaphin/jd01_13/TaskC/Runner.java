package by.it.mustaphin.jd01_13.TaskC;

public class Runner {

    public static void main(String[] args) {
        ISale product = new Documental();
        System.out.printf("\nПоказ по кабельному телевидению %s\nПоказ в кинотеатрах%s\nВыход на Blue-Ray%s\nДоступен на youtube %s", product.cabelChannel(), product.cinema(), product.blueray(), product.free());
    }
}


