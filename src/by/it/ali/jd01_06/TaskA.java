package by.it.ali.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
   static String LUK = "У лукоморья дуб зелёный;\n" +
            "Златая цепь на дубе том:\n" +
            "И днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\n" +
            "Идёт направо - песнь заводит,\n" +
            "Налево - сказку говорит.\n" +
            "Там чудеса: там леший бродит,\n" +
            "Русалка на ветвях сидит;\n" +
            "Там на неведомых дорожках\n" +
            "Следы невиданных зверей;\n" +
            "Избушка там на курьих ножках\n" +
            "Стоит без окон, без дверей;\n" +
            "Там лес и дол видений полны;\n" +
            "Там о заре прихлынут волны\n" +
            "На брег песчаный и пустой,\n" +
            "И тридцать витязей прекрасных\n" +
            "Чредой из вод выходят ясных,\n" +
            "И с ними дядька их морской;\n" +
            "Там королевич мимоходом\n" +
            "Пленяет грозного царя;\n" +
            "Там в облаках перед народом\n" +
            "Через леса, через моря\n" +
            "Колдун несёт богатыря;\n" +
            "В темнице там царевна тужит,\n" +
            "А бурый волк ей верно служит;\n" +
            "Там ступа с Бабою Ягой\n" +
            "Идёт, бредёт сама собой,\n" +
            "Там царь Кащей над златом чахнет;\n" +
            "Там русский дух... там Русью пахнет!\n" +
            "И там я был, и мёд я пил;\n" +
            "У моря видел дуб зелёный;\n" +
            "Под ним сидел, и кот учёный\n" +
            "Свои мне сказки говорил.\n";

    static void SolveTaskA1() {
        Pattern p1 = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        StringBuilder sb = new StringBuilder(LUK);
        Matcher m = p1.matcher(sb);
        while (m.find()) {
            int start = m.start();
            int last = m.group().length();
            sb.setCharAt(start + 3, '#');
            if (last > 6) {
                sb.setCharAt(start + 6, '#');
            }
        }
        System.out.println(sb);
    }

    static void SolveTaskA2() {
        String[] sbMas = LUK.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < sbMas.length; i++) {
            if (sbMas[i].length() > 0) {
                int count = 1;
                for (int j = i+1; j < sbMas.length; j++) {
                    if (sbMas[i].equals(sbMas[j])) {
                        count++;
                        sbMas[j] = "";
                    }
                }
                System.out.printf("%7s%s%12s%3d\n","Слово ",sbMas[i],"повторяется",count);
            }
        }
    }
}

