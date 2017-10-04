package by.it.shelkovich.jd1_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    static void part1() {

        String[] lines = Source.sourceText.split("\n");
        int maxLength = 0;
        for (String line: lines) {
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
                            line.replace(matcher.start()+offset, matcher.end()+offset, matcher.group()+" ");
                            offset++;
                        }else break;
                    }
                    lines[i] = line.toString();
                }

            }
            System.out.println(lines[i]);
        }


    }

    static void part2(){

    }
}
