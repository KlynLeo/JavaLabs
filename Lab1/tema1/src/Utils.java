import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utils {
    public static Set<Integer> getRandomNodes(int n, int k, Random rand) {
        Set<Integer> nodes = new HashSet<>();
        while (nodes.size() < k) {
            nodes.add(rand.nextInt(n));
        }
        return nodes;
    }
}
