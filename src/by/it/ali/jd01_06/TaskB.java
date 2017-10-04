package by.it.ali.jd01_06;

public class TaskB {
    static void SolveTaskA2() {
        String[] sbGlas = TaskA.LUK.split("[^а-яА-ЯёЁ]+");
        int co=0;
        for (int i = 0; i <sbGlas.length ; i++) {
            char first = sbGlas[i].charAt(0);
            char last = sbGlas[i].charAt(sbGlas[i].length()-1);

            String glasnye="аАуУеЕэЭоОыЫяЯиИюЮёЁ";
            if (glasnye.indexOf(first)>=0&&glasnye.indexOf(last)>=0)
            {
               co++;

            }
        }
        System.out.println("Количество нужных слов: "+co);
    }
}
