package by.it.akhmelev.jd02_10.converter;

import java.io.*;

abstract class AbstractConverter<T> {
    //тут будут данные, т.е. сам bean
    T bean;

    //поле класса нужно на случай, т.к. может быть bean = null;
    private final Class<T> beanClass;
    //можно обойти этот недостаток, но довольно сложно:
    //https://habrahabr.ru/post/66593/

    AbstractConverter(Class<T> beanClass) {
        bean = null;
        this.beanClass = beanClass;
    }


    Class<T> getBeanClass() {
        return beanClass;
    }

    //построение по данным из строки
    abstract public void buildConverter(String txtData);

    //запись результата в строку
    abstract public String getConverterResult();

    //построение по данным из файла
    //метод не абстрактный, т.к. одинаков для всех)
    void buildConverter(File file) {
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
        //специализированный builder (тот что здесь абстрактный)
        buildConverter(txtData);
    }

    //запись результата в файл
    //метод не абстрактный, т.к. одинаков для всех)
    void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(endFile))) {
            bufferedWriter.write(
                    //специализированный конвертер (тот что здесь абстрактный)
                    getConverterResult()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
