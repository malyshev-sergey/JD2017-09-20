package by.it.meshchenko.jd01_15;

public class TaskC {
    /*
    static void example1() throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/meshchenko/";
        String fileNameRead = src + "jd01_15/Runner15.java";
        String fileNameWrite = src + "jd01_15/Runner15.txt";

        boolean exit = true;
        while (exit){
            System.out.print("Введите число или 'end' для выхода: ");
            String str = Util.getOneLine();
            if(str.toLowerCase().compareTo("end") == 0) return;
            else {
                try{
                    printExample1(arr, str);
                }
                catch(NumberFormatException e){
                    System.out.println("NumberFormatException: " + str
                            + ": Недопустимое преобразование строки в числовой формат");
                }
                catch(IllegalArgumentException e){
                    System.out.println("IllegalArgumentException: Math.sqrt(" +str
                            + "): При вызове метода использован незаконный аргумент");
                }
                catch(Exception e){
                    Util.printException(e);
                }
            }
        }



        try(BufferedReader fr = new BufferedReader(
                new FileReader(Paths.get(fileNameRead).toAbsolutePath().toString()));
            BufferedWriter fw = new BufferedWriter(
                    new FileWriter(Paths.get(fileNameWrite).toAbsolutePath().toString()))
        ) {
            String strRead;
            String strWrite;

            while((strRead = fr.readLine()) != null) {
                strWrite = strWithoutComments(strRead, true);
                if(!strWrite.isEmpty()){
                    System.out.println(strWrite);
                    strWrite = strWrite.concat("\r\n");
                    fw.write(strWrite);
                }
            }
            System.out.println("Запись в файл '" + Paths.get(fileNameWrite).getFileName() + "' закончена");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }*/
}
