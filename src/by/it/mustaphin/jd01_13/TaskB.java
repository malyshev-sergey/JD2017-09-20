package by.it.mustaphin.jd01_13;

public class TaskB {

    void level3() {
        System.out.println("Start level 3");
        try {
            int err = 1 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("End level 3");
    }

    void level2() throws IllegalArgumentException {
        System.out.println("Start level 2");
        level3();
        double err = -1.0;
        if (0 > err) {
            throw new IllegalArgumentException("bad argument " + err);
        }
        Math.sqrt(err);
        System.out.println("End level 2");
    }

    void level1() throws IndexOutOfBoundsException, IllegalArgumentException {
        System.out.println("Start level 1");
        try {
            level2();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        int arr[] = {0};
        arr[1] = arr[2];
        System.out.println("End level 1");
    }

}
