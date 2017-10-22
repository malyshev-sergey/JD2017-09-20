package by.it.mustaphin.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TaskB1 {

    final String text = "I saw a small boy standing in the woods and crying, Raj added, His foot was bleeding. Can you help Meera? " +
            "Dr. Meera acknowledged, Sure, let's go." +
            "They both went to the boy. Meera checked him and found minor foot injury." +
            "Meera did basic dressing to kid. When she asked kid his name, he introduced himself as Krishna." +
            "Meera went speechless for a moment, but later-on they asked kid his address and dropped him home." +
            "While returning, Raj noticed Meera upset so he advised Meera, Please forget it. It was an accident, not your fault." +
            "Meera hugged him and said, I'm sorry Raj. I killed our child Krishna in that car accident. I miss him, don't you?" +
            "Somewhere deep inside the heart, a father was crying. With controlling feelings at border of eyes and giving fake smile, a husband lied, No, and added, It's past dear." +
            "Looking into Raj's eye Meera said, Krishna was always right. Daddy is big liar." +
            "Raj burst into tears, put his hand on Meera's womb and said, We have to be happy for future Krishna. God isn't unfair, you see!!" +
            "After 10 years," +
            "Little Krishna once again complained Meera by saying, Daddy is big liar...";

    void getRepeats() {
        String words[] = text.split("[^a-zA-Z’']");
        Map<String, Integer> unique = new HashMap<>();
        for (String word : words) {
            if (unique.containsKey(word)) {
                int count = unique.get(word) + 1;
                unique.put(word, count);
            } else {
                unique.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> me : unique.entrySet()) {
            System.out.printf("%-15s : %-2d\n", me.getKey(), me.getValue());
        }
    }

}
