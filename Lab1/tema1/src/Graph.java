import java.util.Random;
import java.util.Set;

public class Graph {
    private int n;
    private int[][] matrix;

    public Graph (int n)
    {
        this.n = n;
        this.matrix = new int[n][n];
    }

    // clica de dimesiune k
    public void addClique(Set<Integer> cliqueNodes) {
        for (int i : cliqueNodes) {
            for (int j : cliqueNodes) {
                if (i != j) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
        }
    }

    //multime stabila de dimensiune k
    public void addStableSet(Set<Integer> stableSetNodes) {
        for (int i : stableSetNodes) {
            for (int j : stableSetNodes) {
                matrix[i][j] = 0;
                matrix[j][i] = 0;
            }
        }
    }

    //mai adaug muchii pentru a fi random
    public void addRandomEdges(Set<Integer> cliqueNodes, Set<Integer> stableSetNodes, Random rand) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!cliqueNodes.contains(i) && !cliqueNodes.contains(j) &&
                        !stableSetNodes.contains(i) && !stableSetNodes.contains(j)) {
                    matrix[i][j] = rand.nextBoolean() ? 1 : 0;
                    matrix[j][i] = matrix[i][j];
                }
            }
        }
    }
    // Calcularea numărului de muchii
    public int countEdges() {
        int m = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    m++;
                }
            }
        }
        return m;
    }

    // Calcularea gradelor
    public int[] calculateDegrees() {
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degrees[i]++;
                }
            }
        }
        return degrees;
    }

    // Afișează matricea în format frumos
    public String printMatrix() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val == 1 ? "X " : "O ").append(" ");
            }
            sb.append("\n");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
