class Solution {
    public void setZeroes(int[][] matrix) {

        // We create a variable rowZero to indicate whether the 0th row in our
        // output should be all 0s and set it to false to begin with.

        boolean rowZero = false;

        // The main idea here is to iterate over all elements in the matrix and 
        // if the element is 0 set corresponding element in its respective 0th row 
        // and 0th column to 0. 
        
        // Thus we use 0th row and 0th column as an indicator as to which rows and 
        // columns in the output should be 0s.

        // As there is an overlap at 0,0 we have rowZero. So if i (row index) is 0
        // and any element in 0th row is zero we set rowZero to True.

        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(i > 0)
                    {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                    else
                    {
                        rowZero = true;
                    }
                }
            }
        }

        // Now that we have our indicators set, we first iterate over our row indicator
        // which is nothing but 0th column.

        // We start from 1st index as for row zero we have a separate variable which we will 
        // use at the end.

        // So, now we check in 0th column for each row that has a 0, we set all elements in 
        // row to 0.

        for(int i = 1; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                for(int j = 1; j < matrix[0].length; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }

        // Now we do the same for column indicator. We iterate over our 0th row and check
        // for 0s. For the columns with 0 in 0th row, we set all elements in that column
        // to 0.


        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                for(int j = 1; j < matrix.length; j++)
                {
                    matrix[j][i] = 0;
                }
            }
        }

        // Finally, we check if rowZero is true, if yes, we set all elements in 0th row 
        // to 0s.

        if(rowZero)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                matrix[0][j] = 0;
            }
        }

        // The order in which we use the indicators is important.
        // It has to be :
        // 1. Row indicator (0th column)
        // 2. Column indicator (0th row)
        // 3. rowZero

        // This order is important because other indicators are independent of row indicator.
        // So setting rows from 1st row onwards using row indicator won't affect other indicator.

        // Row indicator is dependent on column indicator but as we have already used it, we can now
        // allow modifications to it. So now setting columns from 0th column onwards won't affect
        // anything as 0th column's purpose has been fulfilled.

        // Finally we use rowZero as it is dependent on column indicator but as we have already used it
        // we can now update row 0 values.

        return;
        
    }
}