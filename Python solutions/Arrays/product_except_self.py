from ast import List
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        # Initialize a res array to store result. Fill it with all 1s.
        # Initialize a prefixProd to 1.

        res = [1] * len(nums)
        prefix_prod = 1

        # Iterate over all the elements in the nums array and fill the res array with
        # prefixProd till that index. Keep updating that prefixProd value by multiplying it 
        # with current value of nums to be used as prefixProd for next element.

        for i in range(len(nums)):
            res[i] = prefix_prod
            prefix_prod *= nums[i]

        # Now that we have prefixProd for each element, we need postfixProd for each element.
        # We perform the same thing as above, this time from right to left.
        # Set postfixProd to 1 (you can also use the same variable used above and set that to 1)

        postfix_prod = 1

        # Iterate over all the elements in the nums array and fill the res array with
        # product of current element in res and postfixProd for that index.

        # We do this because we want product of all elements except that element which is 
        # nothing but prefixProd * postfixProd for that index.

        # Keep updating that postfixProd value by multiplying it 
        # with current value of nums to be used as postfixProd for next element.

        for i in range(len(nums) - 1, -1, -1):
            res[i] *= postfix_prod
            postfix_prod *= nums[i]

        return res;
