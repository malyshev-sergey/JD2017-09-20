package by.it.likhanau.jd02_06;


public class Runner {
        public static void main(String[] args) {
            int [] array = new int[2];
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(array[i]);
            }
        } catch (Exception e){
            LoggerApp.getInstance().logError(e.getMessage());
        }
    }
}
