package by.it.ali.project.java.controller;

import javax.servlet.http.HttpServletRequest;

abstract class AbstractAction implements ICommand {
     @Override
     public String getJsp() {
         return "/" + this.toString().
                 toLowerCase() +
                 ".jsp";
     }

     @Override
     public String toString() {
         return this.getClass().
                 getSimpleName().
                 replace("Cmd", "");
     }

    public abstract ICommand execute(HttpServletRequest req);
}
