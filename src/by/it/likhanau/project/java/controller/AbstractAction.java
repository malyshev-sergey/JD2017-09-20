package by.it.likhanau.project.java.controller;

/**
 * Created by NotePad.by on 01.12.2017.
 */
public abstract class AbstractAction implements ICommand {

    @Override
    public abstract ICommand execute();

    @Override
    public String getJSP() {
        String cmdName = this.getClass().getSimpleName();
        cmdName = cmdName.replace("Cmd", "").toLowerCase();
        return cmdName;
    }
}
