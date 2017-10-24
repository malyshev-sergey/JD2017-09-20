package by.it.meshchenko.jd01_13;

import by.it.meshchenko.jd01_08.*;

public class NewBookCase extends Bookcase{
    private int dl, vs, gl;
    private int size = 0;
    private Stack stack;

    public NewBookCase(String model, int dl, int vs, int gl, int size)  throws NewBookCaseException{
        try{
        if(dl <= 0 || vs <= 0 || gl <= 0 || size <= 0){
            throw new NewBookCaseException("Заявленные параметры шкафа ("+dl+" x "+vs+" x "
                    +gl+" size="+size+") не корректны! ");
        }
        super.setModel(model);
        this.dl = dl;
        this.vs = vs;
        this.gl = gl;
        this.stack = new Stack(size);
        }
        catch (NewBookCaseException e){
            Util.printException(e);
        }
    }
}
