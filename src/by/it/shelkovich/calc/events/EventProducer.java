package by.it.shelkovich.calc.events;

import java.util.ArrayList;
import java.util.List;

public enum EventProducer {
    INSTANCE;

    List<IVarEventListner> listners = new ArrayList<>();

    public void addListner(IVarEventListner listner){
        listners.add(listner);
    }
    public void removeListner(IVarEventListner listner){
        listners.remove(listner);
    }
    public void notifyListners(String msg){
        for (IVarEventListner listner: listners) {
            listner.doAction(msg);
        }
    }
}
