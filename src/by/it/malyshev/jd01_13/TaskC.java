package by.it.malyshev.jd01_13;

import by.it.malyshev.jd01_08.MedicalOperationException;
import by.it.malyshev.jd01_08.NeuroSurgeon;

/**
 * @author Sergey Malyshev
 */

public class TaskC {

    public static void main(String[] args) {
        System.out.println("Решение находится в пакете jd01_08\n\n");

        NeuroSurgeon neuroSurgeonA=new NeuroSurgeon();
        // дадим ему другое имя
        neuroSurgeonA.setDoctorName("Арчибальд Волк");
        // спросим его имя
        System.out.println("Нейрохирург "+neuroSurgeonA.getDoctorName());
        // пришел больной с симптомом "слишком много мыслей"
         neuroSurgeonA.setTwoManyThoughts(true);
        // ставим диагноз
        neuroSurgeonA.diagnoseDisease();
        // начинаем лечить
        neuroSurgeonA.treatDisease();
        // делаем операцию, результат ее непредсказуем


// тут может возникнуть исключени, которое будет обработано
        neuroSurgeonA.makeOperationWithExcCatch();

        System.out.println("---");
        // пришел больной с симптомами "слишком много мыслей" и "квадратная голова"
        neuroSurgeonA.setStateSquareHead(true);
        neuroSurgeonA.setTwoManyThoughts(true);
        // ставим диагноз
        neuroSurgeonA.diagnoseDisease();
        // начинаем лечить
        neuroSurgeonA.treatDisease();
        // делаем операцию, результат ее непредсказуем
        try {
// тут может возникнуть исключение, которое надо ловить
            neuroSurgeonA.makeOperation();
        } catch (MedicalOperationException e){

            System.out.println("--------------------\nВозникло исключени в процедуре makeOperation()");
            System.out.println("--------------------");
            System.out.println("класс исключения и сообщение "+e);
            System.out.println("исключение возникло в классе " + e.getStackTrace()[0].getClassName());
            System.out.println("номер строки исключения " + e.getStackTrace()[0].getLineNumber());
            System.out.println("глубина вложенности метода по стеку от main: "  +e.getStackTrace().length);
            System.out.println("\nпечатаем то же методом printStackTrace()");
            e.printStackTrace();
        }
    }

}
