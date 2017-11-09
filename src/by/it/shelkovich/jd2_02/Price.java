package by.it.shelkovich.jd2_02;

import java.util.ArrayList;
import java.util.List;

public class Price {
    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("Пиво", 5));
        products.add(new Product("Шоколад", 3));
        products.add(new Product("Хлеб", 1));
        products.add(new Product("Сметана", 2));
        products.add(new Product("Макароны", 3));
        products.add(new Product("Рис", 2));
        products.add(new Product("Сало", 5));
        products.add(new Product("Кефир", 2));
        products.add(new Product("Сыр", 4));
        products.add(new Product("Торт", 8));
    }
}
