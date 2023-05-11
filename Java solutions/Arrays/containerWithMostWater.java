class Solution {
    public int maxArea(int[] height) {

        // The idea we use here is to first maximize the length of container.
        // For this we keep 2 pointers one at each end of array for max length.

        // We also initialize maxArea to negative infi to begin with.

        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        // We look for max area till length is not 0 (left and right don't cross).
        while(left <= right)
        {
            // Calculate area by multiplying length with min of the 2 heights available.

            int area = (right - left) * Math.min(height[left],height[right]);

            // Update maxArea with maximum of current maxArea and area calculated 
            // in this iteration.

            maxArea = Math.max(maxArea,area);

            // This is where we update the hegiht. Whichever bar is smaller we move that
            // pointer ahead to get a better bar height.

            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }

        }

        // Finally we return maxArea.

        return maxArea;

    }
}