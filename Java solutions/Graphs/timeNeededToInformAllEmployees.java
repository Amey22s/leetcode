import java.util.*;
class Solution {
    List<Integer>[] adjList;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        adjList = new List<>[n];

        generateAdjList(manager);

        int res = 0;

        res = getMaxPath(res, headID, informTime);

        return res;
        
    }

    private int getMaxPath(int res, int node, int[] it)
    {
        if(adjList[node] == null)
        {
            return 0;
        }

        int tempRes = 0;
        for(int sub : adjList[node])
        {
            tempRes = Math.max(tempRes, getMaxPath(res,sub,it));
        }

        res = it[node] + tempRes;
        return res;

    }

    private void generateAdjList(int[] manager)
    {
        for(int i = 0; i < manager.length; i++)
        {
            if(manager[i] == -1)
            {
                continue;
            }

            if(adjList[manager[i]] == null)
                adjList[manager[i]] = new ArrayList<>();

            adjList[manager[i]].add(i);
        }
    }
}