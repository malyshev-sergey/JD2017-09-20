package by.it.Biazverkhi.jd01_01;

class PrintArgs {
    void showArgs(String[] args) {
        for (String str : args)
            System.out.printf("Аргумент ==> %s%n", str);
    }
}