package by.it.ali.jd02_02;

 class Tools {
    static int random (int from, int to){
        return (int)(Math.random()*(to-from)+from);
    }
    static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
