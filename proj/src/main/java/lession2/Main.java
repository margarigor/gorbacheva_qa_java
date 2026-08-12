package lession2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.printThreeWords();
        main.checkSumSign();
        main.printColor();
        main.compareNumbers();
        main.whereIsSum(3, 9);
        main.isPositive(8);
        main.isNegative(-9);
        main.printString("Oh no", 9);
        main.isViskos(2037);
        main.createArr();
        main.createArr2();
        main.createArr3();
        main.createMatrix();
        main.createArrLen(5, 90);
        System.out.println(Arrays.toString(main.createArrLen(5, 90)));
    }

    public void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public void checkSumSign() {
        int a = 5;
        int b = 9;
        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public void compareNumbers() {
        int a = 5;
        int b = 9;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public boolean whereIsSum(int a, int b) {
        boolean c;
        c = (a + b) >= 10 & (a + b) <= 20;
        return c;
    }

    public void isPositive(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public boolean isNegative(int a) {
        boolean c;
        c = a < 0;
        System.out.println(c);
        return c;
    }

    public void printString(String txt, int n) {
        for (int i = n; i > 0; i--) {
            System.out.println(txt);
        }
    }

    public boolean isViskos(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    public void createArr() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void createArr2() {
        int[] arr2 = new int[100];

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr2));
    }

    public void createArr3() {
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }

    public void createMatrix() {
        int[][] matrix = new int[5][5];

        for (int i = 0; i < 5; i++) {
            matrix[i][i] = 1;
        }
    }

    public int[] createArrLen(int len, int initialValue) {
        int[] arr4 = new int[len];

        for (int i = 0; i < len; i++) {
            arr4[i] = initialValue;
        }

        return arr4;
    }

}
