class Solution {

        // To begin with, we initialize 3 values which will store our state of result.
        // Start index of max substring, end index of max substring and length of max
        // substring.

        private int subStart = 0;
        private int subEnd = 0;
        private int maxSubLen =  0;

    public String longestPalindrome(String s) {

        // The main idea here is to iterate over each index in the given string 
        // and exapnded outwards from that index in both directions to get as far as possible
        // staying within bounds of the string as well as maintaining the condition for
        // palindrome i.e. char at left and right pointer should be same.

        // We have to check at each iteration, if every condition is satisfied, we compute 
        // current length of substring. If this length is greater than maxLen encountered till
        // now, we update maxLen, subStart and subEnd as this is now our answer to be returned.

        // One more important aspect is that we need to check for odd length palindrome as well
        // as even length palindrome which can be easily done by adjusting left and right ptr
        // accordingly.

        for(int i = 0; i < s.length(); i++)
        {
            // For odd length palindromes.

            setSubstringParams(i,i,s);

            // For even length palindrome

            setSubstringParams(i,i+1,s);

        }

        // Finally we return the longest palindromic substring with the help of subStart and subEnd.

        return s.substring(subStart,subEnd+1);
    }


// This is a helper function to to check for all conditions with left and right pointers
// pointing to the mid (start) index from where we start to expand outward. It also
// updates the class variables maxSubLen, subStart and subEnd.

    private void setSubstringParams(int left, int right, String s)
    {
        while(left >= 0 && right < s.length())
            {
                if(s.charAt(left) == s.charAt(right))
                {
                    int tempLen = right - left + 1;
                    if(maxSubLen < tempLen)
                    {
                        maxSubLen = tempLen;
                        subStart = left;
                        subEnd = right;
                    }
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