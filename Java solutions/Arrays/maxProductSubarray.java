class Solution {
    public int maxProduct(int[] nums) {


        // Initialize 3 variables to first element of the given array:
        // 1. minProd to store minimum product of a subarray till now.
        // 2. maxProd to store maximum product of a subarray till now.
        // 3. res to store final answer.

        int minProd = nums[0];
        int maxProd = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++)
        {

            // We keep minProd and maxProd because when we iterate over all elements,
            // if an element is negative, minProd becomes maxProd and vice versa because
            // multiplying with a negative number reverses the inequality.

            if(nums[i] < 0)
            {
                int temp = minProd;
                minProd = maxProd; 
                maxProd = temp;
            }

            // We keep minProd and maxProd up-to-date by comparing them with current element
            // to check if we need to reset the subarray or not. 

            minProd = Math.min(nums[i], minProd*nums[i]);
            maxProd = Math.max(nums[i], maxProd*nums[i]);

            // We check answer till now against maxProd to update res.

            res = Math.max(res,maxProd);
        }

        // Finally we return res.
        
        return res;

    }
}