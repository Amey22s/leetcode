import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Initialize a map to store the number encountered so far and its index.
        Map<Integer,Integer> map = new HashMap<>();

        //Iterate over all the number in the given array.
       for(int i = 0; i < nums.length; i++)
       {

           //key is the complement of the number you currently have.
           int key = target - nums[i];

           // If the complement is present in the map, you have your solution.
           // Else add the current number and its index in the map.
           if(map.containsKey(key))
           {
               return new int[]{i,map.get(key)};
           }
           else
           {
               map.put(nums[i],i);
           }
       }

       // If target is never found return -1 -1 to indicate target not found.
       return new int[]{-1, -1};
    }
}