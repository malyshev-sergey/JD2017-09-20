package by.it.shelkovich.jd3_01;

public class A_AddData {
    static void run(){
        DataBase.exeChangeQuery("INSERT INTO `posts` (`user_id`, `imageURL`, `description`, `likes`, `lat`, `lng`) " +
                "VALUES(1, '/img/2017/11/24/1.jpg', 'Переобул резину на моей малыхе, потому что скоро снег!', 3, '53.9395326', '27.5886809')," +
                "(2, '/img/2017/11/24/2.jpg', 'Была сегодня в @nails_salon, очень довольна! Смотрите как красиво получилось!', 17, NULL, NULL)," +
                "(3, '/img/2017/11/24/3.jpg', 'Акция! Рисуем паучков на ногтях! Всего 50 рублей! Не пропусти акцию в честь чёрной пятницы!', 250, NULL, NULL)");
        DataBase.exeChangeQuery("INSERT INTO `comments` (`user_id`, `post_id`, `text`) " +
                "VALUES(1, 2, 'Круто! Очень симпатично вышло!')," +
                "(3, 2, 'Спасибо, приходите ещё!')");
    }
}
