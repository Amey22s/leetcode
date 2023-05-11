class Solution:
    def getSum(self, a: int, b: int) -> int:

        # The main idea here is to use XOR to get the sum of 2 least significant bits.
        # And use AND with left shift to get carry after adding 2 LSBs.

        # Set a as sum and b as carry and repeat until b is not finished.

        mask = 0xffffffff

        while b & mask > 0:
            
            sum = a ^ b
            carry = (a & b) << 1

            a = sum
            b = carry

        return a & mask if b > mask else a

        # 1.Why carry is a&b << 1:
        # If a and b are both 1 at the same digit, it creates one carry.
        # Because you can only use 0 and 1 in binary, if you add 1+1 together, it will roll that over to the next digit, and the value will be 0 at this digit.
        # if they are both 0 or only one is 1, it doesn't need to carry.

        # Use ^ operation between a and b to find the different bit
        # In my understanding, using ^ operator is kind of adding a and b together (a+b) but ignore the digit that a and b are both 1,
        # because we already took care of this in step1.


# Example1:

# a = 1 = 1
# b = 2 = 10


# First itertion:
# a = 01 b = 10

# sum = 01 ^ 10 = 11
# carry = (01 & 10) << 1 = 00 << 1 = 00

# Second iteration:
# a = 11 b = 00
# As b == 0, stop and return a


# Example 2:

# a = 2 = 10
# b = 3 = 11


# First itertion:
# a = 10 b = 11

# sum = 10 ^ 11 = 01
# carry = (10 & 11) << 1 = 10 << 1 = 100

# Second iteration:
# a = 01 b = 100

# sum = 001 ^ 100 = 101
# carry = (001 & 100) << 1 = 000 << 1 = 000

# Third iteration:
# a = 101 b = 000

# As b = 0, we stop and return a

        