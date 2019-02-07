package by.it.malyshev.project.java.controller;

enum Actions {

    INDEX {
        {
            this.command = new CmdIndex();
        }
    },
    EDITUSERS {
        {
            this.command = new CmdEditUsers();
        }
    },
    EDITORDERS {
        {
            this.command = new CmdEditOrders();
        }
    },
    EDITMESSAGES {
        {
            this.command = new CmdEditMessages();
        }
    },
    ADDBOOK {
        {
            this.command = new CmdAddBook();
        }
    },
    EDITBOOK {
        {
            this.command = new CmdEditBook();
        }
    },
    LOGIN {
        {
            this.command = new CmdLogin();
        }
    },
    SIGNUP {
        {
            this.command = new CmdSignup();
        }
    },
    PROFILE {
        {
            this.command = new CmdProfile();
        }
    },
    BOOK {
        {
            this.command = new CmdBook();
        }
    },
    ORDER {
        {
            this.command = new CmdOrder();
        }
    },
    ERROR {
        {
            this.command = new CmdError();
        }
    };


    ICommand command;
}
