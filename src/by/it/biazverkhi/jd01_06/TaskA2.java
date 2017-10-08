package by.it.biazverkhi.jd01_06;


public class TaskA2 {
    public static void main(String[] args) {
        String TEXT = new String(Data.Text);
        String[] arr = TEXT.split("[^а-яА-ЯёЁ]");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 0) {

                int set = 1;
                for (int j = i + 1; j < arr.length; j++) {

                    if (arr[i].equalsIgnoreCase(arr[j])) {
                        set++;
                        arr[j] = "";
                    }
                }
                if (set == 2 || set == 3 || set == 4)
                System.out.println("Слово \"" + arr[i] + "\" упоминается в тексте " + set + " раза");

                else
                System.out.println("Слово \"" + arr[i] + "\" упоминается в тексте " + set + " раз");
            }
        }
    }
}

