package by.it.shelkovich.jd1_13;

public class TaskA {
    static void run(){
        int totalSum = 0;
        System.out.println("Введите числа:");
        while(true){
            String line = Util.readLine();

            try{
                if("END".equals(line)){
                    break;
                }
                int num = Integer.parseInt(line);
                if (num<0) throw new ArithmeticException();
                totalSum +=(int)Math.sqrt(num);
                System.out.println("Введённое число: "+num+", сумма корней: "+totalSum);

            }catch (NumberFormatException e){
                System.out.println("Ошибка парсинга");
            }catch (ArithmeticException e){
                System.out.println("Ошибка извлечения корня");
            }
        }
    }
}
