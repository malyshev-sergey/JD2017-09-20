package by.it.meshchenko.jd02_06;

class Run implements Runnable{
    private String name;
    Run(String name) {this.name = name;} //конструктор Run

    @Override
    public void run() {
        System.out.println(name+" приступил к работе");
        Logger log = Logger.getInstance();
        try {
            int i = 0;
            while(i < 3){
                Thread.sleep(Math.round(Math.random()*5000));  //работа
                String error = "Error " + i;
                System.out.println(name+" произошла ощибка '" + error + "', пишем ёе в лог");
                log.writeError(error);
                i++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
