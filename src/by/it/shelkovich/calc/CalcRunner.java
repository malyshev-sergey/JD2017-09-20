package by.it.shelkovich.calc;

public class CalcRunner {
    public static void main(String[] args) {
        VarFileIO varFile = new VarFileIO();
        varFile.loadFromFile();
        Parser parser = new Parser();

        try {

            System.out.println(parser.calc("A=2+5.3"));
            System.out.println(parser.calc("B=A*3.5"));
            System.out.println(parser.calc("B1=B+0.11*-5"));
            System.out.println(parser.calc("B2=A/2-1"));

            System.out.println(parser.calc("C=B+(A*2)"));
            System.out.println(parser.calc("D=((C-0.15)-20)/(7-5)"));
            System.out.println(parser.calc("E={2,3}*(D/2)"));

        }catch (ArithmeticException e){
            e.printStackTrace();
        }
        
        VarStorage.printVar();
        VarStorage.sortVar();
        varFile.saveToFile();

        for (int i = 0; i < 60; i++) {
            Logger.log(i+": сообщение");
        }

    }
}
