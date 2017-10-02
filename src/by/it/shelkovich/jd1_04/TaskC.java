package by.it.shelkovich.jd1_04;

class TaskC {

    static void run() {
        double[] oneLineArray = InOut.readArray();
        //double oneLineArray[] = {15, 256, 23, 43, 54, 193, 12234, 1, 1225, 56, 67, 93, 45, 67, 911, 11111, 222, 44444, 55};
        InOut.printArray("first", oneLineArray, 5);
        double first = oneLineArray[0], last = oneLineArray[oneLineArray.length - 1];

        System.out.println("\nОтсортированный массив:");
        Util.mergeSort(oneLineArray);
        InOut.printArray("sorted", oneLineArray, 4);

        System.out.printf("\nПосле сортировки первый символ (%4.2f) находится" +
                "в позиции %d, а последний (%4.2f) на позиции %d", first, Util.binarySearch(oneLineArray, first), last, Util.binarySearch(oneLineArray, last));
    }

}
