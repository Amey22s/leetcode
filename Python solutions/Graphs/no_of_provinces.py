from ast import List
class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:

        ROWCOL = len(isConnected)
        visited = [False] * ROWCOL
        count = 0

        def dfs(node: int):

            for i in range(ROWCOL):
                if not visited[i] and isConnected[node][i] == 1:
                    visited[node] = True
                    dfs(i)
            
        
        for i in range(ROWCOL):
            if not visited[i]:
                count += 1
                dfs(i)
        
        return count