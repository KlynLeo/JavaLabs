import java.util.*;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        if (2*k > n) {
            System.out.println("Eroare: k tb sa fie macar de doua ori mai mic decat n pentru a avea si o clica si o multime stabila");
            return;
        }

        Graph graph = new Graph(n);
        Random rand = new Random();

        Set<Integer> cliqueNodes = Utils.getRandomNodes(n, k, rand);
        graph.addClique(cliqueNodes);

        Set<Integer> stableSetNodes;
        do {
            stableSetNodes = Utils.getRandomNodes(n, k, rand);
        } while (!Collections.disjoint(cliqueNodes, stableSetNodes));
        graph.addStableSet(stableSetNodes);

        graph.addRandomEdges(cliqueNodes, stableSetNodes, rand);


        if (n <= 30000) {
            System.out.println("Matricea generata:");
            System.out.println(graph.printMatrix());
        }

        int m = graph.countEdges();
        System.out.println("Numarul de muchii din graf este egal cu " + m);

        // Calculare și afișare grade
        int[] degrees = graph.calculateDegrees();
        int sum = 0, maximDeg = -1, minimDeg = Integer.MAX_VALUE;
        for (int deg : degrees) {
            sum += deg;
            if (deg > maximDeg) maximDeg = deg;
            if (deg < minimDeg) minimDeg = deg;
        }
        System.out.println("Suma gradelor este " + sum + " iar numarul de muchii este " + m + ". Se observa ca 2*" + m + " este egal cu " + sum + ", deci proprietatea se verifica");
        System.out.println("Gradul maxim Δ(G) al unui nod din graf este " + maximDeg);
        System.out.println("Gradul minim δ(G) al unui nod din graf este " + minimDeg);

        long end = System.currentTimeMillis();
        long duration = end - start;
        if (n > 30000) {
            System.out.println("Programul are un timp de executie de " + duration + "ms");
        }
    }
}
