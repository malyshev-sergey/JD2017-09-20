package by.it.ali.jd01_12;


import java.util.*;


public class TaskB {
    static void SolveTaskB1() {
        System.out.println("[TaskB1]");
        String text = "She hasn’t been right since she hit the pheasant. It was a sign, she says. Of what, she doesn’t know, but it was definitely a sign. She worries about the lack of trees, about plastic in the oceans, about not waking up in the morning. She refuses to drive now. She closes her eyes and hums every time we pass a squashed rabbit or mangled fox. She grabs my knee, digs her claw nails deep into my flesh. It’s all just blood and guts and fur, she cries. Another pheasant, baking in the early evening sun. A badger, still twitching.";
        String[] textMas = text.split(" ");
        HashMap<String, Integer> count = new HashMap<>();
//        count
//        List<String> textList = Arrays.asList(textMas);
//        List<String> textArray = new ArrayList<>(textList);
//        int k;
//        System.out.println(textArray.get(2));
//        for (int i = 0; i < textArray.size() ; i++) {
//            k=0;
//            for (int j = 0; j < textArray.size() ; j++) {
//        if (textArray.get(i).equals(textArray.get(j)) && i!=j ) {
//            k++;
//            textArray.remove(textArray.get(j));
//           //j--;
//        }
//         }
//            System.out.println(textArray.get(i)+" "+k);
//        }
//        textArray.remove(2);
        //System.out.println(textArray.get(2));
        for (int i = 0; i < textMas.length; i++) {
           String key=textMas[i];
           if (count.containsKey(key))
            count.put(textMas[i], count.get(key)+1);
           else
            count.put(key,1);
        }
       System.out.println(count);
    }

    public static class Timer{
        private  long iniTime;
        private  Double Delta;
        Timer(){
            iniTime=System.nanoTime();
        }
        public  String toString(){
            Delta=(double)(System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();
            return "Прошло "+Delta.toString()+" микросекунд.";
        }

    }

    static void SolveTaskB2(){
        Timer t = new Timer();
        System.out.println("[TaskB2] Количество человек?");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nMas = new Integer[n];
        for (int i = 0; i <nMas.length ; i++) {
            nMas[i]=(int)(Math.random()*10);
            //System.out.println(nMas[i]);
        }
        List<Integer> numb= Arrays.asList(nMas);
        List<Integer> arLi = new ArrayList<>(numb);
        List<Integer> liLi = new LinkedList<>(numb);
            for (int i=1;  ; ) {
                if (arLi.size()==i) {i=1;}
                arLi.remove(i);
                //System.out.println("arLi.size()= "+ arLi.size()+" i="+i);
                if (arLi.size()==1) {break;}
                else if (Math.abs(arLi.size()-i)==1) {i=0;}
                else if (arLi.size()==i) {i=1;}
               else i=i+2;
            }
        System.out.println("ArrayList после удаления нужных элементов: "+arLi+" "+t);
        for (int i=1;  ; ) {
            if (liLi.size()==i) {i=1;}
            liLi.remove(i);
            if (liLi.size()==1) {break;}
            else if (Math.abs(liLi.size()-i)==1) {i=0;}
            else if (liLi.size()==i) {i=1;}
            else i=i+2;
        }
        System.out.println("LinkedList после удаления нужных элементов: "+liLi+" "+t);
        }
    }
