package by.it.shelkovich.jd3_01;

public class A_AddUser {
    static void run(){

        DataBase.exeChangeQuery("INSERT INTO `users` (`username`, `passhash`, `description`, `role_id`, `name`, `surname`, `email`, `showPersonalData`) " +
                "VALUES('vasily16', 'e10adc3949ba59abbe56e057f20f883e', 'Серьёзный парень на серьёзной тачке', 3, 'Василий', 'Ручкин', 'vasily16@gmail.com', 0)," +
                "('marina_e', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'Владелица таксы и просто милаха! Мой вайбер 1312567, пишите!', 3, 'Марина', 'Емелина', 'emelina_m@tut.by', 1)," +
                "('nails_salon', 'd44779226be3e9d648bfe4713a0a9786', 'Салон ногтей \"У Вероники\". Лак, полировка, маникюр, педикюр, накладные, закладные, перекладные! +375(29)15-16-178', 3, 'Салон', 'Ногтей', 'nails1234@gmail.com', 1)," +
                "('admin', '8f728d6bfc4dd6cd00067451bf0fa0e4', 'Администратор', 1, 'Антон', 'Шелкович', 'anton.shelkovich@gmail.com', 0)");
    }
}
