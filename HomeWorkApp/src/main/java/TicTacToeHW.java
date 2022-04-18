import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeHW {

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '_';

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman;
    private static char dotAI;
    private static int fieldSizeHorizontal;
    private static int fieldSizeVertical;
    private static int scoreHuman;
    private static int scoreAI;
    private static int roundCounter;
    private static int winLength;

    public static void main(String[] args) {
       startNewGame();
    }

    private static void startNewGame() {
        while (true) {

            chooseDot();
            playRound();

            System.out.printf("Счет:     ЧЕЛОВЕК        КОМП\n" +
                    "             %d            %d\n", scoreHuman, scoreAI);
            System.out.print("Хотите сыграть еще? (Y or N) >>>");

            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")) {
                System.out.println("До встречи!");
                break;
            }
        }
    }

    private static void playRound() {
        System.out.printf("Раунд %d начинается\n", ++roundCounter);
        initField(3, 3);
        printField();
        if (dotHuman == DOT_X) {
            humanFirst();
        } else {
            aiFirst();
        }
    }

    private static void  humanFirst() {
        while (true) {
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
            aiTurn();
            printField();
            if (gameCheck(dotAI)) {
                break;
            }
        }
    }

    private static void aiFirst() {
        while (true) {
            aiTurn();
            printField();
            if (gameCheck(dotAI)) {
                break;
            }
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
        }
    }

    private static boolean gameCheck(char dot) {
        if (checkWin(dot) && dot == dotHuman) {
            System.out.println("Человек победил");
            scoreHuman++;
            return true;
        } else if (checkWin(dot) && dot == dotAI) {
            System.out.println("Комп победил");
            scoreAI++;
            return true;
        }
        return checkDraw();
    }

    private static void chooseDot() {
        System.out.print("Введи 'X', чтобы играть Х. Чтобы играть 0, введи любой символ>>>");
        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")) {
            dotHuman = DOT_X;
            dotAI = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAI = DOT_X;
        }
    }

    private static void aiTurn() {
        int hor;
        int vert;

        do {
            hor = random.nextInt(fieldSizeHorizontal);
            vert = random.nextInt(fieldSizeVertical);
        } while (!isCellValid(vert, hor));

        field[vert][hor] = dotAI;
    }

    private static void humanTurn() {
        int hor;
        int vert;

        do {
            System.out.print("Введите координаты поля >>>>");
            hor = scanner.nextInt() - 1;
            vert = scanner.nextInt() - 1;
        } while (!isCellValid(vert, hor));

        field[vert][hor] = dotHuman;
    }

//    private static boolean checkWin(char dot) {
//        //horizontal
//        if(field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
//        if(field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
//        if(field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
//        //vertical
//        if(field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
//        if(field[1][0] == dot && field[1][1] == dot && field[2][1] == dot) return true;
//        if(field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
//        //diagonal
//        if(field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
//        if(field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;
//        return false;
//    }
    private static boolean checkWin(char dot) {
        for (int i = 0; i < 3; i++)
            if ((field[i][0] == dot && field[i][1] == dot &&
                    field[i][2] == dot) ||
                    (field[0][i] == dot && field[1][i] == dot &&
                            field[2][i] == dot))
                return true;
        if ((field[0][0] == dot && field[1][1] == dot &&
                field[2][2] == dot) ||
                (field[2][0] == dot && field[1][1] == dot &&
                        field[0][2] == dot))
            return true;
        return false;
    }

    private static boolean checkDraw() {

        for (int v = 0; v < fieldSizeVertical; v++) {
            for (int h = 0; h < fieldSizeHorizontal; h++) {
                if (field[v][h] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        System.out.println("Ничья");
        return true;
    }

    private static boolean isCellValid(int hor, int vert) {

        return hor >= 0 && vert >= 0 && vert < fieldSizeVertical && hor < fieldSizeHorizontal && field[vert][hor] == DOT_EMPTY;
    }

    private static void initField(int sizeHor, int sizeVert) {
        fieldSizeVertical = sizeVert;
        fieldSizeHorizontal = sizeHor;
        field = new char[fieldSizeVertical][fieldSizeHorizontal];

        for (int vert = 0; vert < fieldSizeVertical; vert++) {
            for (int hor = 0; hor < fieldSizeHorizontal; hor++) {
                field[vert][hor] = DOT_EMPTY;

            }

        }

    }

    private static void printField() {

        System.out.print("+");

        for (int i = 0; i < fieldSizeHorizontal * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }

        System.out.println();
        for (int i = 0; i < fieldSizeVertical; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeHorizontal; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeHorizontal * 2 + 1; i++) {
            System.out.print("_");
        }
        System.out.println();
    }
}
