class Solution:
    def hammingWeight(self, n: int) -> int:
    
        # Initialize result to 0.
        res = 0

        # Keep performing operations till given number is not 0.
        while n:

            # We AND last (least significant) bit with 1 on each iteration.
            # This will give us 1 in case of last bit = 1 and 0 otherwise.
            # We add this to our existing res which in turn acts as a increment pointer.

            res += (n & 1)

            # We also right shift given number n by 1 bit in each iteration.

            n = n >> 1

        # Finally we return res.
        return res