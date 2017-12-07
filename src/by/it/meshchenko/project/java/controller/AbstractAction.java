package by.it.meshchenko.project.java.controller;

public abstract class AbstractAction implements ICommand {

    public abstract String jsp();

    @Override
    public String getJsp() {
        return this.jsp();
    }

    @Override
    public String toString(){
        return this.getClass().
                getSimpleName().
                replace("Cmd", "");
    }
}
