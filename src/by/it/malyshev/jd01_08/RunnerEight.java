package by.it.malyshev.jd01_08;

public class RunnerEight {

    public static void main(String[] args) {

        // создаем нейрохирурга и сразу даем ему больного пациента, которому нужна операция,
        // но не в области неврологии
        Surgeon neuroSurgeonA=new NeuroSurgeon("Теодор Лис",true,false,false);
        // спросим его имя
        System.out.println("Нейрохирург "+neuroSurgeonA.getDoctorName());
        // попытаемся отправить его отдохнуть
        neuroSurgeonA.haveARest();
        // пробуем выпить коньяка
        neuroSurgeonA.drinkCognac();
        // пробуем лечить без диагноза
        neuroSurgeonA.treatDisease();
        // определяем болен ли пациент
        neuroSurgeonA.diagnoseDisease();
        // выясняем работает ли хирург (этот метод можно развить детальнее)
        System.out.println(neuroSurgeonA.showState());
        // начинаем лечить больного пациента
        neuroSurgeonA.treatDisease();
        // пытаемся отправить на операцию
        neuroSurgeonA.makeOperation();
        // врач может отдохнуть
        neuroSurgeonA.haveARest();

        System.out.println("---");

        // создадим другого нейрохирурга
        NeuroSurgeon neuroSurgeonB=new NeuroSurgeon();
        // спросим его имя
        System.out.println("Нейрохирург "+neuroSurgeonB.getDoctorName());
        // дадим ему другое имя
        neuroSurgeonB.setDoctorName("Арчибальд Волк");
        // спросим его имя
        System.out.println("Нейрохирург "+neuroSurgeonB.getDoctorName());
        // пришел больной с симптомом "квадратная голова"
        neuroSurgeonB.setStateSquareHead(true);
        // ставим диагноз
        neuroSurgeonB.diagnoseDisease();
        // начинаем лечить
        neuroSurgeonB.treatDisease();
        // делаем операцию, результат ее непредсказуем 50 на 50, каждый раз будет новый
        neuroSurgeonB.makeOperation();
        // отдыхаем
        neuroSurgeonB.haveARest();

        System.out.println("---");
        // пришел больной с симптомом "слишком много мыслей"
        neuroSurgeonB.setStateSquareHead(false);
        neuroSurgeonB.setTwoManyThoughts(true);
        // ставим диагноз
        neuroSurgeonB.diagnoseDisease();
        // начинаем лечить
        neuroSurgeonB.treatDisease();
        // делаем операцию, результат ее непредсказуем
        neuroSurgeonB.makeOperation();

        System.out.println("---");
        // пришел больной с симптомами "слишком много мыслей" и "квадратная голова"
        neuroSurgeonB.setStateSquareHead(true);
        neuroSurgeonB.setTwoManyThoughts(true);
        // ставим диагноз
        neuroSurgeonB.diagnoseDisease();
        // начинаем лечить
        neuroSurgeonB.treatDisease();
        // делаем операцию, результат ее непредсказуем
        neuroSurgeonB.makeOperation();
        // запускаем метод, который потенциально можно развивать
        neuroSurgeonB.writeReport();
        // отдыхаем
        neuroSurgeonB.haveARest();
        // выясняем работает ли хирург (этот метод можно развить детальнее)
        System.out.println(neuroSurgeonB.showState());
        // и т.д. не все доработано :(, но не уверен, что оно того стоит...




    }
}
