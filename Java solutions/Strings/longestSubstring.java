import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // We initialize a set to keep a record of all the characters present in
        // our current maxsubstring.

        Set<Character> charSet = new HashSet<>();

        // We are using two pointer approach here. So initialize left pointer to 0.
        // Also intialize the result as maxSubstring to 0.

        int left = 0;
        int maxSubstring = 0;

        // We will use a for loop to move our second pointer(right) one step at a time.

        for(int right = 0; right < s.length(); right++)
        {
            // Create a temp char variable to store current character pointed by right pointer.
            char charRight = s.charAt(right);

            // If the character in present in the current substring set, we won't be able to add
            // it immediately. So we first move left pointer forward till the current char
            // is not removed from substring and then add the curret character.

            // If the current character is not present in the set, we simply add it to the set
            // and calculate current substring length. If current substring length is greater 
            // maxSubstring we update it.

            if(charSet.add(charRight))
            {
                int tempLength = right - left + 1;
                maxSubstring = Math.max(maxSubstring,tempLength);
            }
            else
            {
                while(charSet.contains(charRight))
                {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(charRight);
            }

        }

        // Finally we return maxSubstring.

        return maxSubstring;
        
    }
}