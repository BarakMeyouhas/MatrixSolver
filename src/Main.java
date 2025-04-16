public class Main {
    public static void main(String[] args) {
        MatrixInputHandler inputHandler = new MatrixInputHandler();
        Matrix userMatrix = inputHandler.getUserMatrix();

        System.out.println("\nthe entered matrix: ");
        userMatrix.printMatrix();
        Matrix solution = MatrixSolver.solve(userMatrix);
        String result = SolutionFormatter.formatSolution(solution);
        System.out.println("\nthe matrix after row echelon by gauss jordan");
        solution.printMatrix();
        System.out.println(result);

    }
}
