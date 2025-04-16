import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SolutionFormatter {

    public static String formatSolution(Matrix m) {
        int rows = m.getRowCount();
        int cols = m.getColCount();
        int vars = cols - 1;

        Map<Integer, String> expressions = new HashMap<>();
        List<String> freeVars = new ArrayList<>();
        boolean[] isFree = new boolean[vars];

        // זיהוי משתנים חופשיים
        for (int i = 0; i < rows; i++) {
            int pivot = -1;
            for (int j = 0; j < vars; j++) {
                if (Math.abs(m.getValue(i, j)) > 1e-8) {
                    pivot = j;
                    break;
                }
            }
            if (pivot != -1) {
                double val = m.getValue(i, vars);
                StringBuilder expr = new StringBuilder();
                expr.append(formatNumber(val));
                for (int j = pivot + 1; j < vars; j++) {
                    double coeff = m.getValue(i, j);
                    if (Math.abs(coeff) > 1e-8) {
                        isFree[j] = true;
                        expr.append(" - ").append(formatNumber(coeff)).append("*t").append(j);
                    }
                }
                expressions.put(pivot, expr.toString());
            }
        }

        // הוספת משתנים חופשיים
        for (int i = 0; i < vars; i++) {
            if (isFree[i]) {
                expressions.put(i, "t" + i);
                freeVars.add("t" + i);
            }
        }

        // בניית מחרוזת הפתרון
        StringBuilder result = new StringBuilder();
        result.append("S = { (");
        for (int i = 0; i < vars; i++) {
            result.append(expressions.getOrDefault(i, "t" + i));
            if (i < vars - 1)
                result.append(", ");
        }
        result.append(")");

        if (!freeVars.isEmpty()) {
            result.append(" | ");
            for (int i = 0; i < freeVars.size(); i++) {
                if (i > 0)
                    result.append(", ");
                result.append(freeVars.get(i)).append("in R");
            }
        }

        result.append(" }");
        return result.toString();
    }

    private static String formatNumber(double value) {
        if (Math.abs(value - Math.round(value)) < 1e-8) {
            return String.valueOf((int) Math.round(value));
        } else {
            return String.format(Locale.US, "%.3f", value);
        }
    }
}
