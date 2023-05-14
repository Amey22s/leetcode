class Solution {

    // To begin with, we initialize subCount which will store our result.
    
    private int subCount = 0;

    public int countSubstrings(String s) {

        // The main idea here is to iterate over each index in the given string 
        // and exapnded outwards from that index in both directions to get as far as possible
        // staying within bounds of the string as well as maintaining the condition for
        // palindrome i.e. char at left and right pointer should be same.

        // We have to check at each iteration, if every condition is satisfied, we increase 
        // subCount by 1.

        // One more important aspect is that we need to check for odd length palindrome as well
        // as even length palindrome which can be easily done by adjusting left and right ptr
        // accordingly.

        for(int i = 0; i < s.length(); i++)
        {
            // For odd palindromes
            updateSubCount(i,i,s);

            // For even palindromes
            updateSubCount(i,i+1,s);
        }

        return subCount;
        
    }


// This is a helper function to check for all conditions with left and right pointers
// pointing to the mid (start) index from where we start to expand outward. It also updates
// the class variable subCount which stores the result.

    private void updateSubCount(int left, int right, String s)
    {
        while(left >= 0 && right < s.length())
        {
            if(s.charAt(left) == s.charAt(right))
            {
                subCount++;
                left--;
                right++;
            }
            else
            {
                break;
            }
        }
    }
}