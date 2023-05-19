from ast import List
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:

        # We first initialize 4 pointers to travel through our matrix.
        # We also initialize a result list to store output.

        left = 0
        right = len(matrix[0]) - 1
        top = 0
        bottom = len(matrix) - 1
        
        res = []

        # The main idea here is to keep moving through the matrix till out boundary 
        # pointers don't cross each other.

        # We keep one of either row or column constant and iterate through other pointers.
        # Once we finish traversing one row or column, move that boundary in.

        # After each traversal check if our boundaries cross. If yes break out of the loop.

        while left <= right and top <= bottom:
            for i in range(left, right+1):
                res.append(matrix[top][i])

            top += 1

            if left > right or top > bottom:
                break


            for i in range(top, bottom+1):
                res.append(matrix[i][right])

            right -= 1

            if left > right or top > bottom:
                break


            for i in range(right, left-1, -1):
                res.append(matrix[bottom][i])

            bottom -= 1

            if left > right or top > bottom:
                break


            for i in range(bottom, top-1, -1):
                res.append(matrix[i][left])

            left += 1

            if left > right or top > bottom:
                break

        # Finally we return our result list.

        return res
        