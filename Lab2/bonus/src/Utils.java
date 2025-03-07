import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.*;

public class Utils {

    public static boolean checkHallCondition(Map<Integer, Set<Integer>> studentPreferences, int totalStudents) {
        List<Integer> studentsList = new ArrayList<>(studentPreferences.keySet());

        for (int subsetSize = 1; subsetSize <= totalStudents; subsetSize++) {
            List<List<Integer>> subsets = getSubsets(studentsList, subsetSize);

            for (List<Integer> subset : subsets) {
                Set<Integer> projectsCovered = new HashSet<>();
                for (int student : subset) {
                    projectsCovered.addAll(studentPreferences.get(student));
                }
                if (projectsCovered.size() < subset.size()) {
                    return false; // Hall condition not satisfied
                }
            }
        }
        return true;
    }

    private static List<List<Integer>> getSubsets(List<Integer> students, int subsetSize) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(students, new ArrayList<>(), 0, subsetSize, subsets);
        return subsets;
    }

    private static void generateSubsets(List<Integer> students, List<Integer> currentSubset, int index, int size, List<List<Integer>> subsets) {
        if (currentSubset.size() == size) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }
        for (int i = index; i < students.size(); i++) {
            currentSubset.add(students.get(i));
            generateSubsets(students, currentSubset, i + 1, size, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void measurePerformance(int numStudents, int numProjects, int maxChoicesPerStudent) {
        long startTime = System.nanoTime();
        MemoryUsage initialMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        Map<Integer, Set<Integer>> preferences = GraphGenerator.generateGraph(numStudents, numProjects, maxChoicesPerStudent);

        boolean isMatchingPossible = checkHallCondition(preferences, numStudents);

        long endTime = System.nanoTime();
        MemoryUsage finalMemory = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        double executionTime = (endTime - startTime) / 1e6; // Convert to milliseconds
        double memoryConsumed = (finalMemory.getUsed() - initialMemory.getUsed()) / (1024.0 * 1024.0); // Convert to MB

        System.out.println("Matching is possible: " + isMatchingPossible);
        System.out.println("Execution time: " + executionTime + " ms");
        System.out.println("Memory used: " + memoryConsumed + " MB");
    }
}

