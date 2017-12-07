package by.it.meshchenko.project.java.controller;

public enum Actions {

    SIGNIN{
        {
            this.command = new CmdSignIn();
        }
    },
    REGISTER{
        {
            this.command = new CmdRegister();
        }
    },
    INDEX{
        {
            this.command = new CmdIndex();
        }
    },
    HOME{
        {
            this.command = new CmdHome();
        }
    },
    SIGNOUT{
        {
            this.command = new CmdSignOut();
        }
    },
    RESETDB{
        {
            this.command = new CmdResetDB();
        }
    };

    ICommand command;
}
