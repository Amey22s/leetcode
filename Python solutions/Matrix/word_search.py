from ast import List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        # The main idea here is to perform dfs starting from each element in matrix.
        # We perform dfs only if the current element in matrix is same as the first
        # letter of the word we are searching. 

        # If we find a path using our dfs funcntion, we return true and if we traverse 
        # all elements and haven't returned yet, we return false as the word is not 
        # found in the matrix.

        ROWS, COLS =len(board), len(board[0])
        visited = set()

    # This is a helper function dfs to navigate the entire matrix in all allowed
    # directions from current node recursively until either one these cases are met:

    # 1. We have breached matrix boundaries, return false.
    # 2. We have reached a node we already visited in this traversal, return false.
    # 3. The character of current element and character in the word we are looking for
    #    are different, return false.
    # 4. If we have a allowed element, isn't visited and matches the char we are looking 
    #    for, we mark it visited and perform dfs is all allowed directions from there
    #    recursively. Before this we check for the index we are at in the search word.
    #    If we have reached the end of word, we found it and hence return false.

    # We are basically looking for a path in the matrix from first char in word to last char
    # using allowed directions and not visiting any element twice.

    # Once our recursive calls are done and returned, we remove the current element from
    # visited as it is just a temp visited for this iteration.


        def dfs(r: int, c: int, idx: int) -> bool:

            if(r < 0 or c < 0 or r == ROWS or c == COLS 
                or board[r][c] != word[idx] or (r,c) in visited):
                return False
            
            if idx == len(word) - 1:
                return True
            
            visited.add((r,c))
            idx += 1
            
            if dfs(r+1,c,idx) or dfs(r-1,c,idx) or dfs(r,c-1,idx) or dfs(r,c+1,idx):
                return True
            
            visited.remove((r,c))

            return False

        for r in range(ROWS):
            for c in range(COLS):
                if board[r][c] == word[0] and dfs(r,c,0):
                    return True
        
        return False    