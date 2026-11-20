
class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visiting = new HashSet<>();
    private Set<Integer> processed = new HashSet<>();
    private List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            preMap.get(p[0]).add(p[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    public boolean dfs(int clr) {

        if (visiting.contains(clr)) return false;

        if (processed.contains(clr)) return true;

        visiting.add(clr);

        for (int p : preMap.get(clr)) {
            if (!dfs(p)) return false;
        }

        visiting.remove(clr);
        processed.add(clr);

        result.add(clr);

        return true;
    }
}
