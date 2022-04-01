import java.util.Arrays;
import java.util.Random;

public class HW_lesson_3 {
    public static void main (String[] args) {

//    1. Задать целочисленный массив, состоящий из
//    элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//    С помощью цикла и условия заменить 0 на 1, 1 на 0;

        int[] array1 = new int[11];
        Random r = new Random();
        for (int i = 0; i < 11; i++) {
            int key = r.nextInt(2);
            array1[i] = key;
        }
        System.out.println("Задание 1. Проверка значений " + Arrays.toString(array1));

        for (int i = 0; i < array1.length; i++)
            if (array1[i] == 1) {
                array1[i] = 0;
            } else {
                array1[i] = 1;
            }
        System.out.println("Повторная проверка значений " + Arrays.toString(array1));

//    2. Задать пустой целочисленный массив длиной 100.
//    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        System.out.println("Задание 2. Массив {1..100} " + Arrays.toString(array2));


//    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
//    и числа меньшие 6 умножить на 2;

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println("Задание 3. " + Arrays.toString(array3));


//    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
//    если обе сложно).
        int[][] array4 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            array4[i][i] = 1;
        }
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                System.out.print(array4[i][j] + "\t");
            }
            System.out.println();
        }

//    5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный
//    массив типа int длиной len, каждая ячейка которого равна initialValue;

//        private static int[] arr5 ( int len, int initialValue){
//
//            int[] array5 = new int[len];
//            for (int i = 0; i < len; i++) {
//                array5[i] = initialValue;
//            }
//            return array5;
//        }
    }

}