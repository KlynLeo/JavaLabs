import java.util.*;

public class GraphGenerator {

    public static Map<Integer, Set<Integer>> generateGraph(int numStudents, int numProjects, int maxChoicesPerStudent) {
        Random rand = new Random();
        Map<Integer, Set<Integer>> studentPreferences = new HashMap<>();

        for (int student = 0; student < numStudents; student++) {
            int numOfChoices = rand.nextInt(maxChoicesPerStudent) + 1;
            Set<Integer> projects = new HashSet<>();
            while (projects.size() < numOfChoices) {
                projects.add(rand.nextInt(numProjects));
            }
            studentPreferences.put(student, projects);
        }
        return studentPreferences;
    }
}


