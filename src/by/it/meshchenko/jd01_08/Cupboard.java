package by.it.meshchenko.jd01_08;

public abstract class Cupboard implements IFurniture {

    private String model;
    private boolean isProduction = false;
    private boolean isTransport = false;
    private boolean stateAssemble = false;
    private boolean lock = false;

    public String getModel() {
        return model;
    }

    public void setModel(String m) {
        model = m;
    }

    // производство
    @Override
    public String production(){
        Util.showWorkThread(4);
        isProduction = true;
        return "Модель '" + model + "' изготовлена.";
    }
    // перевозить
    @Override
    public String transport(){
        Util.showWorkThread(2);
        isTransport = true;
        return "Модель '" + model + "' доставлена по месту требования.";
    }
    // собрать
    @Override
    public boolean assemble(){
        if(!lock && isProduction && isTransport) stateAssemble = true;
        return stateAssemble;
    }
    // разбирать
    @Override
    public boolean disassemble(){
        if(!lock && isProduction && isTransport) stateAssemble = false;
        return stateAssemble;
    }
    // эксплуатирование
    @Override
    public String exploitation(){
        if(stateAssemble) {
            lock = true;
            return "Модель '" + model + "' собрана, готова к использованию.";
        }
        return "Модель '" + model + "' разобрана!";

    }
    // обслуживание
    @Override
    public String service(){
        lock = false;
        Util.showWorkThread(4);
        return "Сервис модели '" + model + "' закончен.";
    }
    // утилизация
    @Override
    public String utilization (){
        lock = false;
        stateAssemble = false;
        isProduction = false;
        isTransport = false;
        Util.showWorkThread(5);
        return "Модель '" + model + "' утилизирована.";
    }

    // Заказ шкафа
    public abstract void showOrderDimensions();
    // вместимость шкафа
    public abstract Stack getStack();

}
