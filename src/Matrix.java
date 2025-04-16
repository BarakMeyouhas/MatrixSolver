import java.util.Locale;

public class Matrix {

    private final double[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public void setValue(int row, int col, double value) {
        data[row][col] = value;
    }

    public double getValue(int row, int col) {
        return data[row][col];
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8s", formatNumber(data[i][j]));
            }
            System.out.println();
        }
    }

    public int getRowCount() {
        return rows;
    }

    public int getColCount() {
        return cols;
    }

    public Matrix clone() {
        Matrix copy = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                copy.setValue(i, j, data[i][j]);
            }
        }
        return copy;
    }

    private String formatNumber(double value) {
        if (Math.abs(value - Math.round(value)) < 1e-8) {
            return String.valueOf((int) Math.round(value));
        } else {
            return String.format(Locale.US, "%.3f", value);
        }
    }
}
