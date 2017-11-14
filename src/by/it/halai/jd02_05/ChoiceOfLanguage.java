package by.it.halai.jd02_05;


/**
 * @author Vitaly Halai
 */
class ChoiceOfLanguage {

    static String chooseCountry(String lang) {
        switch (lang) {
            case ("en"):
                return "EN";
            case ("be"):
                return "BY";
            case ("ru"):
                return "RU";
            default:
                return "Введено неверное условное обозначение";
        }

    }

}
