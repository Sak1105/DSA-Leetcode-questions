class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree of every course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Courses with no prerequisites
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int index = 0;

        // BFS
        while (!q.isEmpty()) {

            int curr = q.poll();

            ans[index++] = curr;

            // Remove curr as prerequisite
            for (int next : graph.get(curr)) {

                indegree[next]--;

                // All prerequisites completed
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // Cycle exists
        if (index != numCourses) {
            return new int[0];
        }

        return ans;
    }
}