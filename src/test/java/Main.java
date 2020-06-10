//Homework 1, Liliia Lohvynenko

public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 10;
        int d = 5;
        int e = second(a, b, c, d);
        System.out.println("e = " + e);

        boolean result = three(c, d);
        System.out.println("Result " + result);

        four(-d);
        four(a);

        boolean result_5 = five(-c);
        System.out.println("Invoke method five with number " + (-c) + ": " + result_5);

        six("Liliia");
    }

    private static int second(int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    private static boolean three(int a, int b) {
        int sum = a + b;
        if (10 <= sum && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    private static void four(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    private static boolean five(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void six(String name){
        System.out.println("Привет, " + name + "!" );
    }
}


