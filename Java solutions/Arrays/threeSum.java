import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // We first sort the array so we can use the two pointer approach to our advantage 
        // and also eliminate a few repetitive iterations.

        Arrays.sort(nums);

        // Initialize list of list of integers to an empty list.

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++)
        {
            // As the list is sorted if first element is greater than 0, all succeeding 
            // elements will be greater than 0 so we can stop.

            if(nums[i] > 0)
            {
                break;
            }

            // This conditional is there to not consider same elements again which 
            // are at a different index.
            
            if(i != 0 && nums[i] == nums[i-1])
            {
                continue;
            }

            // Now for each i we apply two pointer approach, 1 starting from i + 1
            // other from n - 1.

            int j = i + 1;
            int k = nums.length - 1;

            // Iterate over elements till j and k don't cross each other.

            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];

                // Check is sum is zero, if yes create a temp list of these 3 numbers 
                // and add this temp list to result list.
                
                // If sum is greater than 0 we just move k pointer in as it points to
                // the current highest positive element.

                // If sum is less than 0 we just move j pointer ahead as it points to
                // the current lowest negative element.               

                // Move both pointers to next index.

                if(sum == 0)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);

                    j++;
                    k--;

                    // These conditionals are there to not consider same elements again which 
                    // are at a different index.

                    while(j < k && nums[j] == nums[j-1])
                    {
                        j++;
                    }

                    while(k > j && nums[k] == nums[k+1])
                    {
                        k--;
                    }
                }
                else if(sum > 0)
                {
                    k--;
                }
                else
                {
                    j++;
                }

            }
        }

        // Finally return the output list.
        
        return res;

    }
}