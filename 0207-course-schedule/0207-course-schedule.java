class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        

        //form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for(int i =0; i<m; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //calc indegree of each node
        int inDeg [] = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            for(int it : adj.get(i)){
                inDeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses;i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        List<Integer> ansTopo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();

            q.remove();
            ansTopo.add(node);
            for(int i : adj.get(node)){
                inDeg[i]--;
                if(inDeg[i] == 0) q.add(i);
            }
        }

        if(ansTopo.size() == numCourses) return true;
        return false;
        
    }
}