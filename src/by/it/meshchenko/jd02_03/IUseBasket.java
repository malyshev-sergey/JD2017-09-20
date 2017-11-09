package by.it.meshchenko.jd02_03;

public interface IUseBasket {
    void takeBasket();          //взял корзину
    void putGoodsToBasket(String keyGood, double price);    //положил выбранный товар в корзину
}
