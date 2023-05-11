class Solution {
    public int findMin(int[] nums) {

        // Initialize begin and finish to 0 and array length - 1 respectively.

        int beg = 0;
        int fin = nums.length - 1;

        // Now we perform binary search to get the min element.

        while(beg <= fin)
        {

            // If elements between beg and fin are sorted then nums[beg] has to be the min.
            if(nums[beg] <= nums[fin])
            {
                return nums[beg];
            }

            // Get min avoiding integer overflow.

            int mid = beg + ((fin - beg) / 2);

            // If the number at beg index (leftmost index) is smaller than number at mid index,
            // we can say min has to be on right of mid as nums[fin] < nums[beg] <= nums[mid].

            // Else the min will be mid or before it.

            // Imp Note: nums[beg] <= nums[mid] here = matters to move the beg pointer

            if(nums[beg] <= nums[mid])
            {
                beg = mid + 1;
            }
            else
            {
                fin = mid;
            }
        }

        // Finally, if we haven't return an answer till now, return nums[beg].

        return nums[beg];
        
    }
}