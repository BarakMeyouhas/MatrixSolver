public class MatrixSolver {

    private static void swapRows(Matrix m, int row1, int row2) {
        int cols = m.getColCount();
        for (int j = 0; j < cols; j++) {
            double temp = m.getValue(row1, j);
            m.setValue(row1, j, m.getValue(row2, j));
            m.setValue(row2, j, temp);
        }
    }

    public static Matrix solve(Matrix matrix) {
        Matrix m = matrix.clone(); // כדי לא לשנות את המקור

        int rows = m.getRowCount();
        int cols = m.getColCount();

        for (int pivot = 0; pivot < rows; pivot++) {
            double pivotValue = m.getValue(pivot, pivot);

            // אם הפיבוט הוא אפס, ננסה להחליף שורות
            if (pivotValue == 0) {
                boolean swapped = false;
                for (int i = pivot + 1; i < rows; i++) {
                    if (m.getValue(i, pivot) != 0) {
                        swapRows(m, pivot, i);
                        swapped = true;
                        break;
                    }
                }
                if (!swapped) {
                    System.out.println("There is no single solution - the pivot is 0 and rows cannot be changed");
                    continue;
                }
                pivotValue = m.getValue(pivot, pivot);
            }

            // שלב 1: הפוך את הפיבוט ל-1
            for (int j = 0; j < cols; j++) {
                m.setValue(pivot, j, m.getValue(pivot, j) / pivotValue);
            }

            // שלב 2: אפס את כל הערכים בעמודה הנוכחית, חוץ מהפיבוט
            for (int i = 0; i < rows; i++) {
                if (i == pivot) {
                    continue;
                }

                double factor = m.getValue(i, pivot);
                for (int j = 0; j < cols; j++) {
                    double updatedValue = m.getValue(i, j) - factor * m.getValue(pivot, j);
                    m.setValue(i, j, updatedValue);
                }
            }
        }

        return m;
    }

}
