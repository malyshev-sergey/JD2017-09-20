package by.it.meshchenko.jd01_07;

public class Runner07 {
    public static void main(String[] args){
        int a;
        // Инициализация статических и логических блоков при создании объектов:
            // static блок инициализируется только один раз,
            //      при первом создании объекта или при
            //      первом обращении к static методу;
            // логический блок инициализируется каждый раз,
            //      и только, при создании объекта класса
            System.out.println("Example1.main();");
            Example1.main();

            System.out.println("Example1 new1 = new Example1();");
            Example1 new1 = new Example1();
            System.out.println("Example1 new2 = new Example1();");
            Example1 new2 = new Example1(); // ''
            //System.out.println("Example1.main();");
            //Example1.main();



    }

    // add +
    // sub -
    // mol *
    // div /
    // public static void main(7, 8 , add)
}
