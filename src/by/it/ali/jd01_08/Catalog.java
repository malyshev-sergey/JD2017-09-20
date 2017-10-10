package by.it.ali.jd01_08;

public class Catalog extends Book {
    @Override
    public String showState(){
        String state="";
        if (this.isEditing()){
            state="Книга редактируется (готовят к изданию)";
        }
        if (this.isAdvertising()){
            state="Книга рекламируется (редактирование подходит к концу)";
        }
//        if (this.isPrinting(super(print))){
//            state="Книга издаётся";
//        }
        return state;
    }
    }
