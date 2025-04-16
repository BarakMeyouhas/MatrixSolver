import java.util.Scanner;

public class MatrixInputHandler {

    private final Scanner scanner;

    public MatrixInputHandler() {
        scanner = new Scanner(System.in);
    }

    public Matrix getUserMatrix() {
        System.out.print("enter the number of rows in the matrix:  ");
        int rows = scanner.nextInt();

        System.out.print("enter the number of columns in the matrix:  ");
        int cols = scanner.nextInt();

        Matrix matrix = new Matrix(rows, cols);

        System.out.println("enter the matrix values: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("values at row " + (i + 1) + ", columns " + (j + 1) + ": ");
                double value = scanner.nextDouble();
                matrix.setValue(i, j, value);
            }
        }

        return matrix;
    }
}
