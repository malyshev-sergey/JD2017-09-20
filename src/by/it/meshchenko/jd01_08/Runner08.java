package by.it.meshchenko.jd01_08;

public class Runner08 {
    public static void main(String[] args){
        // interface Мебель <-- abstract class Шкаф <-- class Книжный Шкаф.
        // interface furniture <-- abstract class cupboard <-- class bookcase

        // Массив заказов
        Bookcase[] order;
        // Количество книг в шкафах
        int book = 3;

        // Отдел 'мебели'
        IFurniture steward;
        // Отдел 'шкафов'
        Cupboard cupboard;

        // Создаём 'заказы' на книжные шкафы
        System.out.println("***** В отдел 'Х' нужны шкафы:");
        Bookcase bookcase1 = new Bookcase("КШ-150", 1200, 1600, 350, 10);
        Bookcase bookcase2 = new Bookcase("КШ-250", 1400, 1800, 350, 12);
        Bookcase bookcase3 = new Bookcase("КШ-350", 1600, 2000, 350, 14);
        order = new Bookcase[] {bookcase1, bookcase2, bookcase3};

        // Оповещаем отдел 'шкафов' новыми заказами
        System.out.println("***** Оповещаем отдел 'шкафов' новыми заказами");
        for(Cupboard cup : order){
            cup.showOrderDimensions();
        }

        // Обработка заказов отделом 'мебели'
        System.out.println("***** Обработка заказов отделом 'мебели'");
        for(IFurniture ord : order){
            System.out.println(ord.production());
            System.out.println(ord.transport());
            if(ord.assemble()) System.out.println(ord.exploitation());
        }

        // Шкаф bookcase2 требует ремонта, обращаемся в отдел 'шкафов'
        System.out.println("***** Шкаф bookcase2 требует ремонта, обращаемся в отдел 'шкафов'");
        cupboard = bookcase2;
        System.out.println(cupboard.service());
        if(cupboard.assemble()) System.out.println(cupboard.exploitation());


        // Заполняем шкафы книгами
        System.out.println("***** Заполняем шкафы книгами");
        for(Bookcase bks : order){
            int i = 0;
            while (i < book){
                bks.pushBook();
                i++;
            }
        }

        // Шкаф bookcase2 решили утилизировать, вынимаем все книги и
        // обращаемся в отдел 'мебели'
        System.out.println("***** Шкаф bookcase2 решили утилизировать, вынимаем все книги и обращаемся в отдел 'мебели'");
        int j = book;
        while (j > 0){
            bookcase2.popBook();
            j--;
        }
        steward = bookcase2;
        System.out.println(steward.service());
        if(!steward.disassemble()) System.out.println(steward.utilization());

    }
}
