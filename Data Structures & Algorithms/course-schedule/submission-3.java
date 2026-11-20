class Solution {
    // Map each course to its prerequisites
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
        // Store all courses along the current DFS path
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int[] p : prerequisites){
            preMap.get(p[0]).add(p[1]);
        }
        for(int c = 0;c<numCourses;c++){
            if(!dfs(c)) return false;
        }
        return true;
    }

    public boolean dfs(int clr){
        if(visiting.contains(clr)) return false;
        if(preMap.get(clr).isEmpty()) return true;

        visiting.add(clr);
        for(int p : preMap.get(clr)){
            if(!dfs(p)) return false;
        }
        visiting.remove(clr);
        preMap.put(clr,new ArrayList<>());
        return true;
    }
}