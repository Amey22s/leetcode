class Solution {
    public boolean isPalindrome(String s) {

        // We are using 2 pointer approach so initialize 
        // left pointer to 0 and right pointer to str length - 1.
        
        int left = 0;
        int right = s.length() - 1;

        // Main idea is to start from extreme ends and keep moving inwards till 
        // we don't get valid (alphanumeric) characters at both pointer indexes.

        // We check whether these two valid values are equal, if yes we move both
        // pointers inward by 1. Else we return false. 

        while(left < right)
        {
            while(left < right && !isAlphaNumeric(s.charAt(left)))
            {
                left++;
            }

            while(left < right && !isAlphaNumeric(s.charAt(right)))
            {
                right--;
            }

            // We convert both valid character to lowercase as case doesn't matter in this problem.

            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            if(leftChar != rightChar)
            {
                return false;
            }
            else
            {
                left++;
                right--;
            }
        }

        return true;
        
    }

// A function which checks whether a character is alphanumeric or not.

    private boolean isAlphaNumeric(char c)
    {
        return (c >= 'A' && c <= 'Z') ||
                 (c >= 'a' && c <= 'z') ||
                 (c >= '0' && c <= '9');
    }
}