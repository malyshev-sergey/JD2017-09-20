package by.it.biazverkhi.jd01_04;


class Utils {


    //преобразование одной строки в массив чисел
    static int[] lineToIntArray(String line) {
// деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
//создаем и заполняем массив чисел
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }

    //сортируем массив
    static void sortArray(int[] array, boolean upDirection) {
        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j < array.length; j++){
                if ((upDirection && array[i] > array[j]) || (!upDirection && array[i] < array[j])) {
                    int r = array[i];
                    array[i] = array[j];
                    array[j] = r;
                }}}
    }


}
