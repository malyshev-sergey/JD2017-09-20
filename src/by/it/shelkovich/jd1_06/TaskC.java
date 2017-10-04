package by.it.shelkovich.jd1_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskC {
    private static final int million = 1000000;

    static void part1() {
        String[] lines = Source.sourceText.split("\n");
        int maxLength = 0;
        for (String line : lines) {
            if (line.length() > maxLength) maxLength = line.length();
        }
        for (int i = 0; i < lines.length; i++) {
            int needSpace = maxLength - lines[i].length();
            if (needSpace > 0) {
                Pattern pattern = Pattern.compile(" ");
                Matcher matcher = pattern.matcher(lines[i]);
                int spaceCount = 0;
                while (matcher.find()) {
                    spaceCount++;
                }

                int intSpaces = needSpace / spaceCount;
                if (intSpaces > 0) {
                    StringBuilder spaces = new StringBuilder(" ");
                    for (int j = 0; j < intSpaces; j++) {
                        spaces.append(" ");
                    }
                    lines[i] = matcher.replaceAll(spaces.toString());
                }

                int remainSpaces = needSpace % spaceCount;
                if (remainSpaces > 0) {
                    StringBuilder line = new StringBuilder(lines[i]);
                    pattern = Pattern.compile("[ ]+");
                    matcher = pattern.matcher(lines[i]);
                    int offset = 0;
                    while (matcher.find()) {
                        if (remainSpaces > offset) {
                            line.replace(matcher.start() + offset, matcher.end() + offset, matcher.group() + " ");
                            offset++;
                        } else break;
                    }
                    lines[i] = line.toString();
                }

            }
            System.out.println(lines[i]);
        }

    }

    static void part2String() {
        long startTime = System.currentTimeMillis();
        String oneMillionSymb = "";
        String[] dictionary = Source.sourceText.split("[^А-Яа-яЁё]+");

        int longestWordLength = 0;
        //Поиск самого длинного слова в словаре
        for (String word : dictionary) {
            if (word.length() > longestWordLength) longestWordLength = word.length() + 1;
        }

        while (oneMillionSymb.length() < million) {

            int diff = million - oneMillionSymb.length();

            if (diff > longestWordLength) {
                int rnd = (int) (Math.random() * dictionary.length);
                oneMillionSymb += dictionary[rnd] + " ";
            } else {
                oneMillionSymb += getStrByLength(dictionary, diff);
            }

        }
        int execTime = (int) (System.currentTimeMillis() - startTime) / 1000;
        System.out.printf("\nСтрока (String) %s\nсостоящая из %d символов была сформирована за %d секунд\n ", oneMillionSymb, oneMillionSymb.length(), execTime);

    }

    static void part2StringBuilder() {
        long startTime = System.currentTimeMillis();
        StringBuilder oneMillionSymb = new StringBuilder(million);

        String[] dictionary = Source.sourceText.split("[^А-Яа-яЁё]+");


        int longestWordLength = 0;
        //Поиск самого длинного слова в словаре
        for (String word : dictionary) {
            if (word.length() > longestWordLength) longestWordLength = word.length() + 1;
        }

        while (oneMillionSymb.length() < million) {

            int diff = million - oneMillionSymb.length();

            if (diff > longestWordLength) {
                int rnd = (int) (Math.random() * dictionary.length);
                oneMillionSymb.append(dictionary[rnd]).append(" ");
            } else {
                oneMillionSymb.append(getStrByLength(dictionary, diff));
            }

        }
        int execTime = (int) (System.currentTimeMillis() - startTime) / 1000;
        System.out.printf("\nСтрока (StringBuilder) %s\nсостоящая из %d символов была сформирована за %d секунд\n ", oneMillionSymb, oneMillionSymb.length(), execTime);

    }

    private static String getStrByLength(String[] dictionary, int count) {
        String result = "";
        String tmp = "";
        for (String word : dictionary) {
            if (word.length() < count + 1 && word.length() > tmp.length())
                tmp = word;
            else if (word.length() == count)
                return word;
        }
        return tmp + " " + getStrByLength(dictionary, count - tmp.length());
    }
}
