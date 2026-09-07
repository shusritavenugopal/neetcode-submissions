class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build relationship between courses:
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] indegree = new int[numCourses];

        for (int[] prerequisite: prerequisites) {
            int course = prerequisite[0];
            int precourse = prerequisite[1];

            if (map.containsKey(precourse)) {
                map.get(precourse).add(course);
            } else { 
                List<Integer> list = new ArrayList<>();
                list.add(course);
                map.put(precourse, list);
            }
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int takenCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll(); //0
            takenCourses++;

            if (map.containsKey(current)) {
                for (int c: map.get(current)) {
                    indegree[c]--;
                    if (indegree[c] == 0) queue.offer(c);
                }
            }
        }
        return takenCourses == numCourses;
    }
}
