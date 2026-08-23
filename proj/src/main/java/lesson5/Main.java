package lesson5;

import lesson5.exceptions.MyArrayDataException;
import lesson5.exceptions.MyArraySizeException;

public class Main {
    public static void main(String[] args) {

        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "j", "4"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        Main main = new Main();

        try {
            int result = main.processArray(arr);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        main.catchArrayIndexException(arr);
    }

    public int processArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4 || arr[i].length != 4) {
                throw new MyArraySizeException("Размер массива не соответствует требованиям 4х4");
            }
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }

    public void catchArrayIndexException(String[][] arr) {
        try {
            String element = arr[5][3];
            System.out.println("Элемент: " + element);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Перехвачено стандартное исключение: " + e);
        }
    }
}


