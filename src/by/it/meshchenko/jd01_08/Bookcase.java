package by.it.meshchenko.jd01_08;

public class Bookcase extends Cupboard {

    private int dl, vs, gl;
    private int size = 0;
    private Stack stack;

    public Bookcase(String model, int dl, int vs, int gl, int size){
        super.setModel(model);
        this.dl = dl;
        this.vs = vs;
        this.gl = gl;
        this.stack = new Stack(size);
    }

    @Override
    public Stack getStack(){
        if(size > 0){
            this.stack = new Stack(this.size);
            return this.stack;
        }
        return null;
    }

    @Override
    public void showOrderDimensions(){
            System.out.printf("Книжный шкаф '%s' %n Длина x Высота x Глубина: %d x %d x %d %n", super.getModel(), dl, vs, gl);
    }

    public void pushBook(){
        stack.push(1);
        Util.showWorkThread(2);
        System.out.printf("Поставили книгу в шкаф: %s. %n", super.getModel());
    }

    public int popBook(){
        Util.showWorkThread(2);
        System.out.printf("Достали книгу из шкафа %s. %n", super.getModel());
        return stack.pop();
    }

}
