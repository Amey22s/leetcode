class Solution {
    public int maxSubArray(int[] nums) {

        // Initialize globalSum and localSum to first element to begin with.
        int globalSum = nums[0];
        int localSum = nums[0];

        //Iterate over all the elements in the given array and update localSum and globalSum.

        for(int i = 1; i < nums.length; i++)
        {

            // If the localSum is negative, we know we don't want the subarray till now 
            // as it will only decrease the future sum. So in this case we set a fresh.

            // Else we add current element to localSum.

            if(localSum < 0)
            {
                localSum = nums[i];
            }
            else
            {
                localSum += nums[i];
            }

            // Now we compare localSum and globalSum and store max of the 2 in globalSum.

            globalSum = Math.max(globalSum,localSum);
        }

        // Finally return the globalSum.
        
        return globalSum;

        
    }
}