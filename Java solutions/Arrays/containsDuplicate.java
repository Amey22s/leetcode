import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Initialize a set to keep record of all the numbers encountered till now.
        
        Set<Integer> set = new HashSet<>();

        // Iterate over all the numbers in the given array and try adding them to the set above.
        // If add fails(element already exits in the set) it'll return false, which indicates
        // duplicate and hence we return true.

        // If add is a success (element is not present in the set) it'll return true, we continue.

        for(int i : nums)
        {
            if(!set.add(i))
            {
                return true;
            }
        }

        //If we are able to go through all elements without duplicates, we return false.
        return false;
        
    }
}