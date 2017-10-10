package by.it.meshchenko.jd01_08;

// interface мебель
public interface IFurniture {
    // производство
    String production();
    // перевозить
    String transport();
    // собрать
    boolean assemble();
    // разбирать
    boolean disassemble();
    // эксплуатирование
    String exploitation();
    // обслуживание
    String service();
    // хранение
    String utilization();

}
