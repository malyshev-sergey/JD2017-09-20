package by.it.govor.jd01_08;

/**
 * Created by User on 09.10.2017.
 */
abstract class Building implements IBuilding {

    private boolean openTheater=false;
    private boolean play1=false;
    private boolean play2=false;
    private boolean play3 =false;
    private  int col=0;

   abstract  void showState();

    protected boolean isPlay1(){
        return  play1;

    }
    protected boolean isPlay2(){
        return  play2;
    }
    protected boolean isPlay3(){
        return  play3;
    }

    private boolean accessToTheater(){
       if (openTheater==false){
           System.out.println("Театр закрыт");
           return false;
       }else {
           return true;}
   }
    @Override
    public void play1() {
        if(accessToTheater()){
            play2 =false;
            play3 =false;
            play1= true;
            col++;
        }


    }

    public void play1(String s) {
        if(accessToTheater()){
            play2 =false;
            play3 =false;
            play1= true;
            col++;
            System.out.println("Играет "+s);
        }


    }
    @Override
    public void play2()
    { if(accessToTheater()){
        play1 =false;
        play3 =false;
        play2=true;
        col++;
    }

    }

    @Override
    public void play3() {
        if(accessToTheater()){
            play2 =false;
            play1 =false;
            play3= true;
            col++;
        }

    }

    @Override
    public void whatNowPlay() {
        if (accessToTheater()) {
            showState();

        }
    }

    @Override
    public void closTheater() {
        openTheater=false;
        play1=false;
        play2 =false;
        play3=false;
    }

    @Override
    public void openTheater() {
        openTheater=true;

    }
    public void col (){
        System.out.println("Сыграло "+col+" компазиций");
    }

}





