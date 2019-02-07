package by.it.malyshev.project.java.controller;

abstract class AbstractAction implements ICommand {
//    @Override
//    public abstract ICommand execute();

    @Override
    public String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().replace("Cmd", "");
    }
}



