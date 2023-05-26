import java.util.*;
class Solution {
    public int findCircleNum(int[][] isConnected) {

        int ROWCOL = isConnected.length;
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for(int i = 0; i < ROWCOL; i++)
        {
            if(visited.add(i))
            {
                count++;
                dfs(i,visited,isConnected);
            }
        }

        return count;  
    }

    private void dfs(int node, Set<Integer> visited, int[][] isConnected)
    {

        for(int i = 0; i < isConnected.length; i++)
        {
            if(!visited.contains(i) && isConnected[node][i] == 1)
            {
                visited.add(i);
                dfs(i,visited,isConnected);
            }
        }

    }
}