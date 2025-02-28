import java.util.*;

public class Graph {
    private int n;
    private List<List<Integer>> adjacencyList;

    public Graph(int n) {
        this.n = n;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addRandomEdges(Random rand) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rand.nextBoolean()) {
                    adjacencyList.get(i).add(j);
                    adjacencyList.get(j).add(i);
                }
            }
        }
    }

    public Graph complement() {
        Graph complementGraph = new Graph(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!adjacencyList.get(i).contains(j)) {
                    complementGraph.adjacencyList.get(i).add(j);
                    complementGraph.adjacencyList.get(j).add(i);
                }
            }
        }

        return complementGraph;
    }

    public String printAdjacencyList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i).append(": ");
            for (int neighbor : adjacencyList.get(i)) {
                sb.append(neighbor).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean hasClique(int k) {
        return findClique(k, 0, new boolean[n], 0);
    }

    private boolean findClique(int k, int start, boolean[] visited, int count) {
        if (count == k) {
            return true;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i] && isClique(i, visited)) {
                visited[i] = true;
                if (findClique(k, i + 1, visited, count + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    private boolean isClique(int v, boolean[] visited) {
        for (int i = 0; i < n; i++) {
            if (visited[i] && !adjacencyList.get(v).contains(i)) {
                return false;
            }
        }
        return true;
    }

}
