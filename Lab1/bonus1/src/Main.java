import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Introdu numarul de noduri: ");
        int n = scanner.nextInt();

        Graph graph = new Graph(n);
        graph.addRandomEdges(rand);

        System.out.println("Lista de adiacență a grafului:");
        System.out.println(graph.printAdjacencyList());

        System.out.print("Introdu dimensiunea k pentru a verifica daca exista o clica sau o multime stabila: ");
        int k = scanner.nextInt();

        if (graph.hasClique(k)) {
            System.out.println("Graful are o clica de dimensiune " + k);
        } else {
            System.out.println("Graful nu are o clica de dimensiune " + k);
        }

        Graph complementGraph = graph.complement();
        if (complementGraph.hasClique(k)) {
            System.out.println("Graful are o multime stabila de dimensiune " + k);
        } else {
            System.out.println("Graful nu are o multime stabila de dimensiune " + k);
        }

        scanner.close();
    }
}
