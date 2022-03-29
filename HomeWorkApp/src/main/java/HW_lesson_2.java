public class HW_lesson_2 {

    public static void main (String[] args) {
       System.out.println(boolBool(20, 8));
       positiveNegative(-90);
       System.out.println(boolBool2(-90));
       stringRepeat(4, "Слово");
       System.out.println(leapYear(3022, false));
    }

    private static boolean boolBool (int a, int b) {
        boolean c = (a + b) >=10 && (a + b) <= 20;
        return c;
    }

    private static void positiveNegative (int number) {
        if (number >= 0)  {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    private static boolean boolBool2(int e) {
        return e <= 0;
    }

    private static void stringRepeat(int r, String w) {
        for (int i = 0; i < r; ++i) {
            System.out.println(w);
        }
    }

    private static boolean leapYear(int y, boolean res) {

        if (y % 4 == 0 && y % 100 != 0) {
            res = true;
        } else if (y % 400 == 0) {
            res = true;
        }
        return res;
    }
}


