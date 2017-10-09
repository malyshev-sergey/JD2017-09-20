package by.it.ali.jd01_06;

public class TaskB {
    static void SolveTaskB1() {
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
        System.out.printf("\t%7s%26s%4d","TaskB1","Количество нужных слов: ",co);
    }
    static void SolveTaskB2(){
        String s = TaskA.LUK;
        s=s.replace("\n"," ");
        String save;
        String[] sbPredl = s.split("! |[.] [^а-я]");
        for (int i = 0; i < sbPredl.length ; i++) {
            for (int j = sbPredl.length-1; j > 0 ; j--) {
                if(sbPredl[j].length()<sbPredl[j-1].length()) {
                    save=sbPredl[j-1];
                    sbPredl[j-1]=sbPredl[j];
                    sbPredl[j]=save;
                }
            }
            System.out.println(sbPredl[i]);
        }
    }
}
