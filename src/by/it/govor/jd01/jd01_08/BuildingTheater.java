package by.it.govor.jd01.jd01_08;


public class BuildingTheater extends Building {
    private String s;
 public void showState(){

     if (this.isPlay1()){
         System.out.println("Играет Драма");
         s="Play1";
     }
     if (this.isPlay2()){
         System.out.println("Играет Комедия");
         s="Play2";
     }
     if (this.isPlay3()){
         System.out.println("Играет Мистерия");
         s="Play3";
     }

 }
    public String toString()
    {
        return "Все топчик";
    }
    public void coolic(){
        super.col();
    }
}
