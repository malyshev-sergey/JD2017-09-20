package by.it.ali.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TaskB {
    static void SolveTaskB1() {

        String text = "She hasn’t been right since she hit the pheasant. It was a sign, she says. Of what, she doesn’t know, but it was definitely a sign. She worries about the lack of trees, about plastic in the oceans, about not waking up in the morning. She refuses to drive now. She closes her eyes and hums every time we pass a squashed rabbit or mangled fox. She grabs my knee, digs her claw nails deep into my flesh. It’s all just blood and guts and fur, she cries. Another pheasant, baking in the early evening sun. A badger, still twitching.";
        String[] textMas = text.split(" ");
        HashMap<String, Integer> count = new HashMap<>();
        List<String> textList = Arrays.asList(textMas);
        List<String> textArray = new ArrayList<>(textList);
        int k;
        System.out.println(textArray.get(2));
        for (int i = 0; i < textArray.size() ; i++) {
            k=0;
            for (int j = 0; j < textArray.size() ; j++) {
        if (textArray.get(i).equals(textArray.get(j)) && i!=j ) {
            k++;
            textArray.remove(textArray.get(j));
           j--;
        }
         }
            System.out.println(textArray.get(i)+" "+k);
        }
//        textArray.remove(2);
//        System.out.println(textArray.get(2));
//       for (int i = 0; i < textArray.size(); i++) {
//            count.put(textArray.get(i), 1);
//            for (int j = 0; j < textArray.size(); j++) {
//                if (textArray.get(i).equals(textArray.get(j))&& i!=j) {
//                    count.replace(textArray.get(i), k++);
//                    textArray.remove(textArray.get(j));
//                }
//            }
//        }
//        System.out.println(textArray);
//       System.out.println(count);
    }
}
