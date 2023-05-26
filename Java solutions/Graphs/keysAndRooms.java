import java.util.*;
class Solution {
    List<List<Integer>> rooms;
    int[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int noOfRooms = rooms.size();
        this.rooms = rooms;
        this.visited = new int[noOfRooms];

        dfs(0);

        for(int i = 1; i < noOfRooms; i++)
        {
            if(visited[i] == 0)
            {
                return false;
            }
        }

        return true;
    }

    private void dfs(int node)
    {
        if(rooms.get(node).size() == 0)
        {
            return;
        }

        for(int i = 0; i < rooms.get(node).size(); i++)
        {
            int dest = rooms.get(node).get(i);

            if(visited[dest] == 1)
            {
                continue;
            }

            visited[dest] = 1;
            dfs(dest);
        }
        return;
    }
}