class Solution {
    private boolean ok = true;
    private boolean[] color;
    private boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        for(int i = 0; i<n;i++){
            if(!visited[i]){
                traverse(graph, i);
            }
        }
        return ok;
    }
    

    public void traverse(int[][] graph, int i){
        if(!ok) return;
        visited[i] = true;
        for(int w : graph[i]){
            if(!visited[w]){
                color[w] = !color[i];
                traverse(graph, w);
            } else{
                if(color[w] == color[i]){
                    ok=false;
                }
            }
        }
    }
}

/*
Equivalent definitions of a bipartite graph:

There is no cycle of odd length

we can split the nodes of the graph
(vertex set of the graph) into 2 subsets so
that there is all the edges go from 1 subset
to the other subset.

3.The graph should be bi-colourable.
*/