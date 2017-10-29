package by.it.shelkovich.calc;

public class CalcRunner {
    public static void main(String[] args) {


        try {
            /*System.out.println(Parser.exeOp("2.3 + 3").toString());
            System.out.println(Parser.exeOp("{-1,2,3} / 5").toString());
            System.out.println(Parser.exeOp("{{1,2},{4,5}} * {1,2}").toString());

            Parser.exeOp("C = 3");
            Parser.exeOp("c1 = {1,2,3}");
            Parser.exeOp("B = {{1,2},{4,5}}");
            Parser.exeOp("F = 3");
            Parser.exeOp("E = 3");
            Parser.exeOp("E1 = 3");
            Parser.exeOp("1E = 3");

            //Строки с арифметическими ошибками
            System.out.println(Parser.exeOp("{{1,2},{4,5}} * {1,2,3}").toString());
            System.out.println(Parser.exeOp("{-1,2,3} / 0").toString());*/
            VarFileIO varFile = new VarFileIO();
            varFile.loadFromFile();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        //VarFileIO varFile = new VarFileIO();
        //varFile.saveToFile();
        VarStorage.printVar();
        VarStorage.sortVar();

        for (int i = 0; i < 60; i++) {
            Logger.log(i+": сообщение");
        }

    }
}
