class Solution {
    public boolean exist(char[][] board, String word) {

        // The main idea here is to perform dfs starting from each element in matrix.
        // We perform dfs only if the current element in matrix is same as the first
        // letter of the word we are searching. 

        // If we find a path using our dfs funcntion, we return true and if we traverse 
        // all elements and haven't returned yet, we return false as the word is not 
        // found in the matrix.

        int row = board.length;
        int col = board[0].length;
        boolean[][] visitedCords = new boolean[row][col];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(word.charAt(0) == board[i][j] && dfs(0,i,j,board,word,visitedCords))
                {
                    return true;
                }
            }
        }

        return false;
        
    }

    // This is a helper function dfs to navigate the entire matrix in all allowed
    // directions from current node recursively until either one these cases are met:

    // 1. We have breached matrix boundaries, return false.
    // 2. We have reached a node we already visited in this traversal, return false.
    // 3. The character of current element and character in the word we are looking for
    //    are different, return false.
    // 4. If we have a allowed element, isn't visited and matches the char we are looking 
    //    for, we mark it visited and perform dfs is all allowed directions from there
    //    recursively. Before this we check for the index we are at in the search word.
    //    If we have reached the end of word, we found it and hence return false.

    // We are basically looking for a path in the matrix from first char in word to last char
    // using allowed directions and not visiting any element twice.

    // Once our recursive calls are done and returned, we remove the current element from
    // visited as it is just a temp visited for this iteration.

    private boolean dfs(int charIndex, int rowIndex, int colIndex, char[][] board, String word, boolean [][] visitedCords)
    {

        if(charIndex >= word.length())
        {
            return true;
        }

        int row = board.length;
        int col = board[0].length;

        if(rowIndex >= row || colIndex >= col)
        {
            return false;
        }

        if(rowIndex < 0 || colIndex < 0)
        {
            return false;
        }

        if(visitedCords[rowIndex][colIndex])
        {
            return false;
        }

        if(board[rowIndex][colIndex] != word.charAt(charIndex))
        {
            return false;
        }

        charIndex++;
        visitedCords[rowIndex][colIndex] = true;

        if(dfs(charIndex, rowIndex+1, colIndex,board,word,visitedCords)
                || dfs(charIndex, rowIndex-1, colIndex,board,word,visitedCords)
                || dfs(charIndex, rowIndex, colIndex+1,board,word,visitedCords)
                || dfs(charIndex, rowIndex, colIndex-1,board,word,visitedCords))
                {
                    return true;
                }

        visitedCords[rowIndex][colIndex] = false;

        return false;
    }
}