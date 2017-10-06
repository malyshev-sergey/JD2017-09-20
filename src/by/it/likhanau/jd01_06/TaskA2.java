package by.it.likhanau.jd01_06;


public class TaskA2 {
    public static void countNumberOfRepetitionsInPoem(String Poem) {
        String[] arrayOfWords = Poem.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (arrayOfWords[i].length() > 0) {
                int counter = 0;
                for (int j = i + 1; j < arrayOfWords.length; j++) {
                    if (arrayOfWords[i].equalsIgnoreCase(arrayOfWords[j])) {
                        counter++;
                        arrayOfWords[j] = "";
                    }
                }
                System.out.println("The number of repetitions of the word \"" + arrayOfWords[i] + "\" is " + counter + ".");
            }
        }
    }
}
