class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Массив должен быть размером 4x4");
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int column;

    public MyArrayDataException(int row, int column) {
        super(String.format("Неверные данные в ячейке [%d][%d]", row, column));
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] array = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int rows = array.length;
        if (rows != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < rows; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}