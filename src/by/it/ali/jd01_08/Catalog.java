package by.it.ali.jd01_08;

public class Catalog extends Book {

    @Override
    public String showState(){
        String state="";
        if (this.isEditing()){
            state="Справочник редактируется (готовят к изданию)";
        }
        if (this.isAdvertising()){
            state="Справочник не рекламируется";
        }
        if (this.isPrinting()){
            state="Справочник издаётся";
      }

        return state;
    }
    }
