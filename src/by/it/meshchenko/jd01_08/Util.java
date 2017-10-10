package by.it.meshchenko.jd01_08;

public class Util {
    public static void showWorkThread(int iTime){
        int i = 0, n =3;
        if(iTime > 0) n = iTime;
        while (i < n){
            System.out.print(" .");
            try{Thread.sleep(300);}
            catch (InterruptedException e){
                System.out.println("Главный поток исполнения прерван");
            }
            i++;
        }
    }
}
