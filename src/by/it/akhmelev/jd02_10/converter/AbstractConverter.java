package by.it.akhmelev.jd02_10.converter;

import java.io.*;

abstract class AbstractConverter<T> {
    //тут будут данные, т.е. сам bean
    T bean;

    //поле класса нужно, т.к. может быть bean = null;
    private final Class<T> beanClass;
    //можно попробовать обойти этот недостаток, но довольно сложно:
    //https://habrahabr.ru/post/66593/

    AbstractConverter(Class<T> beanClass) {
        bean = null;
        this.beanClass = beanClass;
    }


    Class<T> getBeanClass() {
        return beanClass;
    }

    //построение по данным из строки
    abstract public void fromText(String txtData);

    //запись результата в строку
    abstract public String toText();

    //построение по данным из файла
    //метод не абстрактный, т.к. одинаков для всех)
    void fromText(File file) {
        String txtData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //специализированный метод (тот что здесь абстрактный)
        fromText(txtData);
    }

    //запись результата в файл
    //метод не абстрактный, т.к. одинаков для всех)
    void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(endFile))) {
            bufferedWriter.write(
                    //специализированный метод (тот что здесь абстрактный)
                    toText()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
