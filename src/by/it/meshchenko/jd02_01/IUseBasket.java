package by.it.meshchenko.jd02_01;

public interface IUseBasket {
    void takeBasket();          //взял корзину
    void putGoodsToBasket(String keyGood, double price);    //положил выбранный товар в корзину
}
