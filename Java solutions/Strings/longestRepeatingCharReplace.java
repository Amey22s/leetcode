class Solution {
    public int characterReplacement(String s, int k) {

        // First we initialize a character map to store all uppercase alphabets
        // A = 0 and Z = 25. We also initialize a varialbe to store alphabet 
        // with max frequency.

        int[] charMap = new int[26];
        int maxCharFreq = 0;

        // Next we initialize a variable to store result and a variable to act as left
        // pointer.

        int res = 0;
        int left = 0;

        // The main idea here is that we use a variable sliding window with a condition
        // length of substring till now - max freq of a char in that substring <= k.

        // If the above condition is satisfied, we check current length of substring 
        // against our result so far and update it if needed.

        // If the condition is not met, we shrink our window by moving left pointer
        // and update our charMap accordingly.

        for(int right = 0; right < s.length(); right++)
        {
            int tempLen = right - left + 1;
            charMap[s.charAt(right) - 'A']++;

            // MaxCharFreq is updated by comparing max freq till now and freq of newly 
            // added character in substring.

            // Even if max freq of a char has decreased after moving the left pointer,
            // we won't update it because decreasing the maxCharFreq will only cause
            // the below condition to be false and hence our result is not going to get
            // updated in those cases.

            // Here we are overestimating the maxCharFreq and it works because at some 
            // point in our calculations this max freq was valid and gave us the answer
            // we have now. Now if we want a higher result(higher length of substring),
            // it can happen only if max freq remains same or increases. A decrease in maxFreq
            // is not going to help our cause.

            maxCharFreq = Math.max(maxCharFreq, charMap[s.charAt(right) - 'A']);
            if(tempLen - maxCharFreq <= k)
            {
                res = Math.max(res,tempLen);
            }
            else
            {
                charMap[s.charAt(left) - 'A']--;
                left++;
            }
        }

        // Finally we return the longest repeating character replacement using res. 

        return res; 
    }

}