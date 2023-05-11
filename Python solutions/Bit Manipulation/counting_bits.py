from ast import List
class Solution:
    def countBits(self, n: int) -> List[int]:

        # Initialize a dp array, which will hold our result 
        # (an array of all n+1 integers as index and their 1 count at that index).
        # Fill it with all 0s. Also initialize an offset variable to 1.

        dp = [0] * (n+1)
        offset = 1

        # The main idea in this is that there is a pattern with respect to powers of 2.
        # Every power of 2 will have just one 1 which is nothing but 1+dp[0].
        # Every other value in between is 1 (because of new power of 2) + dp[i - offset]
        # (because of the previous occurred pattern).

        for i in range(1,n+1):

            # If the current i is a twice the current offset we know that this is the new offset.
            # So we multiply offset by 2

            offset = i if offset * 2 == i else offset

            # We compute 1s for current index using previously computed values.
            dp[i] = 1 + dp[i - offset]

        # Finally we return dp.
        return dp
        
