import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {

        boolean[][] reachable = new boolean[numCourses][numCourses];

        // Step 1: Mark direct prerequisites
        for (int[] p : prerequisites) {
            reachable[p[0]][p[1]] = true;
        }

        // Step 2: Find indirect prerequisites
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {

                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true;
                    }
                }
            }
        }

        // Step 3: Answer each query
        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}