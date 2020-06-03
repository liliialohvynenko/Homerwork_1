import java.util.Random;
import java.util.Scanner;

public class TicTaeToe {


    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = ' ';

    private static int fieldSizeX;
    private static int fieldSizeY;

    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        int fieldSize = 3;
        while (true) {
            init(fieldSize);
            printField();
            playOnce(fieldSize);
            System.out.println("Играть сначала?");
            if (SCANNER.next().equals("no")) {
                break;
            }
        }
    }

    private static void playOnce(int fieldSize) {
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Победил Игрок!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Победил Компьютер!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

        }
    }

    private static void init(int fieldSize) {
        fieldSizeX = fieldSize;
        fieldSizeY = fieldSize;

        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    //printField
    private static void printField() {
        System.out.println("=============");

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("| ");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + " | ");
            }
            System.out.println();
        }
    }

    private static boolean isValidField(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isNotEmptyField(int x, int y) {
        return field[y][x] != DOT_EMPTY;
    }

    private static void humanTurn() {
        // 3 1
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до " + fieldSizeY + ") через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidField(x, y) || isNotEmptyField(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (isNotEmptyField(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {
        boolean isWinHorizontal;
        boolean isWinVertical;
        boolean isWinDiagonal_1;
        boolean isWinDiagonal_2;

        for (int x = 0; x < fieldSizeX; x++) {
            isWinHorizontal = true;
            isWinVertical = true;
            for (int y = 0; y < fieldSizeY; y++) {
                isWinHorizontal = isWinHorizontal && field[x][y] == symbol;
                isWinVertical = isWinVertical && field[y][x] == symbol;

            }
            if (isWinHorizontal || isWinVertical) {
                return true;
            }

        }
        isWinDiagonal_1 = true;
        isWinDiagonal_2 = true;
        int y = 0;
        for (int x = fieldSizeX - 1; x >= 0; x--){
            isWinDiagonal_1 = isWinDiagonal_1 && field[x][x] == symbol;

            if (y == (fieldSizeY - 1 - x)) {
                isWinDiagonal_2 = isWinDiagonal_2 && field[x][y] == symbol;
            }
            y++;
        }
        return isWinDiagonal_1 || isWinDiagonal_2;
    }
}
