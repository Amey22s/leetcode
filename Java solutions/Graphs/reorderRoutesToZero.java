import java.util.*;;
class Solution {
    List<Integer>[] adjList;
    int count;
    int[] visited;
    public int minReorder(int n, int[][] connections) {

        adjList = new List[n]; 
        visited = new int[n];
        count = 0;

        buildGraph(connections);

        for(int i = 0; i < n; i++)
        {
            if(visited[i] == 0)
                dfs(i);
        }

        return count;
    }

    private void dfs(int node)
    {
        
        if(visited[node] == 1)
            return;
        
        if(adjList[node] == null)
            return;

        visited[node] = 1;

        for(int sub : adjList[node])
        {
            if(sub > 0 && visited[sub] != 1)
            {
                count++;
            }
            dfs(Math.abs(sub));
        }
    }

    private void buildGraph(int[][] connections)
    {
        for(int i = 0; i < connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];

            if(adjList[u] == null)
            {
                adjList[u] = new ArrayList<>();
            }
            if(adjList[v] == null)
            {
                adjList[v] = new ArrayList<>();
            }

            adjList[u].add(v);
            adjList[v].add(-1*u);
        }
    }
}