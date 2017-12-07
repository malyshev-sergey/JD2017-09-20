package by.it.likhanau.project.java.controller;


public enum Actions {

    LOGIN{
        {
         this.command = new CMDLogin();
        }
    },
    LOGOUT{
        {
            this.command = new CMDLogout();
        }
    },
    ERROR{
        {
            this.command = new CMDError();
        }
    };



    ICommand command;
}
