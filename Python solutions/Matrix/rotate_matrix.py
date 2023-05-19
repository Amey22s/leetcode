from ast import List
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """

        # The main idea we follow here is that we get the transpose of the matrix first
        # and then swap the columns from either ends till we don't get to the middle.

        self.getTranspose(matrix)

        # We get 2 pointers, one starting from leftmost column and other from rightmost
        # column. Swap all the elements in these columns and do this till both pointers 
        # don't overlap.

        j,k = 0,len(matrix[0]) - 1

        while j <= k:
            for i in range(len(matrix)):
                temp = matrix[i][j]
                matrix[i][j] = matrix[i][k]
                matrix[i][k] = temp
            j += 1
            k -= 1

        return; 

    # This is a helper function to get transpose of given matrix. 
    # We do this by iterating over all elements and swap elements only when ith index
    # is greater than jth index(lower triangle of matrix). We do this because we don't
    # wanna swap elements where i = j and if we do swapping for all elements, we swap
    # twice which defeats the purpose of swapping.

    def getTranspose(self, matrix: List[List[int]]):

        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if i > j:
                    temp = matrix[i][j]
                    matrix[i][j] = matrix[j][i]
                    matrix[j][i] = temp

        return