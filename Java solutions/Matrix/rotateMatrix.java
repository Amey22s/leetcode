class Solution {
    public void rotate(int[][] matrix) {

        // The main idea we follow here is that we get the transpose of the matrix first
        // and then swap the columns from either ends till we don't get to the middle.

        getTranspose(matrix);

        // We get 2 pointers, one starting from leftmost column and other from rightmost
        // column. Swap all the elements in these columns and do this till both pointers 
        // don't overlap.

        for(int k = 0; k < matrix.length; k++)
        {
            for(int i = 0,j = matrix[0].length - 1; i <= j; i++,j--)
            {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
        }

        return; 
    }

    // This is a helper function to get transpose of given matrix. 
    // We do this by iterating over all elements and swap elements only when ith index
    // is greater than jth index(lower triangle of matrix). We do this because we don't
    // wanna swap elements where i = j and if we do swapping for all elements, we swap
    // twice which defeats the purpose of swapping.

    private void getTranspose(int[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(i > j)
                {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        return;
    }

}