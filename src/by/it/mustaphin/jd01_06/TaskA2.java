package by.it.mustaphin.jd01_06;

class TaskA2 {

    void countLetter(String text) {
        String[] textArr = text.split("[^а-яА-ЯёЁ]+");
        for (String word : textArr) {
            if (word.isEmpty()) {
                continue;
            }
            int count = 1;
            for (int i = 0; i < textArr.length; i++) {
                if (word.equalsIgnoreCase(textArr[i])) {
                    count++;
                    textArr[i] = "";
                }
            }
            System.out.printf("%-12s : %-2d\n", word, --count);
        }
    }

}
