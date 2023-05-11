class Solution:
    def reverseBits(self, n: int) -> int:

        # Initialize the result to 0.

        res = 0

        # The main idea here is that we extract each bit one by one from right to left.
        # Then we start filling these bits in result from left to right.


        for i in range(32):

            # We extract ith bit from right by right shifting n by i 
            # and performing bitwise AND with 1.

            bit = (n >> i) & 1

            # To fill the extracted bit in result at ith position from left
            # we left shift the bit by 31-i and bitwise OR it with the current result.

            res = (bit << (31 - i)) | res
        
        return res